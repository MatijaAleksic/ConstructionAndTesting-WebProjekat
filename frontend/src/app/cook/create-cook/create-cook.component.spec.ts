import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateCookComponent } from './create-cook.component';

describe('CreateCookComponent', () => {
  let component: CreateCookComponent;
  let fixture: ComponentFixture<CreateCookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateCookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateCookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
