package com.example.demo.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.demo.entity.HR;



public class PayloadValidatorTest {

	@Test
	public void validatePayLoad() {
		HR hr = new HR(1, "kavyapoojary989@gmail.com","1234","abcd","abcd","aaa");
		assertEquals(false, PayloadValidator.validateCreatePayload(hr));
	}
	
	@Test
	public void validateInvalidPayLoad() {
		HR hr = new HR(0, "kavyapoojary989@gmail.com","1234","abcd","abcd","aaa");
		assertEquals(true, PayloadValidator.validateCreatePayload(hr));
	}
	
	

}