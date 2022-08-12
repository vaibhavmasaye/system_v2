package com.email.emailapi.model;

import java.util.Arrays;

import javax.persistence.Lob;

public class EmailRequest {
	private String to;
	private String subject;
	private String message;
	private String from;
	private String password;
	private String attachment;
	
	public EmailRequest(String to, String subject, String message, String from, String password, String attachment) {
		super();
		this.to = to;
		this.subject = subject;
		this.message = message;
		this.from = from;
		this.password = password;
		this.attachment = attachment;
	}

	public EmailRequest() {
		super();
	}

	@Override
	public String toString() {
		return "EmailRequest [to=" + to + ", subject=" + subject + ", message=" + message + ", from=" + from
				+ ", password=" + password + ", attachment=" + attachment + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
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

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
