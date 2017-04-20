package com.briup.apps.sms.bean;

public class StudentSCourse {
	//一个学生选课关系对应一个学生
	private Student student;
	//一个学生选课关系对应一个课程
	private Course course;
	private Long id;
	private Integer grade;
	
	public StudentSCourse() {
		// TODO Auto-generated constructor stub
	}
	

	public StudentSCourse(Student student, Course course, Long id, Integer grade) {
		super();
		this.student = student;
		this.course = course;
		this.id = id;
		this.grade = grade;
	}


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
}
