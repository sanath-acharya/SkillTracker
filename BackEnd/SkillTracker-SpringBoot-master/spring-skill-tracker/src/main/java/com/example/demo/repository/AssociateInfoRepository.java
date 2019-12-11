package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.AssociateInfo;


public interface AssociateInfoRepository extends CrudRepository<AssociateInfo, Integer> 
{
	public List<AssociateInfo> findByAssociateFirstNameStartingWith(String associateFirstName);
	public List<AssociateInfo> findByAssociateLastNameStartingWith(String associateLastName);
	public List<AssociateInfo> findByAssociateFirstNameStartingWithOrAssociateLastNameStartingWith(String associateFirstName, String associateLastName);
	public AssociateInfo findByAssociateEmailStartingWith(String associateEmail);
	public List<AssociateInfo> findByAssociateMobileStartingWith(Long associateMobile);
	public List<AssociateInfo> findByCountryStartingWithOrLocationStartingWith(String country,String location);
	public List<AssociateInfo> findByCountryStartingWith(String country);
	public List<AssociateInfo> findByLocationStartingWith(String location);
	
	
	public AssociateInfo findUserByAssociateId(int associateId);
	//Optional<AssociateInfo> findByName(String name);
	public Optional<AssociateInfo> findByAssociateFirstName(String name);
	public List<AssociateInfo> findByCountryAndLocation(String country, String location);
	public AssociateInfo findByAssociateEmail(String s);
}