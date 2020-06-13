import { TestBed } from '@angular/core/testing';

import { OdbitiPregledService } from './odbiti-pregled.service';

describe('OdbitiPregledService', () => {
  let service: OdbitiPregledService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OdbitiPregledService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
