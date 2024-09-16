package com.hexa.jpademo.dto;

import com.hexa.jpademo.entity.Product;

import jakarta.validation.constraints.NotEmpty;

public class ProductDTO {
	
	@NotEmpty
	private String stock;
	@NotEmpty
	private String description;
	@NotEmpty
	private String name;
	private boolean active;
	private String imageURL;
	
	public ProductDTO() {
		super();
	}
	
	// copy constructor
	public ProductDTO(Product modelObj) {
		super();
		this.stock = modelObj.getStock();
		this.description = modelObj.getDescription();
		this.name = modelObj.getName();
		this.active = modelObj.isActive();
		this.imageURL = modelObj.getImageURL();
		
	}
	public ProductDTO(String stock, String description, String name, boolean active, String imageURL) {
		super();
		this.stock = stock;
		this.description = description;
		this.name = name;
		this.active = active;
		this.imageURL = imageURL;
	}
	
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	

}
