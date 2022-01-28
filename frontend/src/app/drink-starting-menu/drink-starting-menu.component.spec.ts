import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DrinkStartingMenuComponent } from './drink-starting-menu.component';

describe('DrinkStartingMenuComponent', () => {
  let component: DrinkStartingMenuComponent;
  let fixture: ComponentFixture<DrinkStartingMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DrinkStartingMenuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DrinkStartingMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
