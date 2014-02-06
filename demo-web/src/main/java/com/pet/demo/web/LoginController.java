package com.pet.demo.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.pet.demo.model.Account;
import com.pet.demo.service.PetDemoService;

@Controller
public class LoginController {

    private final PetDemoService petDemoService;
    
    @Autowired
    public LoginController(PetDemoService petDemoService) {
		this.petDemoService = petDemoService;
	}

	@RequestMapping(value = "/welcome")
    public String toWelcome(Map<String, Object> model) {
        return "welcome";
    }
	
	@RequestMapping(value = "/login")
    public String initLoginForm(Map<String, Object> model) {
		Account account = new Account();
        model.put("account", account);
        return "login";
    }
	
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String validatorAccount(Account account, BindingResult result, SessionStatus status, Model model, HttpSession session ) {
    	Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account.getUserName(), account.getPassword()); 
        //token.setRememberMe(true);
    	
        try {
        	currentUser.login(token);
        }catch (AuthenticationException e) {
            token.clear();
            e.printStackTrace();
            return "login";
        }
        
        
        if(currentUser.isAuthenticated()){ 
        	session.setAttribute("userinfo", account); 
        	return "welcome";
        	
        }else{
        	return "login";
        }
        /*
        if (result.hasErrors()) {
            return "login";
        } else {
        	//Account account1 = this.petDemoService.findAccountByUsername(account.getUserName(), account.getPassword());
        	Account account1 = null;
            if(account1 == null){
            	result.rejectValue("userName", "invalidaccount");
            	result.rejectValue("password", "invalidaccount");
            	return "login";
            }
        }
        return "welcome";
        */
    }
    
}
