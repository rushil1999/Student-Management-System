package com.sms.handler;

public class CustomException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public CustomException() {
		
	}

	public CustomException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}