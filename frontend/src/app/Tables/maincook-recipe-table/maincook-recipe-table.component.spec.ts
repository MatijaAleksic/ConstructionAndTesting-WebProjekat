import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaincookRecipeTableComponent } from './maincook-recipe-table.component';

describe('MaincookRecipeTableComponent', () => {
  let component: MaincookRecipeTableComponent;
  let fixture: ComponentFixture<MaincookRecipeTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MaincookRecipeTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MaincookRecipeTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
