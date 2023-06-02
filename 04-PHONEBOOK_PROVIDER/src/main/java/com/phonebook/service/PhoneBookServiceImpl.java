package com.phonebook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.entity.ContactDetails;
import com.phonebook.repo.PhoneBookRepository;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {

	@Autowired
	private PhoneBookRepository repo;

	@Override
	public String upsert(ContactDetails details) {

		
		
		
		if(details.getId() != null) {
		repo.save(details); // save or update logic based on the id
		return "Updated Successfully";
		}else {
			repo.save(details);
			return "Saved Successfully";
		}
		
	}

	@Override
	public ContactDetails getById(Integer id) {

		Optional<ContactDetails> contact = repo.findById(id);
		if(contact.isPresent()) {
		ContactDetails contactDetails = contact.get();

		return contactDetails;
		}
		
		return null;
	}

	public List<ContactDetails> getAllContacts() {

		List<ContactDetails> allContacts = repo.findAll();

		return allContacts;
				
	}

	@Override
	public String deletById(Integer id) {
		
		repo.deleteById(id);
		
		return "contact deleted successfully";
	}

}
