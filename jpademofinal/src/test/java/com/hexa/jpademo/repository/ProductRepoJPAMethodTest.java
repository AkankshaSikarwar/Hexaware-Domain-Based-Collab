package com.hexa.jpademo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexa.jpademo.entity.Product;

@SpringBootTest
public class ProductRepoJPAMethodTest {

	@Autowired
	private ProductRepository productRepository;

//	@Test
//	void saveTest() {
//		Product product = new Product("keyboard", "Logitech Wireless Mouse", "Logitech keyboard", false, "");
//		productRepository.save(product);
//	}

//	@Test
//	void updateUsingSaveMethodTest() {
//		Long id = 1L;
//		Product product = productRepository.findById(id).get();
//
//		// Update
//		product.setName("Laptop");
//		product.setDescription("Intel Core i5");
//		productRepository.save(product);
//		// entity manager invokes persist() method if it is saved for first time
//		// merge() for update
//	}

//	void findByIdTest() {
//		Long id = 4L;
//		Product product = productRepository.findById(id).get();
//
//	}

//	saveall
	@Test
	void saveAllTest() {
		List<Product> productList = new ArrayList();
		
		Product product1 = new Product("Mouse", "Logitech Wireless Mouse", "Mouse", true,"mouse.jpeg");
		Product product2 = new Product("Laptop", "Laptop with Intel Core i5", "Laptop", true,"laptop.jpeg");
		
		productList.add(product1);
		productList.add(product2);
		
		productRepository.saveAll(productList);
	}

//	findall
	void findAllTest() {
		List<Product> productList = productRepository.findAll();
	}

//	deletebyid
//	@Test
//	void deleteByIdTest() {
//		Long id = 17L;
//		productRepository.deleteById(id);
//		
////		Optional<Product> product = productRepository.findById(id);
////		
////		if(product!=null) {
////			productRepository.deleteById(id);
////		}
//	}

//	delete
//	@Test
//	void deleteTest() {
//		Long id = 4L;
//		Product product = productRepository.findById(id).get();
//		productRepository.delete(product);
//	}

//	deleteall
//	@Test
//	void deleteAllByIdTest() {
//
//		List<Long> idList = new ArrayList();
//
//		idList.add(3L);
//		idList.add(6L);
//		idList.add(9L);
//
//		productRepository.deleteAllById(idList);
//	}

//	@Test
//	void deleteAllTest() {
//		productRepository.deleteAll();
//	}

//	count()
	@Test
	void countTest() {

		Long count = productRepository.count();
	}

}
