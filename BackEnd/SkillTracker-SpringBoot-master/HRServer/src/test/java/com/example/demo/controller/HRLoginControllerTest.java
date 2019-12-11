package com.example.demo.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.HrServiceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HrServiceApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HRLoginControllerTest {

	@Autowired
	private Environment env;
	private MockMvc mockMvc;
	org.slf4j.Logger log = LoggerFactory.getLogger(HRLoginControllerTest.class);
	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		log.info("context loaded sucessfully... Listening on port: " + env.getProperty("server.port"));
	}

	@Test
	public void verifyAllHRList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hrDetails/all").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(1))).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void verifyHRById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/HR/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").exists()).andExpect(jsonPath("$.userEmail").exists())
				.andExpect(jsonPath("$.userPassword").exists()).andExpect(jsonPath("$.securityQuestion").exists())
				.andExpect(jsonPath("$.securityAnswer").exists()).andExpect(jsonPath("$.bcryptPass").exists())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.userEmail").value("kavyapoojary989@gmail.com"))
				.andExpect(jsonPath("$.userPassword").value("1234"))
				.andExpect(jsonPath("$.securityQuestion").value("abcd"))
				.andExpect(jsonPath("$.securityAnswer").value("abcd")).andExpect(jsonPath("$.bcryptPass").value("aaa"))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void verifySaveHR() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/create-hr/").contentType(MediaType.APPLICATION_JSON).content(
				"{\"userEmail\" : \"kavya@gmail.com\", \"userPassword\" : \"12345\" , \"securityQuestion\" : \"abcd\", \"securityAnswer\" : \"bcdf\", \"bcryptPass\" : \"aaa\"}")
				.accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.userEmail").exists()).andExpect(jsonPath("$.userPassword").exists())
				.andExpect(jsonPath("$.securityQuestion").exists()).andExpect(jsonPath("$.securityAnswer").exists())
				.andExpect(jsonPath("$.bcryptPass").exists())
				.andExpect(jsonPath("$.userEmail").value("kavya@gmail.com"))
				.andExpect(jsonPath("$.userPassword").value("12345"))
				.andExpect(jsonPath("$.securityQuestion").value("abcd"))
				.andExpect(jsonPath("$.securityAnswer").value("bcdf")).andExpect(jsonPath("$.bcryptPass").value("aaa"))
				.andDo(print());
	}

	@Test
	public void verifyUpdateToDo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.patch("/updateHR/").contentType(MediaType.APPLICATION_JSON).content(
				"{\"id\": \"2\",\"userEmail\" : \"kavya@gmail.com\", \"userPassword\" : \"1234\" , \"securityQuestion\" : \"abcd\", \"securityAnswer\" : \"abcd\", \"bcryptPass\" : \"aaa\"}")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print());
	}

}