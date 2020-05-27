package com.sms.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.handler.CustomException;
import com.sms.model.Course;
import com.sms.model.StudentGrade;
import com.sms.model.Teacher;
import com.sms.service.CourseService;
import com.sms.service.StudentCourseService;
import com.sms.service.TeacherService;

@RestController
@CrossOrigin("*")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private StudentCourseService studentCourseService;
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/addTeacher")
	public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher) throws JsonProcessingException {
		
		//System.out.println("Controller");
		//teacher.printDetails();
		
		String str = teacherService.addTeacher(teacher);
		
		ObjectMapper map = new ObjectMapper();
		str = map.writeValueAsString(str);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addCourse")
	public ResponseEntity<String> addCourse(@RequestBody Course course) throws JsonProcessingException, CustomException{
		
		ObjectMapper map = new ObjectMapper();
		
		String str = courseService.addCourse(course);
		
		str = map.writeValueAsString(str);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getCoursesTeacher")
	public ResponseEntity<ArrayList<Course>> getCourseListForTeacher(@RequestParam(name = "teacher_username") String teacher_username ) throws CustomException{
		
		//System.out.println("Teacher Why Here");
		ArrayList<Course> list = courseService.getCourseListForTeacher(teacher_username);
		
		return new ResponseEntity<ArrayList<Course>>(list, HttpStatus.OK);		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getStudentsForCourse")
	public ResponseEntity<ArrayList<StudentGrade>> getStudentGradeForCourse(@RequestParam(name = "course_name") String course_name){
		
		ArrayList<StudentGrade> list = studentCourseService.getStudentListForCourse(course_name);
		return new ResponseEntity<ArrayList<StudentGrade>>(list, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/saveStudentGrades" )
	public ResponseEntity<String> updateStudentsGrades(@RequestBody ArrayList<StudentGrade> list, @RequestHeader(name = "course_name") String course_name) throws JsonProcessingException{
		
		String str = studentCourseService.saveStudentsGrades(list, course_name);
		
		ObjectMapper map = new ObjectMapper();
		str = map.writeValueAsString(str);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	

}
