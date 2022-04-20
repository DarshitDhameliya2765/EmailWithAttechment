package com.emailapi.model;


public class EmailRequest 

{
	private String to;
    private String cc;
    private String subject;
    private String message;
    
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public EmailRequest(String to, String cc, String subject, String message) {
		super();
		this.to = to;
		this.cc = cc;
		this.subject = subject;
		this.message = message;
	}
	public EmailRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
 
}
