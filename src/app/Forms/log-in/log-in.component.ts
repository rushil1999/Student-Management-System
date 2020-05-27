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
      username: new FormControl('', [Validators.required, Validators.maxLength(10) ]),
      category: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])      

    });
  }

  loginUser(): void{

    let username: string = this.logInForm.get('username').value;
    let category: string = this.logInForm.get('category').value;
    let password: string = this.logInForm.get('password').value;


    this.loginService.loginUser(username, category, password).subscribe(
      data => {
        if(data = "OK"){
          this.setMessageAndLocalStorage(data, username, category);
        }
        else{
          this,this.message = data;
        }
      }
    )
  }

  setMessageAndLocalStorage(data: any, username: string, category: string): void{
    if(data == "OK"){
      if(category == "Teacher"){
        localStorage.clear();
        localStorage.setItem("teacher_username", username);
        this.router.navigate(["/teacher"]);
      }
      else if(category == "Student"){
        localStorage.clear();
        localStorage.setItem("student_username", username);
        this.router.navigate(["/student"]);
      }
      else{

      }

    }
    else{
      this.message = data;
    }
  }


  RegisterAsTeacher(): void{
    this.router.navigate(["/addTeacher"]);
  }

  RegisterAsStudent(): void{
    this.router.navigate(["/addStudent"]);

  }

}
