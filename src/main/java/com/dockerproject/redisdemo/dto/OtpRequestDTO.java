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
 private String userName;

	// Getters and setters

	public String getEmailId() {
		return emailId;
	}

	@Override
	public String toString() {
		return "OtpRequestDTO [emailId=" + emailId + ", otp=" + otp + ", userName=" + userName + ", otpRepo=" + otpRepo
				+ ", getEmailId()=" + getEmailId() + ", getUserName()=" + getUserName() + ", getOtpRepo()="
				+ getOtpRepo() + ", getOtp()=" + getOtp() + ", findAll()=" + findAll() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public void setEmailId(String emailId) {
		this.emailId = "divyakandhasami@gmail.com";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public OtpRepo getOtpRepo() {
		return otpRepo;
	}

	public void setOtpRepo(OtpRepo otpRepo) {
		this.otpRepo = otpRepo;
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
