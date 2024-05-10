package com.dockerproject.redisdemo.contro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dockerproject.redisdemo.dto.OtpRequestDTO;
import com.dockerproject.redisdemo.service.OtpService;

@RestController
@RequestMapping("/start")
public class OtpController {
	
	@Autowired
    private OtpService otpService;
	
	@PostMapping("/send-otp")
    public String sendOtp(@RequestBody OtpRequestDTO otpRequestDTO)
	{
       otpService.sendOtp(otpRequestDTO);
       return "OTP sent successfully";
    }

}
