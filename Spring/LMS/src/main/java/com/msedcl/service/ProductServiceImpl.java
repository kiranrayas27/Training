package com.msedcl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.entity.Product;
import com.msedcl.main.repository.LibraryRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private LibraryRepository productRepository;
	
	public ProductServiceImpl(LibraryRepository employeeRepository) {
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
