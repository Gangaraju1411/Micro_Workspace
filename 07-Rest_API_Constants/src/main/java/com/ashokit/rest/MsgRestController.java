package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.constants.AppConstants;
import com.ashokit.prop.AppProperties;

@RestController
public class MsgRestController {

	// @Value("${welcomeMsg")
	// private String wmsg;

	@Autowired
	private AppProperties appProps;

	@GetMapping("/welcome")
	public String getWelcome() {
		return appProps.getMessages().get(AppConstants.GREET_MSG_KEY);

	}

	@GetMapping("/greet")
	public String getGreetMsg() {

		return appProps.getMessages().get(AppConstants.WELCOME_MSG_KEY);

	}

}
