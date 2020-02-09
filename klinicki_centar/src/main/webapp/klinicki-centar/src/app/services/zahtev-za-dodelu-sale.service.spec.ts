import { TestBed } from '@angular/core/testing';

import { ZahtevZaDodeluSaleService } from './zahtev-za-dodelu-sale.service';

describe('ZahtevZaDodeluSaleService', () => {
  let service: ZahtevZaDodeluSaleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZahtevZaDodeluSaleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
