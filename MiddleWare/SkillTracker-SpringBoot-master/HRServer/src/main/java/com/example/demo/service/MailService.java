package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.HR;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class MailService {
	
	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	/*public void sendEmail(HR hr) throws MailException 
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(hr.getUserEmail());
		mail.setSubject("Confidential - Password Reset");
		mail.setText("You can reset the password by clicking on this link http://localhost:4200/passwordPage");
		javaMailSender.send(mail);
		System.out.println("mail sent");
	}

	public void sendEmailTo(String email) throws MailException 
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject("Welcome message");
		mail.setText("Welcome to skill hunt website.");
		javaMailSender.send(mail);
		System.out.println("mail sent");
	}*/
	
}