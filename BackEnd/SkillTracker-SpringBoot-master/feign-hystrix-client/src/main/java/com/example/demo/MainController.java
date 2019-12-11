package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MainController {
	
	@Autowired
	private IntegrationClient integrationClient;
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value="/allAssociate")
	public Iterable<AssociateInfo> allAssociates(){
		return integrationClient.getAllAssociates();
	}

}
