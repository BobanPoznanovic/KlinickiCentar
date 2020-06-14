import { TestBed } from '@angular/core/testing';

import { AktivacijaNalogaService } from './aktivacija-naloga.service';

describe('AktivacijaNalogaService', () => {
  let service: AktivacijaNalogaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AktivacijaNalogaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
