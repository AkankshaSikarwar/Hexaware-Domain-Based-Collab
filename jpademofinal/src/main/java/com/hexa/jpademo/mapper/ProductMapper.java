package com.hexa.jpademo.mapper;

import com.hexa.jpademo.dto.ProductDTO;
import com.hexa.jpademo.entity.Product;

public class ProductMapper {

	public static ProductDTO mapToProductDTO(Product model) {
		ProductDTO dto = new ProductDTO(model);
		return dto;
	}
	
	public static Product mapToProduct(ProductDTO dto) {
		Product model = new Product(dto);
		return model;
	}
}
