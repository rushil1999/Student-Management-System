package com.sms.teaching;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.course.Course;
import com.sms.course.CourseService;

@Service
public class TeacherCourseService {
	
	@Autowired
	private TeacherCourseRepository tcRepo;
	
	@Autowired 
	private CourseService courseService;
	
	
	
	public ArrayList<TeacherCourse> getList(){
		
		ArrayList<TeacherCourse> list = new ArrayList<TeacherCourse>();
		
		Iterator<TeacherCourse> it = tcRepo.findAll().iterator();
		
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
		
	}
	
	public boolean addCourse(Course course, int teacher_id) {
		
		tcRepo.save(new TeacherCourse(teacher_id, course.getId()));
		return true;
		
	}
	
	public ArrayList<Course> getCourseListForTeacher(int teacher_id) {
		
		ArrayList<TeacherCourse> list1 = this.getList();
		
		ArrayList<Course> list2 = new ArrayList<Course>();
		
		int i;
		
		for(i = 0;i<list1.size();i++) {
			if(teacher_id == list1.get(i).getTeacher_id()) {
				list2.add(courseService.getCourseById(list1.get(i).getCourse_id()));
			}
		}
		return list2;
	}

}
