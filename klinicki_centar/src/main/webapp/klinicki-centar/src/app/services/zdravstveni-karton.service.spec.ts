import { TestBed } from '@angular/core/testing';

import { ZdravstveniKartonService } from './zdravstveni-karton.service';

describe('ZdravstveniKartonService', () => {
  let service: ZdravstveniKartonService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZdravstveniKartonService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
