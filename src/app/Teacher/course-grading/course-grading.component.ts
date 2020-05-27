import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentGrade }  from '../../Models/studentGrade'; 
import { TeacherService } from '../teacher.service';

@Component({
  selector: 'app-course-grading',
  templateUrl: './course-grading.component.html',
  styleUrls: ['./course-grading.component.css']
})
export class CourseGradingComponent implements OnInit {

  course: string;
  arr: string[];

  grades: string[] = ["A+", "A", "A-", "B+", "B-", "B", "C", "F", null];

  orders: string[] = ["Ascending", "Descending"];


  students: Array<StudentGrade>;
  constructor( private router: Router,
    private teacherService: TeacherService ) { }

  ngOnInit(): void {
    this.getCourseFromUrl();

    this.getStudentListForCourse();
  }


  getCourseFromUrl(): void{
    this.arr = this.router.url.split("/",4);
    this.course = this.arr[2];
    console.log("Selected Course: " + this.course);
  }

  getStudentListForCourse(): void{
    this.teacherService.getStudentListForCourse(this.course).subscribe(
      data => {
        this.initializeStudentList(data);
      },
      error => {
        console.log(error);
      }

    )
  }

  initializeStudentList(data: any): void{
    this.students = data;

  }

  saveGrades(): void{
    console.log(this.students);
    this.teacherService.saveStudentsGrades(this.students, this.course).subscribe(
      data => {
        window.alert(data);
      },
      error => {
        console.log(error);
      }
    );
  }

  
  sortStudentsByName(value: any): void{
    if(value == "Ascending"){
      this.students.sort((a,b) => (a.student.fname > b.student.fname ? -1 : 1));
    }
    else{
      this.students.sort((a,b) => (b.student.fname > a.student.fname ? -1 : 1));
    } 
  }

  sortStudentsByGrade(value: any): void{
    if(value == "Ascending"){
      this.students.sort((a,b) => (b.grade > a.grade? -1 : 1));
    }
    else{
      this.students.sort((a,b) => (a.grade > b.grade ? -1 : 1));
    }
  }
        
}
