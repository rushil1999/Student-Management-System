package com.sms.course;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.handler.CustomException;
import com.sms.student.StudentService;
import com.sms.studies.StudentCourseService;
import com.sms.teacher.Teacher;
import com.sms.teacher.TeacherService;



@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired 
	private TeacherService teacherService;
	
	@Autowired
	private StudentCourseService studentCourseService;
	
	@Autowired 
	private StudentService studentService;

	
	public int  temp = 5;
	
	public ArrayList<Course> getCourseList(){
		Iterator<Course> it = courseRepo.findAll().iterator();
		
		ArrayList<Course> list = new ArrayList<Course>();
		
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public String addCourse(Course course) throws CustomException {
		
		course.setId(this.getLatestId());
		//course.printDetails();
		
		if(this.validateCourse(course) && this.checkIfCourseExists(course.getName())) {
			courseRepo.save(course);
			return "Course Added!";
		}
		else {
			return "Course already Exists";
		}
		
	}
	
	
	
	public boolean checkIfCourseExists(String course_name) {
		ArrayList<Course> list = this.getCourseList();
		int i; 
		for(i=0;i<list.size();i++) {
			if(course_name.equals(list.get(i).getName())) {
				return false;
			}
		}
		return true;
	}
	
	public int getLatestId() {
		ArrayList<Course> list = this.getCourseList();
		int max;
		if(list.size()>0) {
			//System.out.println("Course list Length "+ list.size());
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
			//System.out.println("Else Course list Length "+ list.size());
			max = 0;
			
		}
		return max+1;
		
	}
	
	
	public Course getCourseById(int id) {
		return courseRepo.findById(id).get();
	}
	
	
	public Course getCourseByName(String name) {
		Course course = null;
		course = courseRepo.findCourseByName(name).get(0);
		return course;
	}
	
	
	public ArrayList<Course> getCourseListForTeacher(String teacher_username) throws CustomException{
		
		int teacher_id = teacherService.getTeacherIdByUsername(teacher_username);
		
		ArrayList<Course> list = courseRepo.findCoursesByTeacher_id(teacher_id);
		return list;
	}
	
	
	public ArrayList<Packet> getCourseListForStudent(String student_username) throws CustomException{
		
		int student_id = studentService.getStudentIdByUsername(student_username);
		
		ArrayList<Packet> list = new ArrayList<Packet>();
		ArrayList<Course> tempList1, tempList2 = null;
		
		tempList1 = this.getCourseList();
		tempList2 = studentCourseService.getCourseListForStudent(student_id);
		
		tempList1.removeAll(tempList2);
		int i;
		Packet packet = null;
		Teacher teacher = null;
		for(i=0;i<tempList1.size();i++) {
			teacher = teacherService.getTeacherById(tempList1.get(i).getTeacher_id());
			packet = new Packet(tempList1.get(i), teacher, null);
			list.add(packet);
		}
		
		
		return list;
	}
	
	public ArrayList<Packet> getOptedCourseListForStudent(String student_username) throws CustomException{
		
		int student_id = studentService.getStudentIdByUsername(student_username);
		
		ArrayList<Packet> list = new ArrayList<Packet>();
		ArrayList<Course> tempList = studentCourseService.getCourseListForStudent(student_id);
		int i;
		Packet packet = null;
		Teacher teacher = null;
		String grade = null;
		for(i=0;i<tempList.size();i++) {
			
			grade = studentCourseService.getStudentGrade(tempList.get(i).getId(), student_id);
			teacher = teacherService.getTeacherById(tempList.get(i).getTeacher_id());
			packet = new Packet(tempList.get(i), teacher, grade);
			list.add(packet);
		}
		return list;
	}
	
	
	public boolean validateCourse(Course course) throws CustomException {
		if(course.getName() == null || course.getOutline() == null || course.getCapacity() <=0 || course.getTeacher_id() <=0) {
			
			throw new CustomException("Null Entity");
		}
		else if(course.getCredits() < 1 || course.getCredits() > 5) {
			throw new CustomException("Invalid Credits");
		}
		else {
			return true;
		}
	}
}
