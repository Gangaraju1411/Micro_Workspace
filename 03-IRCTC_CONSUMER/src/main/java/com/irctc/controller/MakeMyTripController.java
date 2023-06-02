package com.irctc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.irctc.consumer.request.Passenger;

@Controller
public class MakeMyTripController {

	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute("passenger") Passenger passenger) {

		System.out.println(passenger);
		// TODO:service layer
		return "index";

	}

	@GetMapping("/getticket")
	public String loadForm(Model model) {
		model.addAttribute("passenger", new Passenger());
		return "index";

	}

}
