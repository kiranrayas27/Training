package com.msedcl.main.service;

import org.springframework.stereotype.Service;

@Service
public class BillingService {

	public BillingService() {
		System.out.println("Billing Service default constructor called");
	}
	
	public void calculateBill() {
		System.out.println("Restaurant bill calculated for the customer");
	}
}
