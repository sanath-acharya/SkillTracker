package com.example.demo;

import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AssociateInfo 
{	
	private int associateId;
	private String associateFirstName;
	private String associateLastName;
	private String associateEmail;
	private String password;
	private long associateMobile;
	private Date dob;
	private String gender;
	private String location;
	private String country;
	
	
}