package com.portfolio.ContactBackend.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {
	@NotBlank 
	private String name;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String subject;

	@NotBlank
	@Size(min = 10, message = "Message must be at least 10 characters")
	private String message;

	

}
