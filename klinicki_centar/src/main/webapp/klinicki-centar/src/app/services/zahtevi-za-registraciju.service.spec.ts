import { TestBed } from '@angular/core/testing';

import { ZahteviZaRegistracijuService } from './zahtevi-za-registraciju.service';

describe('ZahteviZaRegistracijuService', () => {
  let service: ZahteviZaRegistracijuService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZahteviZaRegistracijuService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
