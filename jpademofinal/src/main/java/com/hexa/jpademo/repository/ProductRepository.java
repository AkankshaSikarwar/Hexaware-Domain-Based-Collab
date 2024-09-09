package com.hexa.jpademo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexa.jpademo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	// HQL / JPQL both are same
	@Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%',:productName,'%') OR "
			+ "p.description LIKE CONCAT('%',:productName,'%')")
	List<Product> searchProductsHQL(String productName);
	
	//Native SQL
		@Query(value="SELECT * FROM products p WHERE p.name LIKE CONCAT('%',:productName,'%')"+
				"OR p.description LIKE  CONCAT('%',:productName,'%')",nativeQuery=true)
		List<Product> searchProductsSQL(String productName);
		
		// Generated query by JPA criteria
		List<Product> findByNameContaining(String name);
		List<Product> findFirst2ByName(String name);
		List<Product> findTop10ByName(String name);
		List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

}
