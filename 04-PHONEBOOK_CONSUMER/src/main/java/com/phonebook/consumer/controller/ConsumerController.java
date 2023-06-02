package com.phonebook.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phonebook.consumer.binding.UserContactDetails;
import com.phonebook.consumer.service.ConsumerService;

@Controller
public class ConsumerController {

	@Autowired
	private ConsumerService service;

	@GetMapping("/")
	public String indexPage(Model model) {

		model.addAttribute("contactDetails", new UserContactDetails());

		return "index";

	}

	@PostMapping("/save")
	public String saveContact(@ModelAttribute("contactDetails") UserContactDetails contactDetails, Model model) {

		String status = service.saveContact(contactDetails);

		model.addAttribute("saveMsg", status);

		model.addAttribute("contactDetails", new UserContactDetails());

		return "index";

	}

	@GetMapping("/retrieveContact")
	public String contactById(@RequestParam("id") Integer id, Model model) {

		UserContactDetails byId = service.getById(id);

		model.addAttribute("userContacts", byId);

		return "contactsList";
	}

	@GetMapping("/viewcontacts")
	public String allContacts(Model model, @ModelAttribute("message") String message) {

		List<UserContactDetails> allContacts = service.getAllContacts();

		model.addAttribute("deleteMsg", message);
		model.addAttribute("userContacts", allContacts);
		return "contactsList";
	}

	@GetMapping("/delete")
	public String deletecontact(@RequestParam("id") Integer id, RedirectAttributes redirect) {

		String status = service.deletById(id);

		// redirectAttributes.addFlashAttribute("message", message);

		redirect.addFlashAttribute("message", status);

		return "redirect:/viewcontacts";
	}

	@GetMapping("/update")
	public String edit(@RequestParam("id") Integer id, Model model) {

		UserContactDetails findById = service.getById(id);

		model.addAttribute("contactDetails", findById);

		return "index";

	}

}
