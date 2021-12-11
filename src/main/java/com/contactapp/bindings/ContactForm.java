package com.contactapp.bindings;

import java.time.LocalDate;

import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class ContactForm {


	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private String activeSw;
	private LocalDate createdDate;
	private LocalDate updatedDate;

}
