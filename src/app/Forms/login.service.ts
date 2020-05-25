import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url_login = "http://localhost:8080/login";

  constructor( private http: HttpClient ) { }

  loginUser(id: number, category: string, password: string): Observable<any>{

    let value: HttpParams = new HttpParams();
    value = value.set("id", String(id));
    value = value.set("category", category);
    value = value.set("password", password);

    let parameters = {
      params : value
    };


    return this.http.get<string>(this.url_login, parameters);

  }


}
