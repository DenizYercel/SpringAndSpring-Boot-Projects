package com.deniz.rest;

public class OgrenciNotFoundException extends RuntimeException{

	public OgrenciNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public OgrenciNotFoundException(String message) {
		super(message);
		
	}

	public OgrenciNotFoundException(Throwable cause) {
		super(cause);
		
	}

	public OgrenciNotFoundException() {
		super();
		
	}

	public OgrenciNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}
	
	

	
	
}
