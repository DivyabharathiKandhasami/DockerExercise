package com.dockerproject.redisdemo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.dockerproject.redisdemo.repo")
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Bean
	public OtpService otpService() {
		return new OtpService();
	}

}
