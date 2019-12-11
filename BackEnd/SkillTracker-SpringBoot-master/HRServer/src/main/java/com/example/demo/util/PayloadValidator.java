package com.example.demo.util;

import com.example.demo.entity.HR;

public class PayloadValidator {
	
	public static boolean validateCreatePayload(HR hr){
		if (hr.getId() > 0){
			return false;
		}
		return true;
	}

}
