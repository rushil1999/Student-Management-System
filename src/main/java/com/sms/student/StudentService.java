package com.sms.student;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.sms.course.Packet;

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
	
	public boolean addStudent(Student student) {
		
		student.setId(this.getLatestId());
		
		studentRepo.save(student);
		
		return true;
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
	
	
	
	
	
}
