package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.HR;
import com.example.demo.service.HRLoginService;
import com.example.demo.service.MailService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value= "/api/**", method=RequestMethod.OPTIONS)

public class HRLoginController
{
	@Autowired
	HRLoginService service;
	
	
	@Autowired
	private MailService notificationService;
	
	/*public void corsHeaders(HttpServletResponse response) {
	    response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
	    response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
	    response.addHeader("Access-Control-Max-Age", "3600");
	}*/
	
	@PostMapping("/create-hr")
	public HR createHr(@RequestBody HR hr) {
		return service.createHR(hr);
	}
	

	/*@RequestMapping("/send-mail")
	public String send(@RequestBody HR hr) 
	{
		System.out.println("controller called");
		//user.setEmailAddress(hr.getUseremail());  //Receiver's email address
		try {
			notificationService.sendEmail(hr);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Mail has been send to the given mail id to reset password.";
	}*/
	
	
	/*@RequestMapping("/send-mail-user")
	public String sendToUser(@RequestBody User user)
	{
		try {
			notificationService.sendEmailTo(user.getEmailAddress());
		}catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}*/
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	HR verifyUser(@RequestBody HR hr ) {
		System.out.println("entered controller");
			return service.verifyUser(hr.getUserEmail(),hr.getUserPassword());
	}
	
	@GetMapping(path="/hrDetails/all")
	public @ResponseBody Iterable<HR> getAllHR() {
		System.out.println("url hit for all");
		return service.getAllHR();
	}
	
		
	@RequestMapping(method = RequestMethod.PATCH, value = "/updateHR")
	void updateHR(@RequestBody HR hr) 
	{
		System.out.println(hr);
		 
		service.updateHR(hr);
	}



	 @RequestMapping(value = "/HR/{id}", method = RequestMethod.GET)
		public HR getToDoById(@PathVariable("id") int id){
	    	//HR hr = service.getHRById(id);
	    	return service.getHRById(id);
	 }
}

