package com.pet.demo.web;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.pet.demo.model.Account;
import com.pet.demo.service.PetDemoSecurityService;

@Controller
public class LoginController {

    private final PetDemoSecurityService petDemoSecurityService;
    
    @Autowired
    public LoginController(PetDemoSecurityService petDemoSecurityService) {
		this.petDemoSecurityService = petDemoSecurityService;
	}
    
    @ModelAttribute("regAccount")
    public Account populatePetTypes() {
        return new Account();
    }

	@RequestMapping(value = "/welcome")
    public String toWelcome() {
        return "welcome";
    }
	
	@RequestMapping(value = "/unauthorzied")
    public String toUnauthorized() {
        return "unauthorized";
    }
	
	@RequestMapping(value = "/login")
    public String initLoginForm(Map<String, Object> model) {
		Subject currentUser = SecurityUtils.getSubject();
        if(currentUser.isAuthenticated()){ 
        	return "welcome";
        }
		Account account = new Account();
		Account regAccount = new Account();
		model.put("account", account);
		model.put("regAccount", regAccount);

        return "login";
    }
	
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String validatorAccount(Account account, BindingResult result, SessionStatus status, Model model, HttpSession session ) {
    	Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account.getUserName(), account.getPassword()); 
    	
        try {
        	currentUser.login(token);
        }catch (AuthenticationException e) {
            token.clear();
        	result.rejectValue("userName", "invalidaccount");
        	result.rejectValue("password", "invalidaccount");
            return "login";
        }
        
        if(currentUser.isAuthenticated()){ 
        	return "welcome";
        	
        }else{
        	return "login";
        }
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAccount(@Valid @ModelAttribute("regAccount") Account account,Map<String, Object> model, BindingResult result) {
    	Subject currentUser = SecurityUtils.getSubject();
        if(currentUser.isAuthenticated()){
        	result.rejectValue("userName", "invalidaccount");
        }
        
        Account loginAccount = new Account();
		model.put("account", loginAccount);
		
		new AccountValidator().validate(account, result);
		
		account.setStatus("enabled");
		
        if (result.hasErrors()) {
            return "login";
        } else {
            this.petDemoSecurityService.saveUser(account);
            return "login";
        }
        
    }
    
	@RequestMapping(value = "/login/checkLoginName")
	@ResponseBody
	public String checkLoginName(@RequestParam("userName") String loginName) {
		try{
			if(petDemoSecurityService.findAccountByUsername(loginName) == null) {
				return "true";
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return "false";
	}

}
