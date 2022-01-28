import { TestBed } from '@angular/core/testing';

import { RestourantTablesService } from './restourant-tables.service';

describe('RestourantTablesService', () => {
  let service: RestourantTablesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestourantTablesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
