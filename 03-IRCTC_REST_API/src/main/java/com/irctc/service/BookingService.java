package com.irctc.service;

import org.springframework.stereotype.Component;

import com.irctc.request.Passenger;
import com.irctc.response.Ticket;

@Component
public interface BookingService {

	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicket(Integer ticketNumber);
	
	
}
