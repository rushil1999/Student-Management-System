import { Component, OnInit } from '@angular/core';
import { Course } from '../../Models/course';
import { TeacherService } from '../teacher.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-teacher-course',
  templateUrl: './teacher-course.component.html',
  styleUrls: ['./teacher-course.component.css']
})
export class TeacherCourseComponent implements OnInit {

  courses: Array<Course>;

  constructor( private teacherService: TeacherService, 
    private router: Router ) { }

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

  goToCourseDetails(course_name: string): void{
    this.router.navigate(["teacher/",course_name]);
  }

  sortCoursesByCredits(): void{
    this.courses.sort((a,b) => (a.credits-b.credits));
  }


}
