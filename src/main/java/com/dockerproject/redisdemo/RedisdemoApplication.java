package com.dockerproject.redisdemo;

import java.util.Random;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.dockerproject.redisdemo.service.EmailsenderService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication

public class RedisdemoApplication {

	@Autowired
	private EmailsenderService emailsenderService;

	public static void main(String[] args) {
		SpringApplication.run(RedisdemoApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		emailsenderService.sendEmail("divyakandhasami@gmail.com", "OTP Verfication", "Hi there,\n" + "\n"
				+ "Thank you for registering with our user management portal 🙌. To complete your registration, please enter the following OTP code:\n"
				+ "\n" + "<OTP 🎉🎉 Code>\n" + "\n"
				+ "This OTP code is valid for 8 minutes only. If you did not request this OTP code, please ignore this email.\n"
				+ "\n" + "Best regards,\n" + "The User Management Portal Team ");
		System.out.println("Email Message sucessfuly.🎉😊🎉.");
	}
}
