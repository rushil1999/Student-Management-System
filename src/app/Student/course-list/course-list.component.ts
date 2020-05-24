import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Packet } from '../packet'
import { StudentService } from '../student.service';


@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {

  //List of all courses.
  packets: Array<Packet>;

  @Output() packetEvent = new EventEmitter<Packet>();

  @Output() courseSaveEvent = new EventEmitter<Array<Packet>>();

  //List of courses already taken by student.
  studentCourses: Array<Packet>; 

  constructor( private studentService: StudentService ) { }

  ngOnInit(): void {
    this.getOptedCourseList();
    this.getCourseList();
  }


  //Gets list of courses taken by student
  getOptedCourseList(){
    this.studentService.getCourseList(false).subscribe(
      data => {
        this.initializeOptedCourseList(data);
      },
      error => {
        console.log(error);
      }
    )

  }

  //Gets list of all courses
  getCourseList(){
    this.studentService.getCourseList(true).subscribe(
      data => {
        this.initializeCourseList(data);
      },
      error => {
        console.log("error");
      }

    )
  }

  initializeCourseList( data: any): void{
    this.packets = data;

    
  }

  initializeOptedCourseList( data: any): void{
    this.studentCourses = data;
  }

  addCourse(packet: Packet){

    if(this.studentCourses.length == 3){
      window.alert("Course Limit Exceeded");
    }
    else{
      let i: number, temp: number;
      temp = 0;
      for(i=0;i<this.studentCourses.length;i++){

        if(packet == this.studentCourses[i]){
          window.alert("Course already added");
          temp = 1;
        }
      }
      if(temp == 0){
        this.studentCourses.push(packet);
      }  
    }  

  }


  dropCourse(packet: Packet): void{
    let index: number = this.studentCourses.indexOf(packet);
    if(index != -1){
      this.studentCourses.splice(index, 1);
    }
  }
  showDetails(packet: Packet){
    this.packetEvent.emit(packet);
  }

  saveCourses(): void{
    if(this.studentCourses.length > 0){
      this.courseSaveEvent.emit(this.studentCourses);
    }
  }

  refreshList(): void{
    this.studentCourses = [];

  }


}
