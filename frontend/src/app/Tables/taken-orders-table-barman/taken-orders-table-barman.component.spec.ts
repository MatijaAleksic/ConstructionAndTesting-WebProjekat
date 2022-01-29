import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TakenOrdersTableBarmanComponent } from './taken-orders-table-barman.component';

describe('TakenOrdersTableBarmanComponent', () => {
  let component: TakenOrdersTableBarmanComponent;
  let fixture: ComponentFixture<TakenOrdersTableBarmanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TakenOrdersTableBarmanComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TakenOrdersTableBarmanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
