package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class MailService {
	
	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendEmail(String email, String password) throws MailException 
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject("Welcome message");
		mail.setText("Welcome to the Skill hunt Portal. You have to learn more skills to move higher in levels. "
				+ "\nYour username is: "+email+" \nYour password is : "
		+password);
		javaMailSender.send(mail);
		System.out.println("mail sent");
	}
	
	public void forgotPassword(String email, String password) throws MailException 
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject("Password Reset");
		mail.setText("Your password has been reset successfully. "
				+ "\nYour username is: "+email+" \nYour password is : "
		+password);
		javaMailSender.send(mail);
		System.out.println("mail sent");
	}
}