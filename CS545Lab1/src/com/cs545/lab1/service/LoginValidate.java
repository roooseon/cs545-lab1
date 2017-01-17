package com.cs545.lab1.service;

import com.cs545.lab1.model.Login;

public class LoginValidate {
	
	Login login1 = new Login();
	

	
	public boolean validate(String username, String password){ 
		
		login1.setUserName("admin");
		login1.setPassword("test123");
	    if(username.equals(login1.getUserName()) && password.equals(login1.getPassword())){  
	        return true;  
	    }  
	    else{  
	        return false;  
	    }  
	}  
}
