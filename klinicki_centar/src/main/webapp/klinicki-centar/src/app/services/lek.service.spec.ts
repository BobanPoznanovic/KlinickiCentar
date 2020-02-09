import { TestBed } from '@angular/core/testing';

import { LekService } from './lek.service';

describe('LekService', () => {
  let service: LekService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LekService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
