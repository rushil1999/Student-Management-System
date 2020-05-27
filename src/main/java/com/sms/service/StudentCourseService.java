package com.sms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.handler.CustomException;
import com.sms.model.Course;
import com.sms.model.Packet;
import com.sms.model.Student;
import com.sms.model.StudentCourse;
import com.sms.model.StudentGrade;
import com.sms.repository.StudentCourseRepository;

@Service
public class StudentCourseService {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private StudentCourseRepository studentCourseRepo;
	
	@Autowired
	private StudentService studentService;
	
	public ArrayList<StudentGrade> getStudentListForCourse(String name){
		
		//System.out.println(courseService.temp);
		
		Course course = courseService.getCourseByName(name);
		
		ArrayList<StudentGrade> list = new ArrayList<StudentGrade>();
		
		ArrayList<StudentCourse> tempList = null;
		tempList = studentCourseRepo.getListByCourse(course.getId());
		
		int i;
		StudentGrade studentGrade = null;
		Student student = null;
		
		for(i=0;i<tempList.size();i++) {
			
			student = studentService.getStudentById(tempList.get(i).getStudent_id());
			
			studentGrade = new StudentGrade(student, tempList.get(i).getGrade());
			list.add(studentGrade);
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
	
	
	
	
	public String saveStudentCourses(ArrayList<Packet> list, String student_username) throws CustomException {
		 
		int i,j, student_id;
		StudentCourse studentCourse = null;

		studentService.checkIfUsernameExists(student_username);
		student_id = studentService.getStudentIdByUsername(student_username);
	

		
		ArrayList<StudentCourse> origList = studentCourseRepo.getCourseListForStudent(student_id);
		
		ArrayList<StudentCourse> updatedList = new ArrayList<StudentCourse>();
		
		Course course = null;
		for(i=0;i<list.size();i++) {
			course = list.get(i).getCourse();
			studentCourse = new StudentCourse(course.getId(), student_id, list.get(i).getGrade());
			updatedList.add(studentCourse);
			//studentCourseRepo.save(studentCourse);
		}
		
		//Deletes elements from the table that are not present in the new list
		if(origList.size() > updatedList.size()) {
			
//			System.out.println("New List!!!!");
//			for(i=0;i<updatedList.size();i++) {
//				System.out.println(updatedList.get(i).getCourse_id() + " " + updatedList.get(i).getStudent_id()+ " " + updatedList.get(i).getGrade());
//			}
//			System.out.println("Old List!!!!");
//			for(i=0;i<origList.size();i++) {
//				System.out.println(origList.get(i).getCourse_id() + " " + origList.get(i).getStudent_id()+ " " + origList.get(i).getGrade());
//			}

			
			for(i=0;i<origList.size();i++) {
				for(j=0;j<updatedList.size();j++) {
					if(origList.get(i).getCourse_id() == updatedList.get(j).getCourse_id() &&
							origList.get(i).getStudent_id() == updatedList.get(j).getStudent_id()) {
						origList.remove(i);
					}
				}
			}
			
			
			
			
			
			
			
//			System.out.println(origList.removeAll(updatedList));
//			System.out.println("After removal!!!!");
//			for(i=0;i<origList.size();i++) {
//				System.out.println(origList.get(i).getCourse_id() + " " + origList.get(i).getStudent_id()+ " " + origList.get(i).getGrade());
//			}
//			
			
			for(i=0;i<origList.size();i++) {
				studentCourseRepo.delete(origList.get(i));
			}
		}
		//Add element in the table that are present in the new list
		//Updates all the elements
		else {
			for(i=0;i<updatedList.size();i++) {
				studentCourseRepo.save(updatedList.get(i));
			}
		}
		
		return "Courses Saved";
	}
	
	public String getStudentGrade(int course_id, int student_id) {
		StudentCourse studentCourse = studentCourseRepo.getStudentGrade(course_id, student_id).get(0);
		return studentCourse.getGrade();
	}
	
	public String saveStudentsGrades(ArrayList<StudentGrade> list, String course_name) {
		
		StudentCourse studentCourse = null;
		
		
		
		int i, course_id = courseService.getCourseByName(course_name).getId();
		int student_id;
		for(i=0;i<list.size();i++) {
			
			student_id = list.get(i).getStudent().getId();
			studentCourse = new StudentCourse(course_id, student_id, list.get(i).getGrade());
			studentCourseRepo.save(studentCourse);
		}
		if(list.size()>0) {
			return "Changes Made Successfully";
		}
		else {
			return "No Changes Made";
		}
	}
	

}
