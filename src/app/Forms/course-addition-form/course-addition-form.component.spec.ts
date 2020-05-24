import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseAdditionFormComponent } from './course-addition-form.component';

describe('CourseAdditionFormComponent', () => {
  let component: CourseAdditionFormComponent;
  let fixture: ComponentFixture<CourseAdditionFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseAdditionFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseAdditionFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
