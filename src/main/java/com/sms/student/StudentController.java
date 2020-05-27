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
import com.sms.course.CourseService;
import com.sms.course.Packet;
import com.sms.handler.CustomException;
import com.sms.studies.StudentCourseService;

@RestController
@CrossOrigin("http://localhost:4200")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private StudentCourseService studentCourseService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addStudent")
	public ResponseEntity<String> addStudent(@RequestBody Student student) throws JsonProcessingException, CustomException {
		
		String str = studentService.addStudent(student);
		
		ObjectMapper map = new ObjectMapper();
		str = map.writeValueAsString(str);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getCourseList")
	public ResponseEntity<ArrayList<Packet>> getCourseList(@RequestParam("student_username") String student_username) throws CustomException{
		//System.out.println("WHY here???? " + student_id);
		
		ArrayList<Packet> list = courseService.getCourseListForStudent(student_username);
		return new ResponseEntity<ArrayList<Packet>>(list, HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getOptedCourseList")
	public ResponseEntity<ArrayList<Packet>> getOptedCourseList(@RequestParam("student_username") String student_username) throws CustomException{
		
		ArrayList<Packet> list = courseService.getOptedCourseListForStudent(student_username);
		return new ResponseEntity<ArrayList<Packet>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/saveCourses")
	public ResponseEntity<String> saveStudentCourses(@RequestBody ArrayList<Packet> list, @RequestHeader("student_username") String student_username) throws JsonProcessingException, CustomException{
		
		String str = studentCourseService.saveStudentCourses(list, student_username);
		
		ObjectMapper map = new ObjectMapper();
		
		str = map.writeValueAsString(str);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
		
	}
	
	
	
	

}
