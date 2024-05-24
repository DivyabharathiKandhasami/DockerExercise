package com.dockerproject.redisdemo;
import java.util.Random;
import java.util.concurrent.TimeUnit;
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

import com.dockerproject.redisdemo.dto.OtpRequestDTO;
import com.dockerproject.redisdemo.entity.OtpEntity;
import com.dockerproject.redisdemo.service.EmailsenderService;
import com.dockerproject.redisdemo.service.OtpService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication

public class RedisdemoApplication {

	private String otp;

	public static void main(String[] args) {
		SpringApplication.run(RedisdemoApplication.class, args);
	}

	/*
	 * @EventListener(ApplicationReadyEvent.class) public void sendMail() {
	 * 
	 * // Autowired the OtpRequestDTO and creating a instance to create a new class
	 * 
	 * // OtpRequestDTO otpRequestDTO = new OtpRequestDTO(); // with the help of
	 * instance to setEmailId. //
	 * otpRequestDTO.setEmailId("divyakandhasami@gmail.com");
	 * 
	 * // Autowired the OtpService and creating a instance to create a new class
	 * 
	 * // OtpService otpService = new OtpService(); // You need to autowire this //
	 * with the help of instance to sendOtp // otpService.sendOtp(otpRequestDTO);
	 * 
	 * // String otp = otpRequestDTO.getOtp(); // Get the generated OTP
	 * 
	 * emailsenderService.sendEmail("divyakandhasami@gmail.com", "OTP Verfication",
	 * "Hi there,\n" + "\n" +
	 * "Thank you for registering with our user management portal 🙌. To complete your registration, please enter the following OTP code:\n"
	 * + "\n" + otp + "\n" +
	 * "This OTP code is valid for 8 minutes only. If you did not request this OTP code, please ignore this email.\n"
	 * + "\n" + "Best regards,\n" + "The User Management Portal Team ");
	 * 
	 * System.out.println("Email Message sent  sucessfuly with otp.🎉😊🎉."); }
	 */

}
