import { TestBed } from '@angular/core/testing';

import { PotvrditiPregledService } from './potvrditi-pregled.service';

describe('PotvrditiPregledService', () => {
  let service: PotvrditiPregledService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PotvrditiPregledService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
