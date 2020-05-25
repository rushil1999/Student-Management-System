import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { formValidatorIsNumeric } from '../form-validators';
import { LoginService } from '../login.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  categories: string[] = ["Teacher", "Student", "Admin"];
  logInForm: FormGroup;
  message: string;
  constructor( private loginService: LoginService,
    private router: Router ) { }

  ngOnInit(): void {
    localStorage.clear();
    this.buildLoginInForm();
  }

  buildLoginInForm(): void{
    this.logInForm = new FormGroup({
      id: new FormControl('', [Validators.required, formValidatorIsNumeric ]),
      category: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])      

    });
  }

  loginUser(): void{

    let id: number = this.logInForm.get('id').value;
    let category: string = this.logInForm.get('category').value;
    let password: string = this.logInForm.get('password').value;


    this.loginService.loginUser(id, category, password).subscribe(
      data => {
        this.setMessageAndLocalStorage(data, id, category);
      }
    )
  }

  setMessageAndLocalStorage(data: any, id: number, category: string): void{
    if(data == "OK"){
      if(category == "Teacher"){
        localStorage.clear();
        localStorage.setItem("teacher_id", String(id));
        this.router.navigate(["/teacher"]);
      }
      else if(category == "Student"){
        localStorage.clear();
        localStorage.setItem("student_id", String(id));
        this.router.navigate(["/student"]);
      }
      else{

      }

    }
    else{
      this.message = data;
    }
  }

}
