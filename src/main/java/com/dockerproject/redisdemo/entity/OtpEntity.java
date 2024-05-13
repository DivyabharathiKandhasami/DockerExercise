package com.dockerproject.redisdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
 @Getter
 @Setter
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId(){
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public OtpEntity()
	{
	
    }
	
	public String  save(OtpEntity otpEntity) {
		
		return  null ;
		
	}
}
