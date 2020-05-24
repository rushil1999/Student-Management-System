package com.sms.course;

import com.sms.teacher.Teacher;

public class Packet {
	
	private Course course;
	
	private Teacher teacher;
	
	private String grade;

	
	public Packet(Course course, Teacher teacher, String grade) {
		super();
		this.course = course;
		this.teacher = teacher;
		this.grade = grade;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
	
	
	

}
