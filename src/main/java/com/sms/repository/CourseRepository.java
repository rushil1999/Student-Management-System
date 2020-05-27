package com.sms.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sms.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

	@Query(nativeQuery = true, value = "select * from course where name = ?1")
	ArrayList<Course> findCourseByName(@Param("name") String name);
	
	@Query(nativeQuery = true, value = "select * from course where teacher_id = ?1")
	ArrayList<Course> findCoursesByTeacher_id(@Param("teacher_id") int teacher_id);
}
