import {TestBed} from '@angular/core/testing';

import {RoleTournantService} from './role-tournant.service';

describe('RoleTournantService', () => {
  let service: RoleTournantService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RoleTournantService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
