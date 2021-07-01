package com.sbtutorial.componentscandemo;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	private int eid;
	private String ename;
	private String language;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	

}
