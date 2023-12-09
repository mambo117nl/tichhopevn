package com.ws.soap.email;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class Htmlemail {
	@Autowired
	private JavaMailSender mailSender;

	public void sendHtmlEmail() throws MessagingException {
	    MimeMessage message = mailSender.createMimeMessage();

	    message.setFrom(new InternetAddress("sender@example.com"));
	    message.setRecipients(MimeMessage.RecipientType.TO, "recipient@example.com");
	    message.setSubject("Test email from Spring");

	    String htmlContent = "<h1>This is a test Spring Boot email</h1>" +
	                         "<p>It can contain <strong>HTML</strong> content.</p>";
	    message.setContent(htmlContent, "text/html; charset=utf-8");

	    mailSender.send(message);
	}


	public void sendEmailFromTemplate() throws MessagingException {
	  MimeMessage message = mailSender.createMimeMessage();

	  message.setFrom(new InternetAddress("sender@example.com"));
	  message.setRecipients(MimeMessage.RecipientType.TO, "recipient@example.com");
	  message.setSubject("Test email from my Springapplication");

	  // Read the HTML template into a String variable
	  String htmlTemplate = "" ; //readFile("template.html");

	  // Replace placeholders in the HTML template with dynamic values
	  htmlTemplate = htmlTemplate.replace("${name}", "John Doe");
	  htmlTemplate = htmlTemplate.replace("${message}", "Hello, this is a test email.");

	  // Set the email's content to be the HTML template
	  message.setContent(htmlTemplate, "text/html; charset=utf-8");

	  mailSender.send(message);
	}
	
	public void sendEmailWithAttachment(String to, String subject, String body) throws MessagingException, IOException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body);

		FileSystemResource file = new FileSystemResource(new File("attachment.jpg"));
		helper.addAttachment("attachment.jpg", file);

		mailSender.send(message);
		}
}
