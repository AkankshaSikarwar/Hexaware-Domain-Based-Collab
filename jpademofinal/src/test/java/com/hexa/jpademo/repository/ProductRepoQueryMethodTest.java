package com.hexa.jpademo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexa.jpademo.entity.Product;

@SpringBootTest
public class ProductRepoQueryMethodTest {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	void findName() {
		List<Product> productList = productRepository.searchProductsHQL("mouse");
		System.out.println(productList);
	}
	
}
