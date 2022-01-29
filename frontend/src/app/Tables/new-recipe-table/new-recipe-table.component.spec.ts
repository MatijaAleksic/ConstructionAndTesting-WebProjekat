import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewRecipeTableComponent } from './new-recipe-table.component';

describe('NewRecipeTableComponent', () => {
  let component: NewRecipeTableComponent;
  let fixture: ComponentFixture<NewRecipeTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewRecipeTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewRecipeTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
