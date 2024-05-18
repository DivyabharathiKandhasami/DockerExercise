package com.dockerproject.redisdemo.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	@Autowired
	@Qualifier("javaMailSender")
	private JavaMailSender javaMailSender;
	
	@Bean
	public JavaMailSender javaMailService(JavaMailSenderImplConfigurer configurer) {
	JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
	javaMailSender.setHost("smtp.gmail.com");
    javaMailSender.setPort(587);
    

    javaMailSender.setUsername("divyabharathikandhasami@gmail.com");
    javaMailSender.setPassword("rrvd yomj sode ubbs");

    Properties properties = new Properties();
    properties.setProperty("mail.transport.protocol", "smtp");
    properties.setProperty("mail.smtp.auth", "true");
    properties.setProperty("mail.smtp.starttls.enable", "true");
    properties.setProperty("mail.debug", "true");

    javaMailSender.setJavaMailProperties(properties);
    return javaMailSender;
		
	}
	

    @Bean
    public JavaMailSenderImpl javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.example.com");
        mailSender.setPort(587);
        mailSender.setUsername("divyabharathikandhasami@gmail.com");
        mailSender.setPassword("rrvd yomj sode ubbs");
        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");
        return mailSender;
    }
	
	
	
	@Autowired
	public void javaMailService(JavaMailSenderImpl javaMailSender) {
	    SimpleMailMessage mailMessage = new SimpleMailMessage();
	    mailMessage.setFrom("your-email-address@example.com");
	    mailMessage.setTo("recipient-email-address@example.com");
	    mailMessage.setSubject("Test Email");
	    mailMessage.setText("This is a test email.");
	    javaMailSender.send(mailMessage);
	}

}
