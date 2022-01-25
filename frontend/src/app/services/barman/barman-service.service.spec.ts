import { TestBed } from '@angular/core/testing';

import { BarmanService } from './barman-service.service';

describe('BarmanServiceService', () => {
  let service: BarmanService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BarmanService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
