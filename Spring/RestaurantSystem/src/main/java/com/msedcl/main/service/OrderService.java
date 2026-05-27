package com.msedcl.main.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

	BillingService billingService;

	public OrderService(BillingService billingService) {
		super();
		System.out.println("OrderService parameterised constructor called");
		this.billingService = billingService;
	}
	
	public void placeOrder() {
		billingService.calculateBill();
		System.out.println("Order placed");
	}
	
	
}
