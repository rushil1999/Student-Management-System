package com.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.handler.CustomException;
import com.sms.model.Student;
import com.sms.model.Teacher;
import com.sms.model.TeacherRepository;
import com.sms.repository.StudentRepository;

@Service
public class LoginService {
	
	
	@Autowired 
	private StudentRepository studentRepository;
	
	@Autowired 
	private TeacherRepository teacherRepository;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private StudentService studentService;
	
	public String logIn(String username, String type, String password) throws CustomException {
		
		//System.out.println("Login Service");
		
		Teacher teacher = null;
		Student student = null;
		
		int id;
		
		if(type.equals("Teacher")){
			
			id = teacherService.getTeacherIdByUsername(username);
			if(teacherRepository.existsById(id)) {
				teacher = teacherRepository.findById(id).get();
				if(teacher.getPassword().equals(password)) {
					return Integer.toString(teacher.getId());
				}
				else {
					return "Wrong Password";
				}
			}
			else {
				return "Invalid Username";
			}
		}
		else if(type.equals("Student")) {
			
			id = studentService.getStudentIdByUsername(username);
			//System.out.println("Student Id " + id);
			if(studentRepository.existsById(id)) {
				
				//System.out.println("Here1");
				student = studentRepository.findById(id).get();
				//System.out.println("Here2");
				if(student.getPassword().equals(password)) {
					return Integer.toString(student.getId());
				}
				else {
					return "Wrong Password";
				}
			}
			else {
				return "Invalid Username";
			}
			
		}
		else {
			return null;
		}
		
	}

}
