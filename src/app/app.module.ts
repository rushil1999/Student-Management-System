import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule }  from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TeacherComponent } from './Teacher/teacher/teacher.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material';
import { CourseAdditionFormComponent } from './Forms/course-addition-form/course-addition-form.component';
import { TeacherCourseComponent } from './Teacher/teacher-course/teacher-course.component';
import { StudentComponent } from './Student/student/student.component';
import { CourseListComponent } from './Student/course-list/course-list.component';
import { CourseDetailsComponent } from './Student/course-details/course-details.component';

@NgModule({
  declarations: [
    AppComponent,
    TeacherComponent,
    CourseAdditionFormComponent,
    TeacherCourseComponent,
    StudentComponent,
    CourseListComponent,
    CourseDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule, 
    MaterialModule, 
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }