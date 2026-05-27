package com.msedcl.main.entity;

public class Product {
	
	private int productId;
	private String name;
	private double price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String name, double salary) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = salary;
	}

	public int getproductId() {
		return productId;
	}

	public void setproductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setSalary(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", salary=" + price + "]";
	}
	
	
}
