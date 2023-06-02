package com.phonebook.consumer.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.phonebook.consumer.binding.UserContactDetails;

@Component

public interface ConsumerService {
	
	
	
	public String saveContact (UserContactDetails details);
	
	//public String updateContact (UserContactDetails details);

	
	public UserContactDetails getById(Integer id);
	
	public List <UserContactDetails> getAllContacts();
	
	public String deletById(Integer id);


}
