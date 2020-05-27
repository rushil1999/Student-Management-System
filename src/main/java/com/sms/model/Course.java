package com.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String outline;
	
	@Column(nullable = false)
	private int capacity;
	
	@Column(nullable = false)
	private int credits;

	@Column(nullable = false)
	private int teacher_id;
	
	private boolean accept;

	
	public Course(int id, String name, String outline, int capacity, int credits, int teacher_id, boolean accept) {
		super();
		this.id = id;
		this.name = name;
		this.outline = outline;
		this.capacity = capacity;
		this.credits = credits;
		this.accept = accept;
		this.teacher_id = teacher_id;
	}
	
	public Course() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	
	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	public void printDetails() {
		System.out.println("Course Id " + this.getId());
		System.out.println("Course Name " + this.getName());
		System.out.println("Course Outline " + this.getOutline());
		System.out.println("Course Capacity " + this.getCapacity());
		System.out.println("Course Credits " +  this.getCredits());
		System.out.println("Course Teacher Id" + this.getTeacher_id());
		System.out.println("Course Status " +  this.isAccept());
	}
	
	
	

}
