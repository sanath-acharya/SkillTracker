package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class IntegrationClient {
	
	@Autowired
	private AssociateInfoServiceClient associateInfoServiceClient;
	
	@HystrixCommand(fallbackMethod="getAllAssociatesFallback")
	public Iterable<AssociateInfo> getAllAssociates(){
		return this.associateInfoServiceClient.getAllAssociates();
	}
	
	public Iterable<AssociateInfo> getAllAssociatesFallback() {
		System.out.println("=======saveAssociateFallback=========");
		return null;
		
	}
	

	

}
