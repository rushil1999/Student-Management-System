package com.sms.teacher;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer>{
	
	
	@Query(nativeQuery = true, value = "select * from teacher where username = ?1")
	ArrayList<Teacher> getTeacherIdByUsername(@Param("teacher_username") String teacher_username);

}
