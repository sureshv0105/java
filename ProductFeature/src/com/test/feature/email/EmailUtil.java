package com.test.feature.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.test.feature.config.Config;


public class EmailUtil {
	
	private final static String SMTPHOST = "mail.smtp.host";	
	private final static String SMTPPORT = "mail.smtp.port";
	private final static String REPLYTOEMAIL = "mail.smtp.replyto.email";
	private final static String DEFAULTFROMEMAIL = "mail.smtp.replyto.email";
	private final static String MAILCONTENTTYPE = "mail.smtp.contenttype";
	private final static String MAILCHARSET = "mail.smtp.charset";
	
	private final static String SMTPUSERNAME = "mail.smtp.auth.username";
	private final static String SMTPPASSWORD = "mail.smtp.auth.password";
	
	

	/**
	 * Utility method to send simple HTML email
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	public static void sendEmail(String toEmail, String fromEmail, String subject, String body){
		try
		{
			Config config = Config.getInstance();
			System.out.println("sendEmail Start");	
			
			fromEmail = (fromEmail == null || "".equals(fromEmail.trim())) ? config.getPropertyValue(DEFAULTFROMEMAIL) : fromEmail; 
			
		    Properties props = System.getProperties();
		    props.put(SMTPHOST, config.getPropertyValue(SMTPHOST));
		    props.put(SMTPPORT, config.getPropertyValue(SMTPPORT));
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.auth", "true");
		    
			//Session session = Session.getInstance(props, null);	
			final String smtpUsername = config.getPropertyValue(SMTPUSERNAME);
			final String smtpPassword = config.getPropertyValue(SMTPPASSWORD); 
			Session session = Session.getInstance(props,
				  new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(smtpUsername, smtpPassword);
					}
				  });			
			
			MimeMessage msg = new MimeMessage(session);
			//set message headers
			msg.addHeader("Content-type", config.getPropertyValue(MAILCONTENTTYPE));
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(fromEmail, "NoReply"));
			msg.setReplyTo(InternetAddress.parse(config.getPropertyValue(REPLYTOEMAIL), false));
			msg.setSubject(subject, config.getPropertyValue(MAILCHARSET));
			msg.setText(body, config.getPropertyValue(MAILCHARSET));
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			
			System.out.println("Message is ready");
			Transport.send(msg);
			System.out.println("EMail Sent Successfully!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
