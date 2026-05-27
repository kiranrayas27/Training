package com.msedcl.main.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.msedcl.main.domain.LoginDetails;

@Component
@Scope(scopeName="prototype")//scope default is singleton. 
//scope prototype creates object when its refrences are created, getBean is called, on demand object creation
public class LoginService {
	
public LoginService() {
	System.out.println("LoginService constructor called");
}	
	public boolean validate(LoginDetails loginDetails) {
		if(loginDetails.getLoginId().equals("ADMIN")
				&&
				loginDetails.getPassword().equals("Admin@123"))
			return true;
		else
			return false;
	}
}
