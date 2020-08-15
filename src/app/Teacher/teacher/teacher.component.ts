import { Component, OnInit } from '@angular/core';
import { Course } from '../../Models/course';
import { TeacherService } from '../teacher.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.css']
})
export class TeacherComponent implements OnInit {

  selector: number;

  array: string[];

  constructor( private teacherService: TeacherService, 
    private router: Router) { }

  ngOnInit(): void {

    this.array = this.router.url.split("/", 4);
    //console.log(this.array);
    if(this.array[2] == "addCourse"){
      this.selector = 2;

    }
    else if(this.array.length>2 && this.array[2] != ""){
      this.selector = 3;

    }
    else{
      this.selector = 1;
    }
    
  }



  getCourseFromChild(course: Course){
    //console.log("Parent received course");
    course.accept = false;
    course.id = 1;
    course.teacher_id = Number(localStorage.getItem("teacher_id"));
    //console.log(course);
    this.teacherService.addCourse(course).subscribe( 
      data => {
        window.alert(data);
      },
      error => {
        console.log(error.message);
      });
  }


  goToAddCourse(): void{
    this.router.navigate(["/teacher/addCourse"]);
  }

  goToViewCourses(): void{
    this.router.navigate(["/teacher"]);
    this.selector = 1;
  }

  signOut(): void{

      this.router.navigate(["/login"]);

  }

}