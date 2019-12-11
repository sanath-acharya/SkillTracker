package com.example.demo.dao;



import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AssociateInfo;
import com.example.demo.entity.AssociateSkills;
import com.example.demo.entity.SkillsInfo;
import com.example.demo.repository.AssociateInfoRepository;
import com.example.demo.repository.AssociateSkillsInt;
import com.example.demo.repository.AssociateSkillsRepository;
import com.example.demo.repository.SkillsInfoRepository;
import com.example.demo.service.MailService;

@Repository
@Transactional


public class SkillsDao 
{
	@Autowired
	private AssociateInfoRepository skillsRepo;
	
	@Autowired
	private AssociateSkillsRepository assoRepo;
	
	@Autowired
	private SkillsInfoRepository skillInfoRepo;
	
	@Autowired
	private AssociateSkillsInt assoSkillsRepo;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private MailService mailService;
	


	public void getAssociateInfo(int id)
	{
		System.out.println("In skills dao");
		 skillsRepo.findById(id);
	}
	
	public AssociateInfo findByUserId(int associateId) {
		return skillsRepo.findUserByAssociateId(associateId);
	}
	
	public SkillsInfo findUserById(int skillId) {
		return skillInfoRepo.findUserBySkillId(skillId);
	}
	
	public void getSkillsInfo(int id){
		System.out.println("In skills dao");
	 skillsRepo.findById(id);
	}
	
	public Iterable<AssociateInfo> getAllAssociates() 
	{
		System.out.println("dao hit for all");
		return skillsRepo.findAll();
	}

	public AssociateSkills getAllAssociatesSkills(int id) {
		return assoRepo.findByAidAssociateId(id);
	}

	public Iterable<SkillsInfo> getAllSkills() {
		return skillInfoRepo.findAll();
	}

	@Transactional
	public List<AssociateSkills> getAssociatesSkills() {
		
		return assoRepo.findAll();
	}
	
	@Transactional
	public void updateAssociate(AssociateInfo associateInfo) {
		String email = associateInfo.getAssociateEmail();
		AssociateInfo associate = skillsRepo.findByAssociateEmailStartingWith(email);
		associateInfo.setAssociateId(associate.getAssociateId());
		skillsRepo.save(associateInfo);
		
	}
	
	@Transactional
	public void updateAssociateSkills(AssociateSkills skills) 
	{
		assoRepo.save(skills);
	}
	
	@Transactional
	public AssociateSkills saveAssociateSkills(AssociateSkills skills) {
		return assoRepo.save(skills);
	}
	
	@Transactional
	public void deleteAssociat(String email) {
		String s = email+".com";
		AssociateInfo associateInfo=skillsRepo.findByAssociateEmail(s);
		System.out.print(s);
		int id = associateInfo.getAssociateId();
		System.out.println("Associate id :"+id);
		assoRepo.deleteByAidAssociateId(id);
//AssociateSkills associateSkills=assoRepo.findByAidAssociateId(id);
//		int id1 = associateSkills.getSrNo();
		skillsRepo.deleteById(id);		
//		skillsRepo.deleteById(id);
	}
	
	@Transactional
	public void deleteAssociateSkill(Integer id) {
		assoSkillsRepo.deleteById(id);
		
	}

	@Transactional
	public Iterable<AssociateSkills> deleteAssociatesSkillsByAid(int id) {
		return assoRepo.deleteByAidAssociateId(id);
	}
	
	@Transactional
	public void saveAssociate(AssociateInfo associate) {
		
	
		
		String password= UUID.randomUUID().toString();
		System.out.println(password);
		String arr[]=password.trim().split("-");
		System.out.println(arr[0]);
		mailService.sendEmail(associate.getAssociateEmail(), arr[0]);
		associate.setPassword(bCryptPasswordEncoder.encode(arr[0]));
		System.out.print(associate.getPassword());
		skillsRepo.save(associate);
		
	
	
	}

	public SkillsInfo saveSkills(SkillsInfo skillInfo) {
		return skillInfoRepo.save(skillInfo);
	}

	public List<AssociateInfo> getAssociateName(String name) {
		// TODO Auto-generated method stub
		return skillsRepo.findByAssociateFirstNameStartingWith(name);
	}
	
