package com.hexa.jpademo.customexception;

import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDateTime t;
	private String message;
	private String path;
	private String errorCode;
	
	public ErrorDetails(LocalDateTime t, String message, String path, String errorCode) {
		super();
		this.t = t;
		this.message = message;
		this.path = path;
		this.errorCode = errorCode;
	}
	
	
	
	
}
