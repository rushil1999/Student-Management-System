package com.sms.teacher;

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
import com.sms.course.Course;
import com.sms.course.CourseService;
import com.sms.teaching.TeacherCourseService;

@RestController
@CrossOrigin("*")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/addTeacher")
	public ResponseEntity<Boolean> addTeacher(@RequestBody Teacher teacher) {
		
		System.out.println("Controller");
		//teacher.printDetails();
		
		boolean val = teacherService.addTeacher(teacher);
		return new ResponseEntity<Boolean>(val, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addCourse")
	public ResponseEntity<String> addCourse(@RequestBody Course course) throws JsonProcessingException{
		
		ObjectMapper map = new ObjectMapper();
		
		String str = courseService.addCourse(course);
		
		str = map.writeValueAsString(str);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getCoursesTeacher")
	public ResponseEntity<ArrayList<Course>> getCourseListForTeacher(@RequestParam(name = "teacher_id") int teacher_id ){
		
		ArrayList<Course> list = courseService.getCourseListForTeacher(teacher_id);
		
		return new ResponseEntity<ArrayList<Course>>(list, HttpStatus.OK);		
	}
	

}
