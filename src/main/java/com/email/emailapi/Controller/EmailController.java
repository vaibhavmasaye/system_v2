package com.email.emailapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.email.emailapi.Service.EmailService;
import com.email.emailapi.model.EmailRequest;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/welcome")
	public String welcome () {
		return "hello this is my email api";
	}
	 
	@RequestMapping(value="/sendemail", method= RequestMethod.POST)
   public ResponseEntity<?>sendEmail(@RequestBody EmailRequest request){
	   System.out.println(request);
	   boolean result =this.emailService.sendEmail(request.getSubject(),request.getMessage(),request.getTo(),request.getFrom(),request.getPassword());
		if(result)
		{
			return ResponseEntity.ok("Email is sent successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent");
		}
	   
   }


	
}
