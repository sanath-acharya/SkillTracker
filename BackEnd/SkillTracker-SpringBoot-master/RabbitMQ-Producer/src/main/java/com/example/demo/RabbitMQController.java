package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.RabbitMQSender;

@RestController
public class RabbitMQController {
	@Autowired
	RabbitMQSender rabbitMQSender;
	
	@PostMapping("send-mail")
	public HttpStatus producer(@RequestBody User user) {
		rabbitMQSender.send(user);
		return HttpStatus.OK;
	}
	

}
