package com.contactapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contactapp.bindings.ContactForm;
import com.contactapp.service.ContactService;

@RestController
public class ContactRestController {
	
	@Autowired
	private ContactService contactservice;

	@PostMapping("/save")
	public String saveContact(@RequestBody ContactForm form) {
		
		String status=contactservice.saveContact(form);
		return status;
		 
	}
	
	@GetMapping("/contacts")
	public List<ContactForm> viewAllContacts(){
		return contactservice.viewContacts();
	}
	
	@GetMapping("/edit/{contactId}")
	public ContactForm editContact(@PathVariable Integer contactId) {
		
		return contactservice.editContact(contactId);
		
	}
	
	@DeleteMapping("/delete/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable Integer contactId){
		
		return contactservice.deleteContact(contactId);
		
	}

}
