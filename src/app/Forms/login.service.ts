import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Teacher } from '../Models/teacher';
import { Student } from '../Models/student';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url_login = "http://localhost:8080/login";

  url_addTeacher = "http://localhost:8080/addTeacher";

  url_addStudent = "http://localhost:8080/addStudent";

  constructor( private http: HttpClient ) { }

  loginUser(username: string, category: string, password: string): Observable<any>{

    let value: HttpParams = new HttpParams();
    value = value.set("username", username);
    value = value.set("category", category);
    value = value.set("password", password);

    let parameters = {
      params : value
    };


    return this.http.get<string>(this.url_login, parameters);

  }


  addTeacher(teacher: Teacher): Observable<any>{
    return this.http.post(this.url_addTeacher, teacher);
  }


  addStudent(student: Student): Observable<any>{
    return this.http.post(this.url_addStudent, student);
  }


}
