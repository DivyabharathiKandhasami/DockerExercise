package com.dockerproject.redisdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

 @Entity
 @Data
 @Table(name="otp_seq")
 public class OtpEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "e_mailId")
	private String emailId;
	
	@Column(name = "otp_pin")
	private String otp;

	public OtpEntity(String emailId2, String otp2) {
		   this.emailId = emailId2;
		   this.otp =otp2;
	}

	public void save(OtpEntity otpEntity) {
		// TODO Auto-generated method stub
		
	}
}
