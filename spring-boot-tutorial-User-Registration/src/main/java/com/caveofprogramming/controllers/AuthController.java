package com.caveofprogramming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.caveofprogramming.model.SiteUser;

@Controller
public class AuthController {

//	@RequestMapping("/admin")
//	String admin() {
//		return "admin";
//	}
	
	@RequestMapping("/login")
	String login() {
		return "app.login";
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	ModelAndView register(ModelAndView modelAndView) {
		
		SiteUser user = new SiteUser();
		
		modelAndView.getModel().put("user", user);
		modelAndView.setViewName("app.register");
		return modelAndView;
	}
	
}