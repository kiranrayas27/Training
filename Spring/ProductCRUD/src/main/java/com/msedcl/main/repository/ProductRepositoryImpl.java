package com.msedcl.main.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.msedcl.main.entity.Product;


@Repository
@Transactional// transaction commits only if everything goes normal, else rolls back
public class ProductRepositoryImpl implements ProductRepository {

	
	private JdbcTemplate jdbcTemplate;
	private static final String ADD_NEW_PRODUCT="insert into product_details(name, price) values(?,?)";
	private static final String SELECT_PRODUCT_BY_NAME="select * from product_details where name like ? ";
	
	
	
	public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
		System.out.println("Overloaded constructor called -ProductRepository");
		this.jdbcTemplate=jdbcTemplate;
	}
	
	@Override
	public Product addNewProduct(Product product) {
		int rowInserted = jdbcTemplate.update(ADD_NEW_PRODUCT, product.getName(),product.getPrice());
		if(rowInserted > 0)
			return product;
		else
		return null;
	}
	

	@Override
	public Product getProductByName(String name) {
		RowMapper<Product> employeeRowMapper=(rs,rowCnt)->
		new Product(rs.getInt("product_id"),rs.getString("name"),rs.getDouble("price"));
		return jdbcTemplate.queryForObject(SELECT_PRODUCT_BY_NAME,employeeRowMapper,name);

	}

	
	
	

}
