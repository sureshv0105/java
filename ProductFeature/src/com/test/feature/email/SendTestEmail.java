package com.test.feature.email;


public class SendTestEmail {
	

	
	public static void main(String[] args) {		 
	    String emailID = "email_me@example.com";	    
	    EmailUtil.sendEmail(emailID, null, "SimpleEmail Testing Subject", "SimpleEmail Testing Body");
	}

}
