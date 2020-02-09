import { TestBed } from '@angular/core/testing';

import { ZahtevZaOdsustvoService } from './zahtev-za-odsustvo.service';

describe('ZahtevZaOdsustvoService', () => {
  let service: ZahtevZaOdsustvoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZahtevZaOdsustvoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
