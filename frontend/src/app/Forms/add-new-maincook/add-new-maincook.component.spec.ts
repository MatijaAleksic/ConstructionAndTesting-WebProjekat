import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewMaincookComponent } from './add-new-maincook.component';

describe('AddNewMaincookComponent', () => {
  let component: AddNewMaincookComponent;
  let fixture: ComponentFixture<AddNewMaincookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddNewMaincookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewMaincookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
