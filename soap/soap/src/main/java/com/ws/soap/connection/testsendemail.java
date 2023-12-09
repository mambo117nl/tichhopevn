package com.ws.soap.connection;

	import java.util.Properties;
	import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.PasswordAuthentication;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;
import jakarta.mail.Authenticator;
	
	public class testsendemail {
	   public static void main(String[] args) {
	      //provide recipient's email ID
	      String to = "jakartato@example.com";
	      //provide sender's email ID
	      String from = "jakartafrom@example.com";
	      //provide Mailtrap's username
	      final String username = "api";
	      //provide Mailtrap's password
	      final String password = "********************************";
	      //provide Mailtrap's host address
	      String host = "send.smtp.mailtrap.io";
	      //configure Mailtrap's SMTP server details
	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");
	      //create the Session object
	      Authenticator authenticator = new Authenticator() {
	protected PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication(username, password);
	}
	};
	Session session = Session.getInstance(props);

	      try {
	    //create a MimeMessage object
	    Message message = new MimeMessage(session);
	    //set From email field
	    message.setFrom(new InternetAddress(from));
	    //set To email field
	    message.setRecipients(Message.RecipientType.TO,
	               InternetAddress.parse(to));
	    //set email subject field
	    message.setSubject("Here comes Jakarta Mail!");
	    //set the content of the email message
	    message.setText("Just discovered that Jakarta Mail is fun and easy to use");
	    //send the email message
	    Transport.send(message);
	    System.out.println("Email Message Sent Successfully");
	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
	   }
	}

