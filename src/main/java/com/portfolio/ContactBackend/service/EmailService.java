package com.portfolio.ContactBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	 @Autowired
	    private JavaMailSender mailSender;

	    public void sendEmail(String fromName, String fromEmail, String subject, String messageText) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom(fromEmail); 
	        message.setTo("samraut545@gmail.com");
	        message.setSubject("Portfolio Contact Form: " + subject);
	        message.setText(
	            "Name: " + fromName + "\n" +
	            "Email: " + fromEmail + "\n\n" +
	            "Message:\n" + messageText
	        );

	        mailSender.send(message);
	    }
}
