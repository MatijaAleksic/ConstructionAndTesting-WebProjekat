import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaincookTableComponent } from './maincook-table.component';

describe('MaincookTableComponent', () => {
  let component: MaincookTableComponent;
  let fixture: ComponentFixture<MaincookTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MaincookTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MaincookTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
