package com.sms.teaching;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_course")
public class TeacherCourse {
	
	
	@Column(name = "teacher_id", nullable = false)
	private int teacher_id;
	
	@Id
	@Column(name = "course_id", nullable = false)
	private int course_id;

	
	public TeacherCourse(int teacher_id, int course_id) {
		super();
		this.teacher_id = teacher_id;
		this.course_id = course_id;
	}
	
	public TeacherCourse() {
		
	}


	public int getTeacher_id() {
		return teacher_id;
	}


	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}


	public int getCourse_id() {
		return course_id;
	}


	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
	

	
	
}
