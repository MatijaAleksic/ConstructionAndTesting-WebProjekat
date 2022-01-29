import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TakenOrdersTableCooksComponent } from './taken-orders-table-cooks.component';

describe('TakenOrdersTableCooksComponent', () => {
  let component: TakenOrdersTableCooksComponent;
  let fixture: ComponentFixture<TakenOrdersTableCooksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TakenOrdersTableCooksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TakenOrdersTableCooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
