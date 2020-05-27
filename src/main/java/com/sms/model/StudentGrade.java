package com.sms.model;

public class StudentGrade {
	
	private Student student;
	
	private String grade;

	
	public StudentGrade(Student student, String grade) {
		super();
		this.student = student;
		this.grade = grade;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
	

}
