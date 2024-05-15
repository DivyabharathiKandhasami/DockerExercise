package com.dockerproject.redisdemo.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dockerproject.redisdemo.dto.OtpRequestDTO;
import com.dockerproject.redisdemo.entity.OtpEntity;

@Repository
public interface OtpRepo extends JpaRepository <OtpEntity,Long> {

	Optional <OtpEntity> findByEmailId(String emailId);

	OtpEntity save(OtpRequestDTO otpRequestDTO);
    
	  
}
