package com.booking.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.booking.domain.CustomAppException;
import com.booking.domain.ErrorResponse;

@RestControllerAdvice
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorResponse errorDetails = new ErrorResponse(500,
				"Something went wrong! Please try again later.");
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CustomAppException.class)
	public final ResponseEntity<ErrorResponse> handleCustomAppException(CustomAppException ex, WebRequest request) {
		ErrorResponse errorDetails = new ErrorResponse(ex.getStatus().value(),
				ex.getMessage());
		return new ResponseEntity<>(errorDetails, ex.getStatus());
	}

}
