package com.dockerproject.redisdemo.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.dockerproject.redisdemo.dto.OtpRequestDTO;
import com.dockerproject.redisdemo.entity.OtpEntity;
import com.dockerproject.redisdemo.repo.OtpRepo;

@Service
public class OtpService {

	@Autowired
	private OtpRepo otpRepo;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	@Autowired
	OtpRequestDTO otpRequestDTO;

	public String sendOtp(OtpRequestDTO otpRequestDTO) {
        String otp = generateOtp();
        OtpEntity otpEntity = new OtpEntity();
        String emailId = otpRequestDTO.getEmailId();
        otpRequestDTO.setEmailId("user@example.com");
        String otp1 = otpRequestDTO.getOtp();
        otpRequestDTO.setOtp("123456");
        otpEntity.save(otpEntity);
        redisTemplate.opsForValue().set(otpRequestDTO.getEmailId(), otp);
        return "Otp is sended to the otpEntity";
    }
	
	
	
	
	
	
	
	
	private String generateOtp() {
        Random random = new Random();
        int otp = random.nextInt(900000) + 100000;
        return String.valueOf(otp);
    }
	
}
