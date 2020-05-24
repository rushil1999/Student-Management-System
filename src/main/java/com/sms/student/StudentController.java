package com.sms.student;

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
import com.sms.course.Packet;
import com.sms.studies.StudentCourseService;

@RestController
@CrossOrigin("*")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private StudentCourseService studentCourseService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addStudent")
	public ResponseEntity<Boolean> addStudent(@RequestBody Student student) {
		
		boolean val = studentService.addStudent(student);
		
		return new ResponseEntity<Boolean>(val, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getCourseList")
	public ResponseEntity<ArrayList<Packet>> getCourseList(@RequestParam("student_id") int student_id){
		
		ArrayList<Packet> list = courseService.getCourseListForStudent(student_id);
		return new ResponseEntity<ArrayList<Packet>>(list, HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getOptedCourseList")
	public ResponseEntity<ArrayList<Packet>> getOptedCourseList(@RequestParam("student_id") int student_id){
		
		ArrayList<Packet> list = courseService.getOptedCourseListForStudent(student_id);
		return new ResponseEntity<ArrayList<Packet>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/saveCourses")
	public ResponseEntity<String> saveStudentCourses(@RequestBody ArrayList<Packet> list, @RequestHeader("student_id") int student_id) throws JsonProcessingException{
		
		String str = studentCourseService.saveStudentCourses(list, student_id);
		
		ObjectMapper map = new ObjectMapper();
		
		str = map.writeValueAsString(str);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
		
	}
	
	
	

}
