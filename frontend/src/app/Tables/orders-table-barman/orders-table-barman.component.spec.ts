import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdersTableBarmanComponent } from './orders-table-barman.component';

describe('OrdersTableBarmanComponent', () => {
  let component: OrdersTableBarmanComponent;
  let fixture: ComponentFixture<OrdersTableBarmanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrdersTableBarmanComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdersTableBarmanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
