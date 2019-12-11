package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.model.service.MailService;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MailController {
	
	@Autowired
	private MailService notificationService;


	/**
	 * 
	 * @return
	 */
	@PostMapping("send-mail")
	public void send(@RequestBody User user) {

		/*
		 * Creating a User with the help of User class that we have declared and setting
		 * Email address of the sender.
		 */
		//Receiver's email address
		/*
		 * Here we will call sendEmail() for Sending mail to the sender.
		 */
		try {
			notificationService.sendEmail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
	}
}
