import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodStartingMenuComponent } from './food-starting-menu.component';

describe('FoodStartingMenuComponent', () => {
  let component: FoodStartingMenuComponent;
  let fixture: ComponentFixture<FoodStartingMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FoodStartingMenuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodStartingMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
