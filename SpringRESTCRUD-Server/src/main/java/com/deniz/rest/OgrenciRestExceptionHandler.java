package com.deniz.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OgrenciRestExceptionHandler {

	
	//BURASI ASPECT ORIENTED PROGRAMMING GENERIC YAPI
	
	@ExceptionHandler
	public ResponseEntity<OgrenciErrorResponse> handleException (OgrenciNotFoundException exc){
		
		OgrenciErrorResponse error = new OgrenciErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		
		error.setMessage(exc.getMessage());
		
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler
	public ResponseEntity<OgrenciErrorResponse> handleException(Exception e){
		
		OgrenciErrorResponse error= new OgrenciErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}
	
	
}
