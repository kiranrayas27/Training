package com.msedcl.main.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class UserMain {

	public static void main(String[] args) {
		System.out.println("main start");	
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringConfiguration.class);

		System.out.println("-----------");
		UserService userService = applicationContext.getBean(UserService.class);
		UserService userService2 = applicationContext.getBean(UserService.class);
		System.out.println("++++++++++++");
		userService.createUser("Reema");

		applicationContext.close();
		System.out.println("main end");
	}

}
