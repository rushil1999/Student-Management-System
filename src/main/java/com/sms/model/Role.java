package com.sms.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class Role {
	
	@Id
	private int id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String fname;
	
	@NotNull
	private String lname;
	
	@NotNull
	private String emailaddr;
	
	@NotNull
	private String password;
	
	@NotNull
	private boolean accept;

	
	public Role(int id, String fname, String lname, String emailaddr, String password, String username, boolean accept) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.emailaddr = emailaddr;
		this.password = password;
		this.username = username;
		this.accept = accept;
	}
	
	public Role() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getEmailaddr() {
		return emailaddr;
	}


	public void setEmailaddr(String emailaddr) {
		this.emailaddr = emailaddr;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isAccept() {
		return accept;
	}


	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
	
	

}
