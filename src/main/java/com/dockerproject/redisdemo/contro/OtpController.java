package com.dockerproject.redisdemo.contro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dockerproject.redisdemo.dto.OtpRequestDTO;
import com.dockerproject.redisdemo.entity.OtpEntity;
import com.dockerproject.redisdemo.service.OtpService;

@RestController
@RequestMapping("/start")
public class OtpController {

	@Autowired
	private OtpService otpService;

	@PostMapping("/send-otp")
	public String sendOtp(@RequestBody OtpRequestDTO OtpRequestDTO) {
		otpService.sendOtp(OtpRequestDTO);
		return "OTP sent successfully";
	}

	@GetMapping("/getall/otp")
	public List<OtpEntity> getAllOtp() {
		return otpService.getAllOtp();
	}

	@PutMapping("/update/{id}")
	public OtpEntity update(@RequestBody OtpRequestDTO OtpRequestDTO) {
		return otpService.update(OtpRequestDTO);
	}

}
