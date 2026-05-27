package com.msedcl.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.service.OrderService;

public class RestaurantMain {
public static void main(String[] args) {
	
	AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.msedcl.main");
	
	//Inject OrderService object from Spring
	OrderService orderService=applicationContext.getBean(OrderService.class);
	
	orderService.placeOrder();
}
}