	public List<AssociateInfo> getAssociateLastName(String name){
		return skillsRepo.findByAssociateLastNameStartingWith(name);
	}
	
	public List<AssociateInfo> getAssociateFisrtAndLastName(String FirstName, String LastName){
		return skillsRepo.findByAssociateFirstNameStartingWithOrAssociateLastNameStartingWith(FirstName, LastName);
	}
	
	public AssociateInfo getAssociateEmail(String email){
		return skillsRepo.findByAssociateEmailStartingWith(email);
	}
	
	public List<AssociateInfo> getAssociateMobile(long mobile){
		return skillsRepo.findByAssociateMobileStartingWith(mobile);
	}
	
	public List<AssociateInfo> findByCountryAndLocation(String country, String location){
		return skillsRepo.findByCountryStartingWithOrLocationStartingWith(country,location);
		}	
	
	public List<AssociateInfo> findByCountry(String country){
		return skillsRepo.findByCountryStartingWith(country);
	}
	
	public List<AssociateInfo> findByLocation(String location){
		return skillsRepo.findByLocationStartingWith(location);
	}
	
	public AssociateInfo verifyAssociate(String email, String pass ) {
		
		
		AssociateInfo associateInfo = skillsRepo.findByAssociateEmailStartingWith(email);
		if (associateInfo != null) {
			if (associateInfo.getAssociateEmail().equals(email)
					&& bCryptPasswordEncoder.matches(pass,associateInfo.getPassword() )) {
				System.out.print("success");
				return associateInfo;
			} else {
				System.out.print("wrong");
				return null;
			}
		} else {
			System.out.print("Null");
			return null;
		}
	}
	
	public List<AssociateSkills> search(String res1,String res2,String res3,String res4,String res5,String res6,String res7) {
		return assoRepo.findByAidAssociateFirstNameStartingWithOrAidAssociateLastNameStartingWithOrAidAssociateEmailStartingWithOrAidLocationStartingWithOrAidCountryStartingWithOrSidSkillNameStartingWithOrSidSkillCategoryStartingWith(res1, res2, res3, res4, res5, res6, res7);
				//return assoRepo.findByAidAssociateFirstNameOrAidAssociateLastNameOrAidAssociateEmailOrAidLocationOrAidCountryOrSidSkillNameOrSidSkillCategory(res1, res2, res3, res4, res5, res6, res7);
	}
	
	//##############################
	@Transactional
	public void deleteSkillById(int id) {
//		skillInfoRepo.deleteById(id);
		
		assoRepo.deleteBySidSkillId(id);
//		
//		int id1 = associateSkills.getSrNo();
//		System.out.println(id1+" thih is associatae skill id");
//		assoRepo.deleteById(id1);
		skillInfoRepo.deleteById(id);
	}



	public List<AssociateSkills> findAssociateSkillByAid(AssociateInfo aid) {
		return assoSkillsRepo.findByAid(aid);
	}

	@Transactional
	public void deleteAssociateSkillBySid(SkillsInfo sid) {
		assoSkillsRepo.deleteBySid(sid);
	}
	@Transactional
	public List<SkillsInfo> searchskill(String res1){
		return skillInfoRepo.findBySkillCategory(res1);
	}
	
	@Transactional
	public SkillsInfo getSkillsInfo(String Sc,String Sn) {
		return skillInfoRepo.findBySkillNameAndSkillCategory(Sc, Sn);
	}
	
	public void forgotPassword(String email) {
		AssociateInfo associateInfo= skillsRepo.findByAssociateEmailStartingWith(email);
		String password= UUID.randomUUID().toString();
		System.out.println(password);
		String arr[]=password.trim().split("-");
		System.out.println(arr[0]);
		mailService.forgotPassword(associateInfo.getAssociateEmail(), arr[0]);
		associateInfo.setPassword(bCryptPasswordEncoder.encode(arr[0]));
		skillsRepo.save(associateInfo);
	}

	public SkillsInfo findBySkillCategoryAndSkillName(String skillcategory,String Skillname) {
		return skillInfoRepo.findBySkillCategoryAndSkillName(skillcategory,Skillname);
	}
	
}