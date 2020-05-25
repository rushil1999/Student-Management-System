package com.sms.teacher;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	public boolean addTeacher(Teacher teacher) {
		
		System.out.println("Service");
		
		teacher.setId(this.latestId());
		//teacher.printDetails();
		
		
		teacherRepo.save(teacher);
		return true;
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
}
