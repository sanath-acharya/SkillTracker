package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.HR;


@Repository("hRLoginRepository")
public interface HRLoginRepository extends CrudRepository<HR, Integer> {
		
	HR findByUserEmail(String name);
	HR findById(int id);
	List<HR> findAll();
	
}
