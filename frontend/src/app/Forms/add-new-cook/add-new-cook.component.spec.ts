import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewCookComponent } from './add-new-cook.component';

describe('AddNewCookComponent', () => {
  let component: AddNewCookComponent;
  let fixture: ComponentFixture<AddNewCookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddNewCookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewCookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
