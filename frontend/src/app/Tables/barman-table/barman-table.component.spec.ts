import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarmanTableComponent } from './barman-table.component';

describe('BarmanTableComponent', () => {
  let component: BarmanTableComponent;
  let fixture: ComponentFixture<BarmanTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BarmanTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BarmanTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
