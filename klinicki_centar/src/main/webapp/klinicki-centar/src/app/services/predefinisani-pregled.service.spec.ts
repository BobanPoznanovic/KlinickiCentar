import { TestBed } from '@angular/core/testing';

import { PredefinisaniPregledService } from './predefinisani-pregled.service';

describe('PredefinisaniPregledService', () => {
  let service: PredefinisaniPregledService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PredefinisaniPregledService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
