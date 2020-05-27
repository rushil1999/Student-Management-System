package com.sms.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sms.Role;

@Entity
@Table(name = "student")
public class Student extends Role{
	
	@Column(nullable = false)
	private String program;
	
	@Column(nullable = false)
	private int semester;

	
	public Student(int id, String username, String fname, String lname, String emailaddr, String password, 
			boolean accept, String program, int semester  ) {
		super(id, fname, lname, emailaddr, password, username, accept);
		this.program = program;
		this.semester = semester;
		
	}
	
	public Student() {
		super();
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	public void printDetails() {
		System.out.println("Id: " + this.getId());
		System.out.println("Username " + this.getUsername());
		System.out.println("First Name: " + this.getFname());
		System.out.println("Last Name: " + this.getLname());
		System.out.println("Email Address: " + this.getEmailaddr());
		System.out.println("Program: " + this.getProgram());
		System.out.println("Semester: " + this.getSemester());
		System.out.println("Password: " + this.getPassword());
		System.out.println("Accept: " + this.isAccept());
		
	}
	
	
	

}
