package com.sms.teaching;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherCourseRepository extends CrudRepository<TeacherCourse, Integer>{

}
