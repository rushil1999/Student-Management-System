package com.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "student_course")
@IdClass(StudentCourseId.class)
public class StudentCourse {
	
	@Id
	private int course_id;
	
	@Id
	private int student_id;
	
	@Column(nullable = true)
	private String grade;
	
	public StudentCourse(int course_id, int student_id, String grade) {
		super();
		this.course_id = course_id;
		this.student_id = student_id;
		this.grade = grade;
	}
	
	public StudentCourse() {
		
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
	
	
	

}
