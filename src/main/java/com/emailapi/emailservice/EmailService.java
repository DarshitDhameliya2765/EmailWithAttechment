package com.emailapi.emailservice;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmailService {
	
	public boolean sendEmail(String to,String cc,String subject,String message, @RequestParam("file") MultipartFile file)
	{
		boolean f=false;
		String from="darshitdhameliya62@gmail.com";
		String host="smtp.gmail.com";
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//Step 1: to get the session object..
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("darshitdhameliya62@gmail.com","iqfaumfaykpnykzt");
			}
			
			
			
		});
		
		session.setDebug(true);
		
		//Step 2 : compose the message [text,multi media]
		//
		MimeMessage m = new MimeMessage(session) ;
		
		try {
		    MimeMessageHelper helper = new MimeMessageHelper(m, true);
		    helper.setFrom(from);
		    helper.setTo(to);
		    helper.setCc(cc);
		    helper.setSubject(subject);
		    helper.setText(message);
		    //FileSystemResource file = new FileSystemResource(filePath);
		    helper.addAttachment(file.getOriginalFilename(), file);
		    Transport.send(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//mailSender.send(mess,age);
		
//		try {
//			//MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(m, true);
//		//from email
//		m.setFrom(from);
//		
//		
//		//adding recipient to message
//		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//		
//		
//		m.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
//		
//		//adding subject to message
//		m.setSubject(subject);
//	
//		
//		//adding text to message
//		m.setText(message);
//        //String path="C:\\Users\\dell i7 4th\\Pictures\\DARSHIT\\bhagavan\\IMG-20180621-WA0061.jpg";
//       
//       MimeMultipart mimeMultipart = new MimeMultipart();
////		//text
////		//file
////		
////		MimeBodyPart textMime = new MimeBodyPart();
////		
////		MimeBodyPart fileMime = new MimeBodyPart();
////		
////		try {
////			
//////			textMime.setText(message);
//////			File file=new File(path);
//////			fileMime.attachFile(file);
////			mimeMultipart.addBodyPart(textMime);
////			mimeMultipart.addBodyPart(fileMime);
////		} catch (Exception e) {
////			
////			e.printStackTrace();
////		}
//		
//		//mimeMultipart.addBodyPart(file.getOriginalFilename(), file);
//
//		
//		m.setContent(mimeMultipart);
//		//Step 3 : send the message using Transport class
//		Transport.send(m);
//				
//		System.out.println("Sent success...................");
//		f=true;
//		
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		return f;
			
	}

	}


















