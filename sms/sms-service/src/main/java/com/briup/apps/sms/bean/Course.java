package com.briup.apps.sms.bean;

import java.io.Serializable;

public class Course implements Serializable{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//一门课程对应多个选课关系
	//private Set<StudentSCourse> scs; //不需要在一得一方维护多的一方
	private Teacher teacher;
	private Long id;
	private String name;
	private Integer credit;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course( Teacher teacher,Long id, String name, Integer credit) {
		super();
		this.teacher=teacher;
		this.id = id;
		this.name = name;
		this.credit = credit;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	
	@Override
	public String toString() {
		return "Course [teacher=" + (teacher!=null?teacher.getName():null)+ ", id=" + id + ", name=" + name + ", credit=" + credit + "]";
	}
}
