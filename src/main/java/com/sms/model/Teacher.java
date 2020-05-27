package com.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher extends Role{

	@Column(name = "qualifications", nullable = false)
	private String qualifications;
	
	public Teacher(int id, String username, String fname, String lname, String emailaddr, String password, 
			boolean accept, String qualifications) {
		super(id, fname, lname, emailaddr, password, username, accept);
		this.qualifications = qualifications;
		
	}
	
	public Teacher() {
		super();
	}
	

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	
	
	public void printDetails() {
		System.out.println("Id: " + this.getId());
		System.out.println("Username " + this.getUsername());
		System.out.println("First Name: " + this.getFname());
		System.out.println("Last Name: " + this.getLname());
		System.out.println("Email Address: " + this.getEmailaddr());
		System.out.println("Qualifications: " + this.getQualifications());
		System.out.println("Password: " + this.getPassword());
		System.out.println("Accept: " + this.isAccept());
		
	}
	
	

}
