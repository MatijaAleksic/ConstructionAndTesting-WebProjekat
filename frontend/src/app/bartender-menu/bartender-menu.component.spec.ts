import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BartenderMenuComponent } from './bartender-menu.component';

describe('BartenderMenuComponent', () => {
  let component: BartenderMenuComponent;
  let fixture: ComponentFixture<BartenderMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BartenderMenuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BartenderMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
