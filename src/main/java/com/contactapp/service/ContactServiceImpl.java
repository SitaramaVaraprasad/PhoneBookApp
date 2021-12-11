package com.contactapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactapp.bindings.ContactForm;
import com.contactapp.entities.Contact;
import com.contactapp.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public String saveContact(ContactForm form) {
		// TODO Auto-generated method stub
		// we have received form binding object
		// Repository save method expecting entity data
		//So copy the data from form binding object to entity data
		Contact entity=new Contact();
		BeanUtils.copyProperties(form, entity);
		entity.setActiveSw("Y");
		entity=contactRepository.save(entity);
		if(entity.getContactId()!=null)
			return "success";
		
		return "failure";
	}

	@Override
	public List<ContactForm> viewContacts() {
		// TODO Auto-generated method stub
		List<ContactForm> dataList=new ArrayList<>();
		List<Contact> contact=contactRepository.findAll();
		
		for(Contact entity:contact) {
			ContactForm form=new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
		return null;
	}

	@Override
	public ContactForm editContact(Integer contactId) {
		
		Optional<Contact> contact=contactRepository.findById(contactId);
		if(contact.isPresent()) {
			Contact entity=contact.get();
			ContactForm form=new ContactForm();
			BeanUtils.copyProperties(entity, form);
			return form;
		}
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		
		contactRepository.deleteById(contactId);
		return viewContacts();
	}

}
