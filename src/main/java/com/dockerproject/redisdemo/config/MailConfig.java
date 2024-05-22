package com.dockerproject.redisdemo.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class MailConfig {

	/*
	 * @Primary
	 * 
	 * @Bean public JavaMailSender javaMailService(JavaMailSenderImplConfigurer
	 * configurer) { JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	 * mailSender.setHost("smtp.gmail.com"); mailSender.setPort(587);
	 * mailSender.setUsername("divyabharathikandhasami@gmail.com");
	 * mailSender.setPassword("rrvd yomj sode ubbs");
	 * 
	 * Properties properties = new Properties();
	 * properties.setProperty("mail.transport.protocol", "smtp");
	 * properties.setProperty("mail.smtp.auth", "true");
	 * properties.setProperty("mail.smtp.starttls.enable", "true");
	 * properties.setProperty("mail.debug", "true");
	 * 
	 * mailSender.setJavaMailProperties(properties); return mailSender; }
	 */

	@Bean
	public JavaMailSenderImpl javaMailSender() {
		JavaMailSenderImpl mailsender = new JavaMailSenderImpl();
		mailsender.setHost("smtp.example.com");
		mailsender.setPort(587);
		mailsender.setUsername("divyabharathikandhasami@gmail.com");
		mailsender.setPassword("rrvd yomj sode ubbs");
		Properties properties = mailsender.getJavaMailProperties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.debug", "true");
		return mailsender;
	}

	@Autowired
	public void javaMailService(JavaMailSenderImpl mailsender) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("divyabharathikandhasami@gmail.com");
		mailMessage.setTo("divyakandhasami@gmail.com.com");
		mailMessage.setSubject("Test Email");
		mailMessage.setText("This is a test email.");
		mailsender.send(mailMessage);
	}

	/*
	 * @Bean public JavaMailSender mailSender(JavaMailSenderImplConfigurer
	 * configurer) { JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	 * configurer.configure(mailSender); mailSender.setHost("smtp.gmail.com");
	 * mailSender.setPort(587);
	 * mailSender.setUsername("divyabharathikandhasami@gmail.com");
	 * mailSender.setPassword("rrvd yomj sode ubbs"); Properties properties =
	 * mailSender.getJavaMailProperties(); properties.put("mail.transport.protocol",
	 * "smtp"); properties.put("mail.smtp.auth", "true");
	 * properties.put("mail.smtp.starttls.enable", "true");
	 * properties.put("mail.debug", "true"); return mailSender; }
	 */

}
