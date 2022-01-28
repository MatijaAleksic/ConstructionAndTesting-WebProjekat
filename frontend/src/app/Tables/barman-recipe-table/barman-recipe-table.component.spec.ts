import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarmanRecipeTableComponent } from './barman-recipe-table.component';

describe('BarmanRecipeTableComponent', () => {
  let component: BarmanRecipeTableComponent;
  let fixture: ComponentFixture<BarmanRecipeTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BarmanRecipeTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BarmanRecipeTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
