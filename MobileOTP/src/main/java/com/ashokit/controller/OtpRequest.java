package com.ashokit.controller;

import com.twilio.type.PhoneNumber;

import lombok.Data;

@Data
public class OtpRequest {
	
	private PhoneNumber toPhoneNumber;

}
