package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.entity.HR;
import com.example.demo.repository.HRLoginRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class HrServiceApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(HrServiceApplication.class);
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HrServiceApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner setup(HRLoginRepository hrLoginRepository) {
		return (args) -> {
			hrLoginRepository.save(new HR("kavyapoojary989@gmail.com","1234","abcd","abcd","aaa"));
			logger.info("The sample data has been generated");
		};
	}*/

}
