package com.sms.model;

import java.io.Serializable;

public class StudentCourseId implements Serializable{

	private static final long serialVersionUID = 1L;
	private int course_id;
	private int student_id;
	
	public StudentCourseId(int course_id, int student_id) {
		super();
		this.course_id = course_id;
		this.student_id = student_id;
	}
	
	public StudentCourseId() {
		super();
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
	
	@Override
	public boolean equals(Object o) {
		return true;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	

}
