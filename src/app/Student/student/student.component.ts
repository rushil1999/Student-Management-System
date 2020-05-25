import { Component, OnInit } from '@angular/core';
import { Packet } from '../../Models/packet';
import { StudentService } from '../student.service';
import { Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  packets: Array<Packet>; //To send for updation


  selector: number;

  packet: Packet;
  navigationSubscription: any;

  constructor( private studentService: StudentService,
    private router: Router ) { 
      this.selector = 0;

      this.navigationSubscription = this.router.events.subscribe((e: any) => {
        // If it is a NavigationEnd event re-initalise the component
        if (e instanceof NavigationEnd) {
          //console.log(" Parent Re-initialised");
          // this.ngOnInit();
        }
      });

    }

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

  //Receiving packets from Child
  getPacketListFromChild(packets: Array<Packet> ){

    //console.log("Packets received from child");


    if(packets.length>0){
      this.studentService.saveStudentCourses(packets).subscribe(
        data => {
          window.alert(data);
          console.log(this.router.url);
          this.router.navigate(["/student"]);
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

  signOut():void{
    this.router.navigate(["/login"]);
    
  }

}
