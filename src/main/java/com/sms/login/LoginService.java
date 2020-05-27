package com.sms.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.student.Student;
import com.sms.student.StudentRepository;
import com.sms.student.StudentService;
import com.sms.teacher.Teacher;
import com.sms.teacher.TeacherRepository;
import com.sms.teacher.TeacherService;

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
	
	public String logIn(String username, String type, String password) {
		
		//System.out.println("Login Service");
		
		Teacher teacher = null;
		Student student = null;
		
		int id;
		
		if(type.equals("Teacher")){
			
			id = teacherService.getTeacherIdByUsername(username);
			if(teacherRepository.existsById(id)) {
				teacher = teacherRepository.findById(id).get();
				if(teacher.getPassword().equals(password)) {
					return "OK";
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
					return "OK";
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
