package com.irctc.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.irctc.consumer.request.Passenger;
import com.irctc.consumer.response.Ticket;

@Service
public class MakeMyTripServiceImpl implements MakeMyTripService {

	private String BOOK_TICKET_URL="http://13.232.253.164:8080/ticket";

	private String GET_TICKET_URL="http://13.232.253.164:8080/ticket/{ticketNum}";

	@Override
	public Ticket bookTicket(Passenger passenger) {
	
		/*
		 * predefined class ,avaliable in spring web mvc
		 * it is responsible to send http request to the given url
		 */
		RestTemplate rt = new RestTemplate();
		/*
		 * url--which we want to access,which data u want to send,
		 */
		ResponseEntity<Ticket> respEntity = rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);
		
		Ticket ticket = respEntity.getBody();
		
		return ticket;
	}

	@Override
	public Ticket getTicketByNum(Integer ticketNumber) {
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> respEntity = rt.getForEntity(GET_TICKET_URL, Ticket.class,ticketNumber);
		
		Ticket ticket = respEntity.getBody();
		
		
		
		return ticket;
	}

	
	
}
