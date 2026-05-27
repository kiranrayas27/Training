package com.msedcl.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.msedcl.main.domain.LoginDetails;
import com.msedcl.main.repository.LoginRepository;

//@Component
@Service// is same as component, only increases readability
@Scope(scopeName = "prototype") // scope default is singleton.
//scope prototype creates object when its refrences are created, getBean is called, on demand object creation
public class LoginService {

	//@Autowired//Default Injection
	private LoginRepository loginRepository;

	//When we comment default constructor and do not use @Autowired, then the parameterised constructor by default becomes Constructor Injection
//	public LoginService() {
//		System.out.println("LoginService constructor called");
//	}

	//@Autowired//Constructor Injection
	public LoginService(LoginRepository loginRepository) {
		super();
		System.out.println("LoginService overloaded constructor");
		this.loginRepository = loginRepository;
	}

	public LoginRepository getLoginRepository() {
		System.out.println("getLoginRepository");
		return loginRepository;
	}

	//@Autowired//Setter Injection
	public void setLoginRepository(LoginRepository loginRepository) {
		System.out.println("setLoginRepository");
		this.loginRepository = loginRepository;
	}
	
	public boolean validate(LoginDetails loginDetails) {
		return loginRepository.validate(loginDetails);
	}
	
	public boolean addNewUser(LoginDetails loginDetails) {
		return loginRepository.addNewUser(loginDetails);
	}

}
