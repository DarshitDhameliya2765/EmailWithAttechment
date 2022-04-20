package com.emailapi.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.emailapi.emailservice.EmailService;

@RestController

public class EmailController {
	boolean result=false;
	@Autowired
	private EmailService emailService;
	
	  private static String UPLOADED_FOLDER = "C:\\Users\\dell i7 4th\\Desktop\\New folder";
	
	@PostMapping(value="/sendemail")
	public ResponseEntity<?> sendEmail(@RequestParam("to") String to,@RequestParam("cc") String cc,@RequestParam("subject") String subject,@RequestParam("message") String message,@RequestParam("file") MultipartFile file) throws IOException
	{
		
		byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
        Files.write(path, bytes);
		result=this.emailService.sendEmail(to,cc,subject,message,file);
		if(result==false)
		{
			return ResponseEntity.ok("Email Sent Successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not send");
		}
		
	}
        

}
