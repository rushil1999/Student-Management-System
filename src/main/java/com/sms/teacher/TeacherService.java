package com.sms.teacher;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.handler.CustomException;
import com.sms.studies.StudentCourseService;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepo;
	
	@Autowired
	private StudentCourseService studentCourseService;
	
	public ArrayList<Teacher> getTeachersList(){
		
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		
		Iterator<Teacher> it = teacherRepo.findAll().iterator();
		
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	
	public String addTeacher(Teacher teacher) {
		
		if(!this.checkIfUsernameExists(teacher.getUsername())){
			int val =  this.latestId();
			teacher.setId(val);
			//teacher.printDetails();
			
			
			teacherRepo.save(teacher);
			return "Added Successfully";
		}
		else {
			return "User Name Exists";
		}
		
		
	}
	
	
	public int latestId() {
		
		
		ArrayList<Teacher> list = this.getTeachersList();
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
	
	
	public Teacher getTeacherById(int teacher_id) {
		
		return teacherRepo.findById(teacher_id).get();
	}
	
	
	public ArrayList<StudentGrade> getStudentListForCourse(String name){
		
		ArrayList<StudentGrade> list = studentCourseService.getStudentListForCourse(name);
		return list;
	}
	
	public int getTeacherIdByUsername(String teacher_username) throws CustomException {
		
		if(this.checkIfUsernameExists(teacher_username)) {
			Teacher teacher = teacherRepo.getTeacherIdByUsername(teacher_username).get(0);
			return teacher.getId();
		}
		else {
			throw new CustomException("Teacher Does Not exist");
		}
		
		
		
	}
	
	
	public boolean checkIfUsernameExists(String teacher_username) {
		ArrayList<Teacher> list = this.getTeachersList();
		int i, temp = 0;
		for(i=0;i<list.size();i++) {
			//System.out.println(list.get(i).getUsername() + " " + teacher_username);
			if(list.get(i).getUsername().equals(teacher_username)){
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
	
	public boolean validateTeacher(Teacher teacher) throws CustomException {
			
		if(teacher.getUsername() == null || teacher.getFname() == null || teacher.getLname() == null || 
				teacher.getEmailaddr() == null || teacher.getQualifications() == null || teacher.getPassword() == null) {
			throw new CustomException("Null Entity");
		}
		else {
			return true;
		}
		
	}
}
