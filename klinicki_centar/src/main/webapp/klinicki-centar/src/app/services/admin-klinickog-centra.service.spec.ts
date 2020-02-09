import { TestBed } from '@angular/core/testing';

import { AdminKlinickogCentraService } from './admin-klinickog-centra.service';

describe('AdminKlinickogCentraService', () => {
  let service: AdminKlinickogCentraService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminKlinickogCentraService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
