package com.briup.apps.sms.bean;

import java.io.Serializable;

public class Teacher implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String password;
	private String gender;
	
	public Teacher(){
		
	}
	
	public Teacher(Long id, String name, String password,String gender) {
		super();
		
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
