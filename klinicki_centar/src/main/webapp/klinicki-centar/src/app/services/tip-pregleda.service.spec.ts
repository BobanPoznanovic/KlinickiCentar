import { TestBed } from '@angular/core/testing';

import { TipPregledaService } from './tip-pregleda.service';

describe('TipPregledaService', () => {
  let service: TipPregledaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TipPregledaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
