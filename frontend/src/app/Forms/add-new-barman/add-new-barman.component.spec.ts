import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewBarmanComponent } from './add-new-barman.component';

describe('AddNewBarmanComponent', () => {
  let component: AddNewBarmanComponent;
  let fixture: ComponentFixture<AddNewBarmanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddNewBarmanComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewBarmanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
