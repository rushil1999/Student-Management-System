import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TeacherComponent } from './Teacher/teacher/teacher.component';
import { StudentComponent } from './Student/student/student.component';


const routes: Routes = [
  { path: "teacher", component: TeacherComponent, runGuardsAndResolvers: 'always' },
  { path: "teacher/addCourse", component: TeacherComponent, runGuardsAndResolvers: 'always' },
  { path: "student", component: StudentComponent, runGuardsAndResolvers: 'always'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
