package com.sms.studies;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository  extends CrudRepository<StudentCourse, StudentCourseId>{

	@Query(nativeQuery = true, value = "select * from student_course where course_id = ?1")
	public ArrayList<StudentCourse> getListByCourse(@Param("course_id") int course_id);
	
	@Query(nativeQuery = true, value = "select * from student_course where student_id = ?1")
	public ArrayList<StudentCourse> getCourseListForStudent(@Param("student_id") int student_id);
	
	@Query(nativeQuery = true, value = "select * from student_course where course_id = ?1 and student_id = ?2")
	public ArrayList<StudentCourse> getStudentGrade(@Param("course_id") int course_id, @Param("student_id") int student_id);
}
