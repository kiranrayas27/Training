package com.msedcl.main.repository;

import java.util.List;

import com.msedcl.main.entity.Product;

public interface LibraryRepository {
	Product addNewProduct(Product employee);
	
	
	
	Product getProductByName(String name);
	
	
}
