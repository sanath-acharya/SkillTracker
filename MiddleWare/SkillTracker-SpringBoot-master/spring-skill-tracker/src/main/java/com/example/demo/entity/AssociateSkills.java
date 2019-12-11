package com.example.demo.entity;

import java.util.Date;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "skill")
public class AssociateSkills 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sr_no")
	private Integer srNo;	
	@NotNull
	private String certification;
	@NotNull
	private String rating;
	@NotNull
	@Column(name = "start_date")
	private String startDate;
	@NotNull
	@Column(name = "end_date")
	private String endDate;
	@NotNull
	private String duration;
	@NotNull
	private String experience;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "associate_id",nullable = false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	public AssociateInfo aid;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "skill_id",nullable = false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private SkillsInfo sid;
	
}