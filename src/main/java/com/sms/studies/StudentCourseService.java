package com.sms.studies;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.course.Course;
import com.sms.course.CourseService;
import com.sms.course.Packet;
import com.sms.student.Student;
import com.sms.student.StudentService;

@Service
public class StudentCourseService {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private StudentCourseRepository studentCourseRepo;
	
	@Autowired
	private StudentService studentService;
	
	public ArrayList<Student> getStudentListForCourse(String name){
		
		System.out.println(courseService.temp);
		
		Course course = courseService.getCourseByName(name);
		
		ArrayList<Student> list = new ArrayList<Student>();
		
		ArrayList<StudentCourse> tempList = null;
		tempList = studentCourseRepo.getListByCourse(course.getId());
		
		int i;
		
		for(i=0;i<tempList.size();i++) {
			list.add(studentService.getStudentById(tempList.get(i).getStudent_id()));
		}
		
		return list;
	}
	
	
	public ArrayList<Course> getCourseListForStudent(int student_id){
		
		ArrayList<StudentCourse> tempList = studentCourseRepo.getCourseListForStudent(student_id);
		ArrayList<Course> list = new ArrayList<Course>();
		
		Course course = null;
		
		int i;
		for(i=0;i<tempList.size();i++) {
			course = courseService.getCourseById(tempList.get(i).getCourse_id());
			list.add(course);
		}
		return list;
		
	}
	
	
	public String saveStudentCourses(ArrayList<Packet> list, int student_id) {
		 
		int i;
		StudentCourse studentCourse = null;
		Course course = null;
		for(i=0;i<list.size();i++) {
			course = list.get(i).getCourse();
			studentCourse = new StudentCourse(course.getId(), student_id, null);
			studentCourseRepo.save(studentCourse);
		}
		return "Courses Saved";
	}
	
	public String getStudentGrade(int course_id, int student_id) {
		StudentCourse studentCourse = studentCourseRepo.getStudentGrade(course_id, student_id).get(0);
		return studentCourse.getGrade();
	}
	

}
