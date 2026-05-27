package com.msedcl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.entity.Product;
import com.msedcl.main.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository employeeRepository) {
		this.productRepository=employeeRepository;
	}
	@Override
	public Product addNewProduct(Product employee) {
		return productRepository.addNewProduct(employee);
	}

	
	@Override
	public Product getProductByName(String name) {
		return productRepository.getProductByName(name);
	}

	
}
