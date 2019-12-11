package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.SkillsInfo;

public interface SkillsInfoRepository extends CrudRepository<SkillsInfo, Integer> 
{
	public SkillsInfo findUserBySkillId(int skillId);
	public List<SkillsInfo> findBySkillCategory(String skill);
	public SkillsInfo findBySkillNameAndSkillCategory(String sc, String sn);
	public SkillsInfo findBySkillCategoryAndSkillName(String skillcategory, String skillname);
}