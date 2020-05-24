import { Component, OnInit } from '@angular/core';
import { Packet } from '../packet';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  packets: Array<Packet>; //To send for updation


  selector: number;

  packet: Packet;

  constructor( private studentService: StudentService ) { }

  ngOnInit(): void {
    this.selector = 1;
  }

  getPacketList(){

  }

  getPacketDetailsFromChild(packet: Packet){
    //console.log("Parent received packet");
    //console.log(packet);
    this.packet = packet;
  }


  getPacketListFromChild(packets: Array<Packet> ){

    //console.log("Packets received from child");


    if(packets.length>0){
      this.studentService.saveStudentCourses(packets).subscribe(
        data => {
          console.log("Courses Saved");
        }, 
        error => {
          console.log(error);
        }
      )
    }
    else{
      
      window.alert("No courses selected");
    }
  }

}
