package com.portfolio.ContactBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.portfolio.ContactBackend.model.ContactForm;
import com.portfolio.ContactBackend.service.EmailService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:5173/")
public class ContactController {

	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
	public ResponseEntity<String> sendContactEmail(@RequestBody ContactForm form) {
	    if(form.getEmail() == null || form.getEmail().isEmpty()) {
	        return ResponseEntity.badRequest().body("Email is required");
	    }
	    try {
	        emailService.sendEmail(
	            form.getName(),
	            form.getEmail(),   
	            form.getSubject(),
	            form.getMessage()
	        );
	        return ResponseEntity.ok("Message sent successfully!");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(500).body("Failed: " + e.getMessage());
	    }
	}

}
