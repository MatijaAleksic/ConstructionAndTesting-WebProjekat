import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdersTableCooksComponent } from './orders-table-cooks.component';

describe('OrdersTableCooksComponent', () => {
  let component: OrdersTableCooksComponent;
  let fixture: ComponentFixture<OrdersTableCooksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrdersTableCooksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdersTableCooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
