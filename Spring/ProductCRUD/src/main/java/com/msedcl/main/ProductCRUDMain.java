package com.msedcl.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.entity.Product;
import com.msedcl.service.ProductService;
import com.msedcl.service.ProductServiceImpl;
///////////////////////////////////////////////////
/// DEMONSTRATES SPRING JDBC////////
/// //////////////////////////////////////////////
public class ProductCRUDMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.msedcl");
		ProductService employeeService=applicationContext.getBean(ProductServiceImpl.class);
		Scanner scanner = new Scanner(System.in);
		int employeeId, choice;
		String name, continueChoice, subChoice;
		double salary;

		do {
			System.out.println("Menu");
			System.out.println("1. Add Product");
			
			System.out.println("6. Search Product by Product name");
			
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Name");
				name = scanner.next();
				System.out.println("Enter Price");
				salary = scanner.nextDouble();
				Product employee = new Product(0, name, salary);
				if(employeeService.addNewProduct(employee)!=null) 
					System.out.println("New product added successfully.");
				else
					System.out.println("Cannot add new Product");
				break;
			
			case 6:
				System.out.println("Enter Name to search");
				name = scanner.next();
				Product p=employeeService.getProductByName(name);
				if(p!=null)
				System.out.println(p);
				else
				System.out.println("Product not found");
				break;
			
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue?");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));

	}

	
}
