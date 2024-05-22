package com.dockerproject.redisdemo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
@EnableJpaRepositories(basePackages = "com.dockerproject.redisdemo.repo")
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Bean
	@Lazy
	@DependsOn("mailSender")
	public EmailService emailService(JavaMailSender mailsender) {
		return new EmailService(mailsender);
	}

	@Bean
	public OtpService otpService() {
		return new OtpService();
	}

}
