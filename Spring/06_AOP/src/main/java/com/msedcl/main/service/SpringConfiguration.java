package com.msedcl.main.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.msedcl.main.aspect.LoggingAspect;


@Configuration
//@ComponentScan(basePackages = "com.msedcl.main")
@EnableAspectJAutoProxy
public class SpringConfiguration {
	
	//Spring COnfiguration
	//a. Annotataion  Configuration
	//b. Java Configuration
	public SpringConfiguration() {
		System.out.println("Default Constructor Called - SpringConfiguration");
	}

	@Bean
	UserService getUserService() {
		System.out.println("SpringConfiguration Class - getUserService()");
		return new UserService();
	}
	
	@Bean
	LoggingAspect getLoggingAspect() {
		System.out.println("SpringConfiguration Class - getLoggingAspect()");
		return new LoggingAspect();
	}
	
}
