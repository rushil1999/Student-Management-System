package com.sms.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class ExeHandler {
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<?> handleException(CustomException c) throws JsonProcessingException{
		
		HttpStatus status = null;
		String str = c.getMessage();
		if(str.equals("Null Entity")) {
			status = HttpStatus.FORBIDDEN;
		}
		else {
			status = HttpStatus.NOT_FOUND;
		}
		ObjectMapper map = new ObjectMapper();
		str = map.writeValueAsString(str);
		return new ResponseEntity<String>(str, status);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleExcpetion(Exception e) throws JsonProcessingException {
		String str = "Server Error";
		ObjectMapper map = new ObjectMapper();
		str = map.writeValueAsString(str);
		return new ResponseEntity<String>(str, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}