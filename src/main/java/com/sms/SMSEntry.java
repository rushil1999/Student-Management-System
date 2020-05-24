package com.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SMSEntry {
	
	public static void main(String args[]) {
		SpringApplication.run(SMSEntry.class, args);
	}

}

//spring.mvc.view.prefix: /WEB-INF/jsp/
//spring.mvc.view.suffix: .jsp
//logging.level.org.springframework.web=INFO