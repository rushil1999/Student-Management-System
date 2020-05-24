import { Component, OnInit, Input, SimpleChanges } from '@angular/core';
import { Packet } from '../packet';

@Component({
  selector: 'app-course-details',
  templateUrl: './course-details.component.html',
  styleUrls: ['./course-details.component.css']
})
export class CourseDetailsComponent implements OnInit {


  @Input() packet: Packet;

  constructor() { }

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void{
    //console.log("Change Detected");
    //console.log(changes.packet.currentValue);
    this.packet =  changes.packet.currentValue;
  }



}
