package com.irctc.service;

import com.irctc.consumer.request.Passenger;
import com.irctc.consumer.response.Ticket;

public interface MakeMyTripService {

	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicketByNum(Integer ticketNumber);
	
	
}
