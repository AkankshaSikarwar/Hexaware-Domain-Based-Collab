package com.hexa.jpademo.customexception;

public class ResourceNotFoundException extends Exception{

	private String resourceName;
	private String fieldName;
	private Long fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
		super();
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getMessage() {
		return "Resource not found";
		
	}
	
}
