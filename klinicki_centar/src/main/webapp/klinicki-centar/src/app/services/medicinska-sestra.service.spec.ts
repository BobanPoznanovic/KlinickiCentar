import { TestBed } from '@angular/core/testing';

import { MedicinskaSestraService } from './medicinska-sestra.service';

describe('MedicinskaSestraService', () => {
  let service: MedicinskaSestraService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MedicinskaSestraService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
