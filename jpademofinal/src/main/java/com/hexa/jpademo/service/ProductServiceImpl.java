package com.hexa.jpademo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexa.jpademo.customexception.ResourceNotFoundException;
import com.hexa.jpademo.dto.ProductDTO;
import com.hexa.jpademo.entity.Product;
import com.hexa.jpademo.mapper.ProductMapper;
import com.hexa.jpademo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> searchProducts(String productName) {
		// TODO Auto-generated method stub
		List<Product> productList = this.productRepository.searchProductsHQL(productName);
		return productList;
	}
	
	@Override
	public List<Product> searchProducts() {
		return this.productRepository.findAll();
	}
	
	@Override
	public Product createProduct(ProductDTO p) {
//		Product modelObj = new Product(p.getStock(), p.getDescription(), p.getName(), p.isActive(), p.getImageURL());
		
		//using copy constructor
//		Product modelObj = new Product(p);
//		Product modelObj = ProductMapper.mapToProduct(p);
		
		Product modelObj = this.modelMapper.map(p, Product.class);
		
		return this.productRepository.save(modelObj);
	}
	
	@Override
	public List<Product> createProducts(List<ProductDTO> dtoProductList) {
		
		List<Product> jpaProductList = new ArrayList();
		
		for(ProductDTO p : dtoProductList) {
			Product jpaProduct = ProductMapper.mapToProduct(p);
			jpaProductList.add(jpaProduct);
		}
		return this.productRepository.saveAll(jpaProductList);
	}

	@Override
	public Product searchProductById(Long id) throws ResourceNotFoundException{
		Product obj= this.productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("product","id",id));
		return obj;
	}

	@Override
	public boolean existById(Long id) {
		return this.productRepository.existsById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		this.productRepository.deleteById(id);
		
	}

	@Override
	public List<Product> searchProducts(List<Long> idList) {
		// TODO Auto-generated method stub
		return this.productRepository.findAllById(idList);
	}


	@Override
	public String deleteProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return this.productRepository.findByNameContaining(name);
	}

	@Override
	public List<Product> findTop10ByName(String name) {
		// TODO Auto-generated method stub
		return this.productRepository.findTop10ByName(name);
	}

	@Override
	public List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate) {
		// TODO Auto-generated method stub
		return this.productRepository.findByDateCreatedBetween(startDate, endDate);
	}

	@Override
	public List<Product> findFirst2ByName(String name) {
		// TODO Auto-generated method stub
		return this.productRepository.findFirst2ByName(name);
	}

	@Override
	public List<Product> searchProducts(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}


}
