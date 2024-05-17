package com.dockerproject.redisdemo.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.dockerproject.redisdemo.dto.OtpRequestDTO;
import com.dockerproject.redisdemo.entity.OtpEntity;
import com.dockerproject.redisdemo.repo.OtpRepo;

@Service
public class OtpService {

	@Autowired
	OtpRepo otpRepo;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	OtpRequestDTO otpRequestDTO;

	/**
	 * public String sendOtp(OtpRequestDTO otpRequestDTO) { String otp =
	 * generateOtp(); OtpEntity otpEntity = new OtpEntity(); String emailId =
	 * otpRequestDTO.getEmailId(); otpRequestDTO.setEmailId("user@example.com");
	 * String otp1 = otpRequestDTO.getOtp(); otpRequestDTO.setOtp("123456");
	 * otpRepo.save(otpEntity);
	 * redisTemplate.opsForValue().set(otpRequestDTO.getEmailId(), otp); return
	 * "otpRepo is saved Successfully" ; }
	 **/
	/*
	 * (or) public void sendOtp(OtpRequestDTO otpRequestDTO) { String otp =
	 * generateOtp(); OtpEntity otpEntity = new
	 * OtpEntity(otpRequestDTO.getEmailId(), otp); otpRepo.save(otpEntity);
	 * redisTemplate.opsForValue().set(otpRequestDTO.getEmailId(), otp,
	 * otpExpirationTime, TimeUnit.SECONDS);
	 * 
	 * redisTemplate.opsForValue().set(otpRequestDTO.getEmailId(), otp);
	 * System.out.println("Otp saved successfully in redis"); }
	 */

	// Normal sendOtp with Timeunits in second

	/*
	 * public void sendOtp(OtpRequestDTO otpRequestDTO) { String otp =
	 * generateOtp(); OtpEntity otpEntity = new
	 * OtpEntity(otpRequestDTO.getEmailId(), otp); otpRepo.save(otpEntity);
	 * redisTemplate.opsForValue().set(otpRequestDTO.getEmailId(), otp, 8 * 60,
	 * TimeUnit.SECONDS); System.out.println("Otp saved successfully in redis"); }
	 */

	// This will extract the OTP and the timestamp from the string and create an
	// OtpEntity object with the extracted values.
	// sendOtp with current Timestamps

	public void sendOtp(OtpRequestDTO otpRequestDTO) {

		String otpString = generateOtp();
		String[] otpParts = otpString.split("_");
		String otp = otpParts[0];
		long timestamp = Long.parseLong(otpParts[1]);
		OtpEntity otpEntity = new OtpEntity(otpRequestDTO.getEmailId(), otp);
		otpRepo.save(otpEntity);
		redisTemplate.opsForValue().set(otpRequestDTO.getEmailId(), otp, 8 * 60, TimeUnit.SECONDS);
		System.out.println("Otp saved successfully in redis");
	}

	
	
	
	// get all otp
	public List<OtpEntity> getAllOtp() {
		return otpRepo.findAll();
	}

	public OtpEntity update(OtpRequestDTO otpRequestDTO) {

		return otpRepo.save(otpRequestDTO);
	}

	// Generate One Time Password //

	/**
	 * private String generateOtp() { //timeinmilli Random random = new Random();
	 * int otp = random.nextInt(900000) + 100000; return String.valueOf(otp); }
	 **/

	// current timestamp
	private String generateOtp() {
		Random random = new Random();
		int otp = random.nextInt(900000) + 100000;
		long currentTime = System.currentTimeMillis();
		return otp + "_" + currentTime;
	}

	// validate otp with Time unit in seconds
	/*
	 * public String validate(String emailId, String otp) { // Retrieve the OTP from
	 * the database Optional<OtpEntity> optionalOtpEntity =
	 * otpRepo.findByEmailId(emailId); if (!optionalOtpEntity.isPresent()) { // If
	 * the OTP entity is not present in the database, return false return
	 * " Sorry!😁😁 Otp is not valid "; } OtpEntity otpEntity =
	 * optionalOtpEntity.get();
	 * 
	 * // Check if the OTP is still valid if (otpEntity.isExpired()) { // If the OTP
	 * is expired, delete it from the database and return false
	 * otpRepo.delete(otpEntity); //
	 * System.out.println(" Your otp is expired ^_^^_^"); return
	 * "Your otp is expired ^_^^_^ "; }
	 * 
	 * // Compare the OTP provided by the user with the OTP in the database if
	 * (otpEntity.getOtp().equals(otp)) { // If the OTPs match, delete the OTP
	 * entity from the database and return true otpRepo.delete(otpEntity); return
	 * " Your otp is verified "; } else { // If the OTPs do not match, return false
	 * return "your otp is not verified"; }
	 * 
	 * }
	 */

	// validate otp with current Timestamp
	public String validate(String emailId, String otp) {
		Optional<OtpEntity> optionalOtpEntity = otpRepo.findByEmailId(emailId);
		if (!optionalOtpEntity.isPresent()) {
			return " Sorry!😁😁 Otp is not valid ";
		}
		OtpEntity otpEntity = optionalOtpEntity.get();

		long currentTime = System.currentTimeMillis();
		long otpTimestamp = otpEntity.getTimestamp();

		if (currentTime - otpTimestamp > currentTime) {
			otpRepo.delete(otpEntity);
			return "Your otp is expired 😒😒 ";
		}

		if (otpEntity.getOtp().equals(otp)) {
			otpRepo.delete(otpEntity);
			return " Your otp is verified 🎊🎊";
		} else {
			return otp;
		}
	}

}
