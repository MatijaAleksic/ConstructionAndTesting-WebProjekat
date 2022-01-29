import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangePriceItemComponent } from './change-price-item.component';

describe('ChangePriceItemComponent', () => {
  let component: ChangePriceItemComponent;
  let fixture: ComponentFixture<ChangePriceItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChangePriceItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangePriceItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
