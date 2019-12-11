package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.entity.HR;
import com.example.demo.repository.HRLoginRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class HRLoginServiceTest {
	
	@Mock
	private HRLoginRepository hrLoginRepository;
	
	@InjectMocks
	private HRLoginService hrLoginService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllHR(){
		List<HR> hrList = new ArrayList<HR>();
		hrLoginRepository.save(new HR(1,"kavyapoojary989@gmail","1234","abcd","abcd","aaa"));
		when(hrLoginRepository.findAll()).thenReturn(hrList);
		List<HR> result = hrLoginService.getAllHR();
		assertEquals(0, result.size());
	}
	
	@Test
	public void testGetHRById(){
		HR hr = new HR(1,"kavyapoojary989@gmail.com","1234","abcd","abcd","aaa");
		when(hrLoginRepository.findById(1)).thenReturn(hr);
		HR result = hrLoginService.getHRById(1);
		assertEquals(1, result.getId());
		assertEquals("kavyapoojary989@gmail.com", result.getUserEmail());
		assertEquals("1234", result.getUserPassword());
		assertEquals("abcd", result.getSecurityQuestion());
		assertEquals("abcd", result.getSecurityAnswer());
		assertEquals("aaa", result.getBcryptPass());
	}
	
	@Test
	public void saveHR(){
		HR hr = new HR(8,"admin@gmail.com","1234","abcd","abcd","aaa");
		when(hrLoginRepository.save(hr)).thenReturn(hr);
		HR result = hrLoginService.createHR(hr);
		assertEquals(8, result.getId());
		assertEquals("admin@gmail.com", result.getUserEmail());
		assertEquals("1234", result.getUserPassword());
		assertEquals("abcd", result.getSecurityQuestion());
		assertEquals("abcd", result.getSecurityAnswer());
		assertEquals("aaa", result.getBcryptPass());
	}
	
	
	

}