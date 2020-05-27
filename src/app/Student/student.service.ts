import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Packet } from '../Models/packet';


@Injectable({
  providedIn: 'root'
})
export class StudentService {

  url_getCourses = "http://localhost:8080/getCourseList";

  url_getOptedCourses = "http://localhost:8080/getOptedCourseList";

  url_saveCourses = "http://localhost:8080/saveCourses";

  constructor( private http: HttpClient ) { }

  getCourseList(temp:boolean): Observable<any>{
    //console.log("Student Service called");
    let url: string;
    
    if(temp == true){
      url = this.url_getCourses;
    }
    else{
      url = this.url_getOptedCourses;
    }

    let val: any = localStorage.getItem("student_username");

    let parameters = {
      params: {
        "student_username": val
      } 
    };
    return this.http.get<Array<Packet>>(url, parameters);

  }



  saveStudentCourses(list: Array<Packet>): Observable<any>{

    let parameters = {

      headers: new HttpHeaders({
        "student_username": localStorage.getItem("student_username")
      })
    };

    return this.http.post(this.url_saveCourses, list, parameters);

  }

  


}
