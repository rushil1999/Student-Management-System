import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeacherAdditionFormComponent } from './teacher-addition-form.component';

describe('TeacherAdditionFormComponent', () => {
  let component: TeacherAdditionFormComponent;
  let fixture: ComponentFixture<TeacherAdditionFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeacherAdditionFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeacherAdditionFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
