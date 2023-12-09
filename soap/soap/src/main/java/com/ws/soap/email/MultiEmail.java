package com.ws.soap.email;

import java.util.HashMap;
import java.util.Map;

import SendMail.EmailService;

public class MultiEmail {

	public static void SendMulti() {
	String recipient = "hung117nl@gmail.com";
	String subject = "Hello, ${firstName}!";
	String template = "Hello, ${firstName}!\n\n"
	                  + "This is a message just for you, ${firstName} ${lastName}. "
	                  + "We hope you're having a great day!\n\n"
	                  + "Best regards,\n"
	                  + "The Spring Boot Team";

	Map<String, Object> variables = new HashMap<>();
	variables.put("firstName", "John");
	variables.put("lastName", "Doe");
    EmailService em = new EmailService();
	em.sendEmail(recipient, subject, template);
	}
}
