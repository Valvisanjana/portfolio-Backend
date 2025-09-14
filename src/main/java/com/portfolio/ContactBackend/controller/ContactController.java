package com.portfolio.ContactBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.ContactBackend.Entity.ContactRequest;
import com.portfolio.ContactBackend.service.EmailService;

import jakarta.validation.Valid;

@RestController
public class ContactController {

	@Autowired
	private EmailService emailservice;
	
	 @PostMapping
	    public String sendMessage(@Valid @RequestBody ContactRequest contactReq) {
	        emailservice.sendEmail(
	            contactReq.getName(),
	            contactReq.getEmail(),
	            contactReq.getSubject(),
	            contactReq.getMessage()
	        );
	        return "Message sent successfully ";
	    }
}
