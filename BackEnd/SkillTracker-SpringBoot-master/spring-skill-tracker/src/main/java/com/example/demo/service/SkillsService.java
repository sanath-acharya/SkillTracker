package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SkillsDao;
import com.example.demo.entity.AssociateInfo;
import com.example.demo.entity.AssociateSkills;
import com.example.demo.entity.SkillsInfo;

@Service
public class SkillsService 
{
	@Autowired
	private SkillsDao sd;
	
	@Autowired
	private MailService mailService;
	
	private JavaMailSender javaMailSender;

    public SkillsService(JavaMailSender javaMailSender) {
		super();
		this.javaMailSender = javaMailSender;
	}
    
    
	public void getAssociate(int id)
	{
		 sd.getAssociateInfo(id);
	}

	public void getSkillInfo(int id)
	{
		 sd.getSkillsInfo(id);
	}
	
	public Iterable<AssociateInfo> getAllAssociates() {
		System.out.println("service for all");
		return sd.getAllAssociates();
	}

	public AssociateSkills getAllAssociatesSkills(int id) {
		return sd.getAllAssociatesSkills(id);
	}

	public void updateAssociate(AssociateInfo associate) {
		sd.updateAssociate(associate);
		
	}

	public Iterable<SkillsInfo> getAllSkills()
	{
		return sd.getAllSkills();
	}
	
	public List<AssociateSkills> getAssociatesSkills() {
		return sd.getAssociatesSkills();
	}

	public void updateAssociateSkills(AssociateSkills skills) {
		sd.updateAssociateSkills(skills);
		
	}

	public void deleteAssociate(String email) {
		sd.deleteAssociat(email);
		
	}

	public void deleteAssociateSkill(Integer id) {
		sd.deleteAssociateSkill(id);
		
	}

	

	public Iterable<AssociateSkills> deleteAssociatesSkillsByAid(int id) {
		return sd.deleteAssociatesSkillsByAid(id);
	}

	public void saveAssociate(AssociateInfo associate) {
		sd.saveAssociate(associate);
	}

	public SkillsInfo saveSkills(SkillsInfo skillInfo) {
		return sd.saveSkills(skillInfo);
		
	}
	
	public AssociateSkills saveAssociateSkills(AssociateSkills skills) {
		return  sd.saveAssociateSkills(skills);
	}

	public List<AssociateInfo> getAssociateName(String name) {
		// TODO Auto-generated method stub
		return sd.getAssociateName(name);
	}
	
	public List<AssociateInfo> findByCountryAndLocation(String country, String location){
		return sd.findByCountryAndLocation(country, location);
	}
	
	public List<AssociateInfo> findByLastName(String LastName){
		return sd.getAssociateLastName(LastName);
	}
	
	public List<AssociateInfo> findByFirstNameAndLastName(String FirstName, String LastName){
		return sd.getAssociateFisrtAndLastName(FirstName, LastName);
	}
	
	public AssociateInfo findByEmail(String email){
		return sd.getAssociateEmail(email);
	}
	
	public List<AssociateInfo> findByMobile(long mobile){
		return sd.getAssociateMobile(mobile);
	}
	
	public List<AssociateInfo> findByCountry(String country){
		return sd.findByCountry(country);
	}
	
	public List<AssociateInfo> findByLocation(String location){
		return sd.findByLocation(location);
	}
	
	public AssociateInfo findByUserId(int associateId) {
		return sd.findByUserId(associateId);
	}
	
	public SkillsInfo findUserById(int skillId) {
		return sd.findUserById(skillId);
	}
	
	public AssociateInfo verifyAssociate(String email, String pass) {
		return sd.verifyAssociate(email, pass);
	}
	
	public List<AssociateSkills> search(String res1,String res2,String res3,String res4,String res5,String res6,String res7) {
		return sd.search(res1, res2, res3, res4, res5, res6, res7);
	}
	//#########################
	public void deleteSkillById(int id) {
		sd.deleteSkillById(id);
	}
	
	public List<AssociateSkills> findAssociateSkillByAid(AssociateInfo aid){
		return sd.findAssociateSkillByAid(aid);
	}
	
	public void deleteAssociateSkillBySid(SkillsInfo sid) {
		sd.deleteAssociateSkillBySid(sid);
	}
	
	public List<SkillsInfo> searchskill(String res1){
		return sd.searchskill(res1);
	}
	public SkillsInfo getSkill(String Skillcategory,String Skillname) {
		System.out.println(Skillcategory+"this is service"+Skillname);
		
		return sd.getSkillsInfo(Skillcategory,Skillname);
	}
	public void forgotPassword(String email) {
		 sd.forgotPassword(email);
	}
	public SkillsInfo findBySkillCategory(String skill,String sname) {
		return sd.findBySkillCategoryAndSkillName(skill,sname);
	}
	
	
	
}
