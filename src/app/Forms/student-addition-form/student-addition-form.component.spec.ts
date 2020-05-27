import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentAdditionFormComponent } from './student-addition-form.component';

describe('StudentAdditionFormComponent', () => {
  let component: StudentAdditionFormComponent;
  let fixture: ComponentFixture<StudentAdditionFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentAdditionFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentAdditionFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
