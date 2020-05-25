package com.sms.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.student.Student;
import com.sms.student.StudentRepository;
import com.sms.teacher.Teacher;
import com.sms.teacher.TeacherRepository;

@Service
public class LoginService {
	
	
	@Autowired 
	private StudentRepository studentRepository;
	
	@Autowired 
	private TeacherRepository teacherRepository;
	
	public String logIn(int id, String type, String password) {
		
		
		Teacher teacher = null;
		Student student = null;
		
		if(type.equals("Teacher")){
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
				return "Invalide Id";
			}
		}
		else if(type.equals("Student")) {
			if(studentRepository.existsById(id)) {
				student = studentRepository.findById(id).get();
				if(student.getPassword().equals(password)) {
					return "OK";
				}
				else {
					return "Wrong Password";
				}
			}
			else {
				return "Invalid Id";
			}
			
		}
		else {
			return null;
		}
		
	}

}
