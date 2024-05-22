package com.dockerproject.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.event.EventListener;

import com.dockerproject.redisdemo.service.EmailService;

@SpringBootApplication
@EnableCaching
public class RedisdemoApplication {
	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {

		SpringApplication.run(RedisdemoApplication.class, args);

	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		emailService.sendEmail("divyabharathikandhasami@gmail.com", "OTP Verfication", "Hi there,\n" + "\n"
				+ "Thank you for registering with our user management portal. To complete your registration, please enter the following OTP code:\n"
				+ "\n" + "<OTP Code>\n" + "\n"
				+ "This OTP code is valid for 5 minutes only. If you did not request this code, please ignore this email.\n"
				+ "\n" + "Best regards,\n" + "The User Management Portal Team ");

		System.out.println("otp is sent to your email successfully");
	}

}
