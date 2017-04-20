package com.briup.apps.sms.bean;

import java.io.Serializable;

public class Student implements Serializable{//实现序列化接口
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//一个学生对应多个选课关系 
	//private Set<StudentSCourse> scs;  //不需要在一得一方维护多的一方
	private Long id;
	private String name;
	private String password;
	private Integer age;
	private String gender;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	

	public Student(Long id, String name, String password, Integer age, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
