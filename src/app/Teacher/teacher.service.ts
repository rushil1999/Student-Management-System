import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Course } from '../course';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  constructor( private http: HttpClient ) { }

  url_addCourse = "http://localhost:8080/addCourse";
  url_courseList = "http://localhost:8080/getCoursesTeacher";

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

}
