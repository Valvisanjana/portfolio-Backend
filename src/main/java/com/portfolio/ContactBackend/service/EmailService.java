package com.portfolio.ContactBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	 @Autowired
	    private JavaMailSender mailSender;

	  public void sendEmail(String name, String fromEmail, String subject, String messageBody) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("samraut545@gmail.com");     
	        message.setTo("samraut545@gmail.com");        
	        message.setReplyTo(fromEmail);              
	        message.setSubject(subject);
	        message.setText("Name: " + name + "\nEmail: " + fromEmail + "\n\nMessage:\n" + messageBody);

	        mailSender.send(message);
	    }
}
