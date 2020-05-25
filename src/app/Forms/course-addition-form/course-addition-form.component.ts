import { Component, OnInit, Output } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms'; 
import { Course } from '../../Models/course';
import { EventEmitter } from '@angular/core';
import { formValidatorIsNumeric} from '../form-validators';

@Component({
  selector: 'app-course-addition-form',
  templateUrl: './course-addition-form.component.html',
  styleUrls: ['./course-addition-form.component.css']
})
export class CourseAdditionFormComponent implements OnInit {

  @Output() courseAdditionEvent = new EventEmitter<Course>();

  courseAdditionForm:  FormGroup;

  course: Course;

  credits: number[] = [1, 1.5, 2, 2.5, 3];

  constructor() { }

  ngOnInit(): void {
    this.buildForm();
  }

  buildForm(){
    this.courseAdditionForm = new FormGroup({
      name : new FormControl('', [Validators.required,Validators.maxLength(10)]),
      outline: new FormControl('', [Validators.required, Validators.maxLength(20)]),
      capacity: new FormControl('', [Validators.required, formValidatorIsNumeric]),
      credits: new FormControl('', [Validators.required, formValidatorIsNumeric])
    });
  }

  fetchDetails(): void{
    this.course = this.courseAdditionForm.value;
    console.log(this.course);    
    this.courseAdditionEvent.emit(this.course);

    this.courseAdditionForm.reset();
  }



}


