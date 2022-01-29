import { TestBed } from '@angular/core/testing';

import { MainCookServiceService } from './main-cook-service.service';

describe('MainCookServiceService', () => {
  let service: MainCookServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MainCookServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
