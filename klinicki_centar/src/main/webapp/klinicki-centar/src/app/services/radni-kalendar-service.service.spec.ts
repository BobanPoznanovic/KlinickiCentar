import { TestBed } from '@angular/core/testing';

import { RadniKalendarServiceService } from './radni-kalendar-service.service';

describe('RadniKalendarServiceService', () => {
  let service: RadniKalendarServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RadniKalendarServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
