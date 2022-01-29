import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewWaiterComponent } from './add-new-waiter.component';

describe('AddNewWaiterComponent', () => {
  let component: AddNewWaiterComponent;
  let fixture: ComponentFixture<AddNewWaiterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddNewWaiterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewWaiterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
