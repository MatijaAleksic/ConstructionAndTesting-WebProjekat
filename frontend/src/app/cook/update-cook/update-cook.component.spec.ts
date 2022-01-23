import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCookComponent } from './update-cook.component';

describe('UpdateCookComponent', () => {
  let component: UpdateCookComponent;
  let fixture: ComponentFixture<UpdateCookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateCookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateCookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
