package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.AssociateInfo;
import com.example.demo.entity.AssociateSkills;
import com.example.demo.entity.SkillsInfo;




public interface AssociateSkillsInt extends CrudRepository<AssociateSkills, Integer>
{
	public List<AssociateSkills> findByAid(AssociateInfo aid);
	
	public void deleteByAidAssociateId(AssociateSkills associateSkills);
	
	public void deleteBySid(SkillsInfo sid);
	
	//@Query(value="select count(*), skill_category from skill s inner join skills_info si where s.skill_id = si.skill_id group by s.skill_id")
	//public Optional<AssociateSkills> CountBySkillCategory();
	
}