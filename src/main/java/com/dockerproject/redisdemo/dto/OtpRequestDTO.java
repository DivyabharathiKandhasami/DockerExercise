package com.dockerproject.redisdemo.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dockerproject.redisdemo.entity.OtpEntity;
import com.dockerproject.redisdemo.repo.OtpRepo;

import lombok.Data;

@Data
@Repository
public class OtpRequestDTO {
	private String emailId;
	private String otp;
	

	// Getters and setters

	

	public String getEmailId() {
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

	@Autowired
	private OtpRepo otpRepo;

	public List<OtpEntity> findAll() {
		return otpRepo.findAll();
	}

}
