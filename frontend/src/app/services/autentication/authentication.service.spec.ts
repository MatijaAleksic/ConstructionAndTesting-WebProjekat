import { TestBed } from '@angular/core/testing';

import { AuthentitacionService } from '../autentication/authentitacion.service';//'./authentication.service';

describe('AuthentitacionService', () => {
  let service: AuthentitacionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthentitacionService);
  });

  it('should be created', () => {
    const service: AuthentitacionService = TestBed.get(AuthentitacionService);
    expect(service).toBeTruthy();
  });
});
