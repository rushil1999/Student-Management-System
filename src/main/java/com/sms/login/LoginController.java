package com.sms.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.handler.CustomException;

@RestController
@CrossOrigin("http://localhost:4200")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public ResponseEntity<String> logIn(@RequestParam(name = "username") String username, @RequestParam(name = "category") String type, 
			@RequestParam(name = "password") String password) throws JsonProcessingException, CustomException{
		
		//System.out.println("Login Controller");
		String str = loginService.logIn(username, type, password);
		
		
		
		ObjectMapper map = new ObjectMapper();
		
		str = map.writeValueAsString(str);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}

}
