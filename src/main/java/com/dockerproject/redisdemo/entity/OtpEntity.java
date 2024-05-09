package com.dockerproject.redisdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

 @Entity
 @Data
 public class OtpEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "e_mailId")
	private String emailId;
	
	@Column(name = "otp_pin")
	private String otp;

	public void save(OtpEntity otpEntity) {
		// TODO Auto-generated method stub
		
	}
}
