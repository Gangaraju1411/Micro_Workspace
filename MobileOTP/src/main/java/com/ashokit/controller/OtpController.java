package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.service.Config;
import com.ashokit.service.SmsService;

@RestController
public class OtpController {

	private SmsService service;
	 @Autowired
	    public OtpController(SmsService service) {
	        this.service = service;
	    }

	    
	  
    @PostMapping("/sendotp")
    public void sendOtp(@RequestBody OtpRequest smsRequest) {
        String otp = service.generateOTP();
        service.sendOtp(smsRequest.getToPhoneNumber(), otp);
    }

	
	
	
}
