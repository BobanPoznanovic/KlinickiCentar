import { TestBed } from '@angular/core/testing';

import { PacijentHomepageService } from './pacijent-homepage.service';

describe('PacijentHomepageService', () => {
  let service: PacijentHomepageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PacijentHomepageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
