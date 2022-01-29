import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestourantTablesComponent } from './restourant-tables.component';

describe('RestourantTablesComponent', () => {
  let component: RestourantTablesComponent;
  let fixture: ComponentFixture<RestourantTablesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestourantTablesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RestourantTablesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
