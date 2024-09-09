package com.hexa.jpademo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.hexa.jpademo.dto.ProductDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="stock")
	private String stock;
	private String description;
	private String name;
	private boolean active;
	private String imageURL;
	
	@CreationTimestamp
	private LocalDateTime dateCreated;
	@CreationTimestamp
	private LocalDateTime dateUpdated;
	
	public Product() {
		super();
	}
	public Product(String stock, String description, String name, boolean active, String imageURL) {
		super();
		this.stock = stock;
		this.description = description;
		this.name = name;
		this.active = active;
		this.imageURL = imageURL;
	}
	
	public Product(ProductDTO obj) {
		super();
		this.stock = obj.getStock();
		this.description = obj.getDescription();
		this.name = obj.getName();
		this.active = obj.isActive();
		this.imageURL = obj.getImageURL();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	
	

}
