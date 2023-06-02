package com.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

	@GetMapping("/index")
	public String showHome() {
		return "index";
	}
	
	@GetMapping("/hello")
	public String showHello() {
		return "hello";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
}