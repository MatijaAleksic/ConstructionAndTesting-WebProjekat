import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangeSalaryManagerComponent } from './change-salary-manager.component';

describe('ChangeSalaryManagerComponent', () => {
  let component: ChangeSalaryManagerComponent;
  let fixture: ComponentFixture<ChangeSalaryManagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChangeSalaryManagerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangeSalaryManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
