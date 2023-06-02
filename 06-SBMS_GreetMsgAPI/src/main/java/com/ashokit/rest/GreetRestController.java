package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;

public class GreetRestController {
	
	@Autowired
	private Environment env;
	
	

	@GetMapping("/greet")
	public String getGreetMsg() {
		
		String port = env.getProperty("server port");
		return "Good evening("+port+")";
	}
	
}
