import { TestBed } from '@angular/core/testing';

import { KlinikaService } from './klinika.service';

describe('KlinikaService', () => {
  let service: KlinikaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KlinikaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
