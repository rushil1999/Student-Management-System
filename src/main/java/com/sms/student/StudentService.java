package com.sms.student;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.handler.CustomException;

import java.util.Iterator;

@Service
public class StudentService {
	
	
	@Autowired
	private StudentRepository studentRepo;
	
	public ArrayList<Student> getStudentList(){
		
		ArrayList<Student> list = new ArrayList<Student>();
		
		Iterator<Student> it = studentRepo.findAll().iterator();
		
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public String addStudent(Student student) throws CustomException  {
		
		
		
		if(this.validateStudent(student) && !this.checkIfUsernameExists(student.getUsername())) {
			int value = this.getLatestId();
			student.setId(value);
			
			studentRepo.save(student);
			
			return "Added Successfully";
		}
		else {
			return "User Name Already Exists";
		}
		
		
	}
	
	public int getLatestId() {
		
		ArrayList<Student> list = this.getStudentList();
		int max;
		if(list.size()>0) {
		
			int i, value;
			max = list.get(0).getId();
			
			for(i=1;i<list.size();i++) {
				
				value = list.get(i).getId();
				if(max <= value) {
					max = value;
				}
			}
			
		}	
		else {
			max = 0;
		}
		return max+1;
	}
	
	
	public Student getStudentById(int student_id) {
		
		Student student = studentRepo.findById(student_id).get();
		return student;
	}
	
	public int getStudentIdByUsername(String student_username) {
		
		if(this.checkIfUsernameExists(student_username)) {
			Student student = studentRepo.getStudentIdByUsername(student_username).get(0);
			return student.getId();
		}
		else {
			return -1;
		}
		
		
	}
	
	
	
	
	public boolean checkIfUsernameExists(String student_username) {
		ArrayList<Student> list = this.getStudentList();
		int i, temp = 0;
		for(i=0;i<list.size();i++) {
			if(list.get(i).getUsername().equals(student_username)){
				temp = 1;
				break;
			}
		}
		if(temp == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	public boolean validateStudent(Student student) throws CustomException {
		
		int temp = 0;
		if(student.getUsername() == null || student.getFname() == null || student.getLname() == null || 
				student.getEmailaddr() == null || student.getProgram() == null || student.getSemester() == 0 || student.getPassword() == null) {
			temp = 1;
			throw new CustomException("Null Entity");
		}
		else {
			return true;
		}
		
	}
	
	
	
	
	
}
