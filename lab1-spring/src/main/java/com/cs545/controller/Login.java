package com.cs545.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cs545.model.User;
import com.cs545.service.AuthenticationService;

@Controller
public class Login {
	
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public String login(Model model){
		//System.out.println("I AM HERE");
		return "login";
	}
	
	@RequestMapping(value = "/authentication", method= RequestMethod.POST)
	public String loginAuthenticate(Model model,@ModelAttribute("") User user){
		//System.out.println("I AM HERE");
		//HttpSession session=request.getSession();
		
		AuthenticationService as = new AuthenticationService();
		
		System.out.println(user.getUsername());
		
		boolean flag = false;
		String result = null;
		try{
			flag = as.authenticateLogin(user);
			if(flag){
				model.addAttribute("userName",user.getUsername());
				model.addAttribute("passWord",user.getPassword());
				result = "welcome";
				
			}else{
				model.addAttribute("msgLoginFailed", "Username and/or Password Incorrect.");
				result = "login";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
		
	}

}
