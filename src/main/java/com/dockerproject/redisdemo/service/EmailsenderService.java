package com.dockerproject.redisdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
@Service
public class EmailsenderService {
	
	 @Value("${spring.mail.host}")
	  private String mailHost;
	  
	  @Value("${spring.mail.port}")
	  private int mailPort;
	  
	  @Value("${spring.mail.username}")
	  private String mailUsername;
	  
	  @Value("${spring.mail.password}")
	  private String mailPassword;
      
	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("divyakandhasami@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		mailSender.send(message);
		System.out.println( "Mail Sent Successfully.👍.");

	}

}
