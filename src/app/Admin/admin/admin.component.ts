import { Component, OnInit } from '@angular/core';
import { Course } from '../../Models/course';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  selector: number;

  courses: Array<Course>;

  constructor() { }

  ngOnInit(): void {

    this.getCategory();
  }

  getCategory(): void{

  }

}
