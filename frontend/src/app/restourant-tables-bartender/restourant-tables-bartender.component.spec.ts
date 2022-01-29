import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestourantTablesBartenderComponent } from './restourant-tables-bartender.component';

describe('RestourantTablesBartenderComponent', () => {
  let component: RestourantTablesBartenderComponent;
  let fixture: ComponentFixture<RestourantTablesBartenderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestourantTablesBartenderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RestourantTablesBartenderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
