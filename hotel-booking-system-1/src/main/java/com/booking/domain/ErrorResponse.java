package com.booking.domain;

public class ErrorResponse {

	int statusCode;
	
	String message;
	
	
	public ErrorResponse(int statusCode, String msg) {
		this.statusCode = statusCode;
		this.message = msg;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public int getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
