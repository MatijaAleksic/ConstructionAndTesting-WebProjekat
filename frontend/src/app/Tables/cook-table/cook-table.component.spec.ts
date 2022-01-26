import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CookTableComponent } from './cook-table.component';

describe('CookTableComponent', () => {
  let component: CookTableComponent;
  let fixture: ComponentFixture<CookTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CookTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CookTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
