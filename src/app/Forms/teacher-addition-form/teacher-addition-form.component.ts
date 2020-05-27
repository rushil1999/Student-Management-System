import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Teacher } from '../../Models/teacher';
import { LoginService } from '../login.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-teacher-addition-form',
  templateUrl: './teacher-addition-form.component.html',
  styleUrls: ['./teacher-addition-form.component.css']
})
export class TeacherAdditionFormComponent implements OnInit {


  teacherAddtionForm: FormGroup;

  teacher: Teacher;

  constructor( 
    private loginService: LoginService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.buildTeacherAddtionForm();
  }

  buildTeacherAddtionForm(): void{
    this.teacherAddtionForm = new FormGroup({
      username: new FormControl('',[Validators.required, Validators.maxLength(10)]),
      fname: new FormControl('',[Validators.required, Validators.maxLength(10)]),
      lname: new FormControl('',[Validators.required, Validators.maxLength(10)]),
      emailaddr: new FormControl('',[Validators.required, Validators.email]),
      qualifications: new FormControl('',[Validators.required, Validators.maxLength(10)]),
      password: new FormControl('',[Validators.required, Validators.maxLength(10)])
    })
  };

  fetchDetails(): void{
    this.teacher = this.teacherAddtionForm.value;

    this.loginService.addTeacher(this.teacher).subscribe(
      data => {
        console.log(data);
        window.alert(data);
      },
      error => {
        console.log(error);
      }
    );

    this.router.navigate(["/login"]);
    
  }



}
