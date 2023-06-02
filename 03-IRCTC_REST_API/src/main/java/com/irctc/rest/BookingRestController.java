package com.irctc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.request.Passenger;
import com.irctc.response.Ticket;
import com.irctc.service.BookingService;

@RestController
public class BookingRestController {

	@Autowired
	private BookingService service;

	
	
	@PostMapping(value = "/ticket", consumes = { "application/json" },   produces = MediaType.APPLICATION_JSON_VALUE )
	
	public ResponseEntity<Ticket> ticketBooking(

			@RequestBody Passenger passenger) {
		Ticket ticket = service.bookTicket(passenger);
		
		System.out.println(ticket);
		
		return new ResponseEntity<>(ticket, HttpStatus.CREATED);

	}

	
	
	
	@GetMapping(value = "/ticket/{ticketNum}", produces = "application/json")

	public Ticket getTicketByNum(@PathVariable Integer ticketNum) {

		return service.getTicket(ticketNum);

	}

}
