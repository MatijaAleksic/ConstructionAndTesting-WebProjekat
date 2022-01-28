import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderedItemSheetComponent } from './ordered-item-sheet.component';

describe('OrderedItemSheetComponent', () => {
  let component: OrderedItemSheetComponent;
  let fixture: ComponentFixture<OrderedItemSheetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderedItemSheetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderedItemSheetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
