package com.dockerproject.redisdemo.contro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dockerproject.redisdemo.dto.OtpRequestDTO;
import com.dockerproject.redisdemo.entity.OtpEntity;
import com.dockerproject.redisdemo.service.EmailsenderService;
import com.dockerproject.redisdemo.service.OtpService;

@RestController
@RequestMapping("/start")
public class OtpController {

	@Autowired
	private OtpService otpService;

	@Autowired
	private EmailsenderService emailsenderService;

	@PostMapping("/send-otp")
	public String sendOtp(@RequestBody OtpRequestDTO otpRequestDTO) {
		otpService.sendOtp(otpRequestDTO);
		String otp = otpRequestDTO.getOtp();
		emailsenderService.sendEmail(otpRequestDTO.getEmailId(), "OTP Verfication", "Hi, Dear Customer,\n" + "\n"
				+ "Thank you for registering with our user management portal 🙌. To complete your registration, please enter the following OTP code:\n"
				+ "\n" + otp + "\n"
				+ "This OTP code is valid for 8 minutes only. If you did not request this OTP code, please ignore this email.\n"
				+ "\n" + "Best regards,\n" + "The User Management Portal Team ");
		System.out.println("Now @PostMapping is running");

		return "OTP sent successfully to user emailId";

	}

	@GetMapping("/getall/otp")
	public List<OtpEntity> getAllOtp() {
		return otpService.getAllOtp();
	}

	// getting form
	@GetMapping("/form")
	public String showForm() {
		return "form";
	}

	@PutMapping("/update/{id}")
	public OtpEntity update(@RequestBody OtpRequestDTO OtpRequestDTO) {
		return otpService.update(OtpRequestDTO);
	}

	@EventListener(ApplicationReadyEvent.class)
	public String onApplicationReadyEvent() {
		// Handle the ApplicationReadyEvent here
		return " Application Event is started";
	}

}
