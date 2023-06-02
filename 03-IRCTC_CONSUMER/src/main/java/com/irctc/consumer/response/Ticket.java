package com.irctc.consumer.response;

import lombok.Data;

@Data
public class Ticket {

	
	private Integer ticketnum;
	private String status;
	private Double ticketCost;
	private String name;
	private String from;
	private String to;
	private String doj;
	private String trainNumber;
	
	
	
	
}
