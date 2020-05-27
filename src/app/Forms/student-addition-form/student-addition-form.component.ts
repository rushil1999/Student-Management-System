import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { Student } from '../../Models/student';

@Component({
  selector: 'app-student-addition-form',
  templateUrl: './student-addition-form.component.html',
  styleUrls: ['./student-addition-form.component.css']
})
export class StudentAdditionFormComponent implements OnInit {


  student: Student;
  studentAdditionForm: FormGroup;

  programs: string[] = ["ICT", "Mechanical", "Chemical", "BCOM", "BBA"];

  semesters: number[] = [1,2,3,4,5,6,7,8];

  constructor(
    private loginService: LoginService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.buildStudentAdditionForm();
  }

  buildStudentAdditionForm(): void{
    this.studentAdditionForm = new FormGroup({
      username: new FormControl('', [Validators.required, Validators.maxLength(10)]),
      fname: new FormControl('',[Validators.required, Validators.maxLength(10)]),
      lname: new FormControl('',[Validators.required, Validators.maxLength(10)]),
      emailaddr: new FormControl('',[Validators.required, Validators.email]),
      program: new FormControl('',[Validators.required, Validators.maxLength(10)]),
      semester: new FormControl('',[Validators.required]),
      password: new FormControl('',[Validators.required, Validators.maxLength(10)])
    })
  }

  fetchDetails(): void{

    this.student = this.studentAdditionForm.value;
    this.student.id = 1;
    this.student.accept = false;
    this.loginService.addStudent(this.student).subscribe(
      data => {
        window.alert(data);
      },
      error => {
        console.log(error);
      }

    )

    this.router.navigate(["/login"]);
  }

}
