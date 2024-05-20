package com.dockerproject.redisdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
	public class EmailService {

	    @Autowired
	    private JavaMailSender mailSender;

	    public EmailService(JavaMailSender mailSender2) {

		}

		public void sendEmail(String to, String subject, String text) {
	        SimpleMailMessage message  =  new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(text);
	        mailSender.send(message);
	    }
	}


