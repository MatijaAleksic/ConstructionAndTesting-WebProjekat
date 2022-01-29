import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangeSalaryUserComponent } from './change-salary-user.component';

describe('ChangeSalaryUserComponent', () => {
  let component: ChangeSalaryUserComponent;
  let fixture: ComponentFixture<ChangeSalaryUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChangeSalaryUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangeSalaryUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
