import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TeacherComponent } from './Teacher/teacher/teacher.component';
import { StudentComponent } from './Student/student/student.component';
import { LogInComponent } from './Forms/log-in/log-in.component';
import { TeacherAdditionFormComponent } from './Forms/teacher-addition-form/teacher-addition-form.component';
import { StudentAdditionFormComponent } from './Forms/student-addition-form/student-addition-form.component';


const routes: Routes = [
  { path: "teacher", component: TeacherComponent, runGuardsAndResolvers: 'always' },
  { path: "teacher/addCourse", component: TeacherComponent, runGuardsAndResolvers: 'always' },
  { path: "student", component: StudentComponent, runGuardsAndResolvers: 'always'},
  { path: "teacher/:course", component: TeacherComponent, runGuardsAndResolvers: 'always'},
  { path: "login", component: LogInComponent, runGuardsAndResolvers: 'always'},
  { path: "addTeacher", component: TeacherAdditionFormComponent },
  { path: "addStudent", component: StudentAdditionFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
