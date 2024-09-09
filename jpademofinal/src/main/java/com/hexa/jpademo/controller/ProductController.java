package com.hexa.jpademo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.hexa.jpademo.customexception.ErrorDetails;
import com.hexa.jpademo.customexception.ResourceNotFoundException;
import com.hexa.jpademo.dto.ProductDTO;
import com.hexa.jpademo.entity.Product;
import com.hexa.jpademo.mapper.ProductMapper;
import com.hexa.jpademo.service.ProductService;

@RestController
@RequestMapping("/api/v1/productapp")
@ResponseBody
public class ProductController {

	private ProductService productService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exceptionObj,
			WebRequest w) {
		ErrorDetails e = new ErrorDetails(LocalDateTime.now(), exceptionObj.getMessage(), w.getDescription(true),
				"USER_NOT_FOUND");

		return null;

	}

	// http://localhost:8080/api/v1/productapp/searchbyname?name=mouse
	@GetMapping("/searchbyname")
	public ResponseEntity<List<ProductDTO>> searchProducts(@RequestParam("name") String productName) {

		List<Product> jpaObjList = this.productService.searchProducts(productName);
		List<ProductDTO> dtoObjList = new ArrayList();

		for (Product p : jpaObjList) {
//			ProductDTO dtoObj = ProductMapper.mapToProductDTO(p);
			
			ProductDTO dtoObj = this.modelMapper.map(p, ProductDTO.class);
			dtoObjList.add(dtoObj);
		}
		return ResponseEntity.ok(dtoObjList);
	}

	@GetMapping("searchallbyid")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam("id") List<Long> idList) {
		List<Product> productList = this.productService.searchProducts(idList);
		return ResponseEntity.ok(productList);
	}

	@GetMapping("/existbyid")
	public boolean existById(@RequestParam("id") Long id) {
		return this.productService.existById(id);
	}

//	@PostMapping("/addproduct")
//	public Product createProduct(@RequestBody Product p) {
//		return this.productService.createProduct(p);
//	}

	@PostMapping("/addproduct")
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO p) {

		// this save entity will return product and we don't want to return the same
		// product in reponse body
		// so we are converting product to dto
		Product savedJPAObj = this.productService.createProduct(p);

		// this is how we did it earlier
//		ProductDTO dtoObject = new ProductDTO(savedJPAObj.getStock(),savedJPAObj.getDescription(),savedJPAObj.getName(),savedJPAObj.isActive(),savedJPAObj.getImageURL());

//		ProductDTO dtoObject = ProductMapper.mapToProductDTO(savedJPAObj);
//		ProductDTO dtoObject = new ProductDTO(savedJPAObj);

		ProductDTO dtoObject = this.modelMapper.map(savedJPAObj, ProductDTO.class);
		return ResponseEntity.ok(dtoObject);
	}

	@PostMapping("/addproducts")
	public ResponseEntity<List<ProductDTO>> createProduct(@RequestBody List<ProductDTO> list) {

		List<ProductDTO> dtoProductList = new ArrayList();
		List<Product> jpaProductList = this.productService.createProducts(list);

		for (Product p : jpaProductList) {
			ProductDTO dtoProduct = ProductMapper.mapToProductDTO(p);
			dtoProductList.add(dtoProduct);
		}
		return ResponseEntity.ok(dtoProductList);
	}

	// http://localhost:8080/api/v1/productapp/searchbyid?id=1
	@GetMapping("/searchbyid")
	public ResponseEntity<Product> searchProductById(@RequestParam("id") Long productId)
			throws ResourceNotFoundException {

		Product p = this.productService.searchProductById(productId);

		System.out.println(p);
		return ResponseEntity.ok(p);

	}

	@GetMapping("/searchall")
	public List<Product> searchProducts() {
		return this.productService.searchProducts();
	}

	@DeleteMapping("/deletebyid")
	public void deleteById(@RequestParam("id") Long id) {
		this.productService.deleteById(id);
	}

	@GetMapping("/searchbynamecontaining")
	public ResponseEntity<List<Product>> findByNameContaining(@RequestParam("name") String productName) {
		List<Product> listOfProducts = this.productService.searchProducts(productName);
		return ResponseEntity.ok(listOfProducts);
	}

	@GetMapping("/searchbytop10name")
	public ResponseEntity<List<Product>> findTop10ByName(@RequestParam("name") String productName) {
		List<Product> listOfProducts = this.productService.searchProducts(productName);
		return ResponseEntity.ok(listOfProducts);
	}

	@GetMapping("/searchfirst2byname")
	public ResponseEntity<List<Product>> findFirst2ByName(@RequestParam("name") String productName) {
		List<Product> listOfProducts = this.productService.searchProducts(productName);
		return ResponseEntity.ok(listOfProducts);
	}

	@GetMapping("/searchproductsbydate")
	public ResponseEntity<List<Product>> getProductsByDateCreatedBetween(
			@RequestParam("startDate") LocalDateTime startDate, @RequestParam("endDate") LocalDateTime endDate) {

		List<Product> productList = this.productService.findByDateCreatedBetween(startDate, endDate);
		return ResponseEntity.ok(productList);
	}

}
