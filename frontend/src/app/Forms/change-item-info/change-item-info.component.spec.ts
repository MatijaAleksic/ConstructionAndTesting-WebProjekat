import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangeItemInfoComponent } from './change-item-info.component';

describe('ChangeItemInfoComponent', () => {
  let component: ChangeItemInfoComponent;
  let fixture: ComponentFixture<ChangeItemInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChangeItemInfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangeItemInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
