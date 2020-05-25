import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseGradingComponent } from './course-grading.component';

describe('CourseGradingComponent', () => {
  let component: CourseGradingComponent;
  let fixture: ComponentFixture<CourseGradingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseGradingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseGradingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
