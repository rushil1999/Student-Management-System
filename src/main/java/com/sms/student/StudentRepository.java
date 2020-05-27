package com.sms.student;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	@Query(nativeQuery = true, value = "select * from student where username = ?1")
	ArrayList<Student> getStudentIdByUsername(@Param("student_username") String username);
}
