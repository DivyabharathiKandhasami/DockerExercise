package com.dockerproject.redisdemo.dto;

import lombok.Data;

    @Data
	public class OtpRequestDTO {
	    private String emailId;
	    private String otp;
		private String userName;
		
		

	    //Getters and setters
	    
		public String getUserName() 
		{
			return userName;
		}
		public void setUserName(String userName)
		{
			this.userName = userName;
		}
		public String getEmailId()
		{
			return emailId;      
		}
		public void setEmailId(String emailId) 
		{
			this.emailId = emailId;
		}
		public String getOtp() 
		{
			return otp;
		}
		public void setOtp(String otp) 
		{
			this.otp = otp;
		}
}
