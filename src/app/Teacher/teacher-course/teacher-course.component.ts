import { Component, OnInit } from '@angular/core';
import { Course } from '../../course';
import { TeacherService } from '../teacher.service';

@Component({
  selector: 'app-teacher-course',
  templateUrl: './teacher-course.component.html',
  styleUrls: ['./teacher-course.component.css']
})
export class TeacherCourseComponent implements OnInit {

  courses: Array<Course>;

  constructor( private teacherService: TeacherService ) { }

  ngOnInit(): void {
    this.teacherService.getCourseList().subscribe(
      data => {
        this.initializeCourses(data);
      },
      error => {
        console.log(error);
      }
    );
  }

  initializeCourses(data: any): void{
    this.courses = data;
  }




}
