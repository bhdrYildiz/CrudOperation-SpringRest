package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CustomerRestExcaptionHandler {
	
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){
		
		CustomerErrorResponse error = new CustomerErrorResponse(
												HttpStatus.NOT_FOUND.value(),
												exc.getMessage(),
												System.currentTimeMillis());
		//return responseEntity
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
		
		public ResponseEntity<CustomerErrorResponse> handleException(Exception exc){
			
			CustomerErrorResponse error = new CustomerErrorResponse(
													HttpStatus.BAD_REQUEST.value(),
													exc.getMessage(),
													System.currentTimeMillis());
			//return responseEntity
			
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
		
	}

}
