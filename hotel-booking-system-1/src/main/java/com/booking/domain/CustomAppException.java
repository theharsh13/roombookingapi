package com.booking.domain;

import org.springframework.http.HttpStatus;

public class CustomAppException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private HttpStatus status = null;
	
	public CustomAppException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}
	

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	
}
