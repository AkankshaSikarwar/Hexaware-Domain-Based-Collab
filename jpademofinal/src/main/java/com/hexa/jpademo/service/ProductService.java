package com.hexa.jpademo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.hexa.jpademo.customexception.ResourceNotFoundException;
import com.hexa.jpademo.dto.ProductDTO;
import com.hexa.jpademo.entity.Product;

public interface ProductService {

	// find by name
	List<Product> searchProducts(String productName);
	
	// save
	public Product createProduct(ProductDTO p);
	
	List<Product> createProducts(List<ProductDTO> productList);
	
	//	findById
	 Product searchProductById(Long id) throws ResourceNotFoundException;
	 boolean existById(Long id);
	 
//		deleteById
	 void deleteById(Long id);
	 
	 // find all
	 List<Product> searchProducts();
	 
	 
	 //find all by id
	 public List<Product> searchProducts(List<Long> idList);
	 List<Product> searchProducts(Long Id);
	  
	 //deletebyobject
	 public String deleteProduct(Product product);
	
	// Generated query by JPA criteria 
	 List<Product> findByNameContaining(String name);
	 List<Product> findFirst2ByName(String name);
	 List<Product> findTop10ByName(String name);
	 List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);
}
