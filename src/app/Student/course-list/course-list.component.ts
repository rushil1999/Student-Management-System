import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Packet } from '../../Models/packet'
import { StudentService } from '../student.service';
import { Router, NavigationEnd } from '@angular/router';


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

  navigationSubscription: any;

  constructor( private studentService: StudentService,
    private route: Router ) { 

    this.navigationSubscription = this.route.events.subscribe((e: any) => {
      // If it is a NavigationEnd event re-initalise the component
      if (e instanceof NavigationEnd) {
        //console.log(" Child Re-initialised");
        this.ngOnInit();
      }
    });

  }

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
        console.log(error);
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

    if(this.studentCourses.length == 5){
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
        let index: number = this.studentCourses.indexOf(packet);
        if(index != -1){
          this.packets.splice(index, 1);
        }
        this.studentCourses.push(packet);
      }  
    }  

  }


  dropCourse(packet: Packet): void{
    let index: number = this.studentCourses.indexOf(packet);
    if(index != -1){
      this.studentCourses.splice(index, 1);
    }
    this.packets.push(packet);
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
