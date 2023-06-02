package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.feign.GreetFeirnClient;

@RestController
public class WecomeRestController {

	
		
		@Autowired
		private GreetFeirnClient greetFeignClient;
		
		@GetMapping("/welcome")
		public String getWelcomeMsh() {
			
			String invokeGreetApi = greetFeignClient.invokeGreetApi();
			
			return invokeGreetApi + ", Welcome To Our Institute";
		}
	
	
}
