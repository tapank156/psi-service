package com.scholastic.scent.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="error")
public class ErrorVO {
	private String sessionId;
	private String className;
	private String details;
	public ErrorVO(String sessionId, String className, String details) {
		super();
		this.sessionId = sessionId;
		this.className = className;
		this.details = details;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
}
