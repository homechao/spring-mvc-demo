package com.pet.demo.web;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;


public class VetsJsonView extends AbstractView {
	
    protected void renderMergedOutputModel(Map<String, Object> model,  
            HttpServletRequest request, HttpServletResponse response)  
            throws Exception {
        PrintWriter out=response.getWriter();
        //out.println((String)model.get("vets"));
        out.println("dd");
    }
	
}
