package com.hexa.jpademo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductRepoGeneratedMethodTest {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	void findByNameContainingTest() {
		productRepository.findByNameContaining("mouse");
	}
}
