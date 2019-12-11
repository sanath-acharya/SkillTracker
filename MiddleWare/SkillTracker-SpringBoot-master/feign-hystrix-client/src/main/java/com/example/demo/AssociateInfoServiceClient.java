package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@FeignClient("main-skills-tracker")
public interface AssociateInfoServiceClient {
	@GetMapping("/api/associate/all")
	public Iterable<AssociateInfo> getAllAssociates();
		
}
