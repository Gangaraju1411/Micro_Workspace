package com.phonebook.consumer.service;

import java.util.List;

import org.springframework.cglib.core.Block;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.phonebook.consumer.binding.UserContactDetails;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	// TODO: get the all url patterns of provider

	private String SAVE_CONTACT_URL = "http://localhost:9088/savecontact";
	// private String UPDATE_CONTACT_URL = "http://localhost:9088/getcontact";

	private String GET_CONTACT_URL = "http://localhost:9088/getcontact/{id}";

	private String GETALL_CONTACT_URL = "http://localhost:9088/getAllcontacts";

	private String DELETE_CONTACT_URL = "http://localhost:9088/delete/{id}";

	

	
	@Override
	public String saveContact(UserContactDetails details) {

		// get the instance of webclient (impl class)
		WebClient webClient = WebClient.create();

		// send the post request with contact details data & map response to ticket obj

		String status = webClient.post().uri(SAVE_CONTACT_URL).bodyValue(details).retrieve().bodyToMono(String.class)
				.block();

		return status;
	}

	/*
	 * @Override public String updateContact(UserContactDetails details) {
	 * 
	 * WebClient webClient = WebClient.create();
	 * 
	 * String status = webClient.post()
	 * 
	 * .uri(UPDATE_CONTACT_URL).bodyValue(details).retrieve().bodyToMono(String.
	 * class).block();
	 * 
	 * return status; }
	 */

	@Override
	public UserContactDetails getById(Integer id) {

		// get the instance of webclient (impl class)
		WebClient webClient = WebClient.create();

		// send the request and map response to userContact details obj

		UserContactDetails contactDetails = webClient.get()// get method to make a get request
				.uri(GET_CONTACT_URL, id).retrieve() // above url gives response and retrieve that response
				.bodyToMono(UserContactDetails.class)// mapping that response to this class object
				.block();// sync call

		return contactDetails;
	}

	@Override
	public List<UserContactDetails> getAllContacts() {

		WebClient webClient = WebClient.create();

		List<UserContactDetails> allContacts = webClient.get().uri(GETALL_CONTACT_URL).retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<UserContactDetails>>() {
				}).block();

		return allContacts;
	}

	@Override
	public String deletById(Integer id) {

		WebClient webClient = WebClient.create();

		String status = webClient.delete()

				.uri(DELETE_CONTACT_URL, id).retrieve().bodyToMono(String.class).block();

		return status;
	}

}
