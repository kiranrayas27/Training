package com.msedcl.main;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.domain.LoginDetails;
import com.msedcl.main.service.LoginService;

public class LoginMain {
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Login Id");
		String loginId=scanner.next();
		System.out.println("Enter Password");
		String password=scanner.next();
		
		LoginDetails loginDetails=new LoginDetails(loginId,password);
		
		
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.msedcl.main.service");//creates component annotated object
		System.out.println("-------------");
		LoginService loginService =applicationContext.getBean(LoginService.class);
		LoginService loginService2 =applicationContext.getBean(LoginService.class);//singleton design pattern - one object in memory, many references
		if(loginService.validate(loginDetails))
			System.out.println("Login successful");
		else
			System.out.println("Login failed");
		
		scanner.close();
		
	}
}
