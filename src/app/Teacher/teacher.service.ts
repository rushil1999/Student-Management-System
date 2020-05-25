import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Course } from '../Models/course';
import { StudentGrade } from '../Models/studentGrade';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  constructor( private http: HttpClient ) { }

  url_addCourse = "http://localhost:8080/addCourse";
  url_courseList = "http://localhost:8080/getCoursesTeacher";

  url_studentList = "http://localhost:8080/getStudentsForCourse";

  url_saveGrade = "http://localhost:8080/saveStudentGrades";

  addCourse( course: Course ):  Observable<any>{
    
    // let headers = {

    //   headers: new HttpHeaders({
    //     "teacher_id": localStorage.getItem("teacher_id")
    //   })
    // };

    return this.http.post(this.url_addCourse, course);


  }

  getCourseList(): Observable<any>{

    let parameters = {
      params: {
        "teacher_id": localStorage.getItem("teacher_id") 
      }
    }

    return this.http.get<Array<Course>>(this.url_courseList, parameters);
    //asynchronous
  }


  getStudentListForCourse( course_name: string): Observable<any>{
    
    let parameters = {
      params: {
        "course_name": course_name
      }
    };

    return this.http.get<Array<StudentGrade>>(this.url_studentList, parameters);
  }

  saveStudentsGrades(list: Array<StudentGrade>, course_name: string): Observable<any>{

    let parameters = {
      headers : new HttpHeaders({
        "course_name": course_name
      })
    }

    return this.http.put(this.url_saveGrade, list, parameters);

  }

}
