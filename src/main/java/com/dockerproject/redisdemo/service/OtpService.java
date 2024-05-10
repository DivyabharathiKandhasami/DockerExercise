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
	OtpRepo otpRepo;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	OtpRequestDTO otpRequestDTO;

	/**public String sendOtp(OtpRequestDTO otpRequestDTO) {
        String otp = generateOtp();
        OtpEntity otpEntity = new OtpEntity();
        String emailId = otpRequestDTO.getEmailId();
        otpRequestDTO.setEmailId("user@example.com");
        String otp1 = otpRequestDTO.getOtp();
        otpRequestDTO.setOtp("123456");
        otpRepo.save(otpEntity);
        redisTemplate.opsForValue().set(otpRequestDTO.getEmailId(), otp);
        return "otpRepo is saved Successfully"  ;
    } **/
	
	
	public void sendOtp(OtpRequestDTO otpRequestDTO) {
        String otp = generateOtp();
        OtpEntity otpEntity = new OtpEntity(otpRequestDTO.getEmailId(), otp);
        otpRepo.save(otpEntity);
        redisTemplate.opsForValue().set(otpRequestDTO.getEmailId(), otp);
    }
	
	// Generate One Time Password  // 
	
	private String generateOtp() {
        Random random = new Random();
        int otp = random.nextInt(900000) + 100000;
        return String.valueOf(otp);
    }
	
}
