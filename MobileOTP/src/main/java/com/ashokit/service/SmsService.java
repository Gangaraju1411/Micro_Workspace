package com.ashokit.service;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	 private final Config config;

	    @Autowired
	    public SmsService(Config service) {
	        this.config = service;
	    }

	private  String NUMBER = "0123456789";

	private  String ALL_CHAR = NUMBER;
	private  SecureRandom RANDOM = new SecureRandom();

	public String generateOTP() {
		StringBuilder otp = new StringBuilder();
		int length = 4;
		for (int i = 0; i < length; i++) {
			int randomIndex = RANDOM.nextInt(ALL_CHAR.length());
			otp.append(ALL_CHAR.charAt(randomIndex));
		}
		return otp.toString();
	}

	public void sendOtp(PhoneNumber num, String otp) {
		Twilio.init(config.getAccountSid(), config.getAuthToken());

		String messageBody = "Your OTP is: " + otp;

		Message msg = Message.creator(num, config.getFromPhoneNumber(), messageBody).create();

		System.out.println("OTP sent with SID: " + msg.getSid());
	}

}
