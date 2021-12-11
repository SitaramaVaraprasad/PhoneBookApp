package com.contactapp.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contactapp.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {

}
