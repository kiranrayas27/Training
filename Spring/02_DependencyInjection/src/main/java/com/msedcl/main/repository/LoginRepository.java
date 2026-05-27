package com.msedcl.main.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.msedcl.main.domain.LoginDetails;

//@Component
@Repository
public class LoginRepository {
	private List<LoginDetails> loginDetailsList=new ArrayList<>();
	
	public LoginRepository() {
		System.out.println("Default constructor of LoginRepository");
	}
	
	public boolean addNewUser(LoginDetails loginDetails) {
		return loginDetailsList.add(loginDetails);
		
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
