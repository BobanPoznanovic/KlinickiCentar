import { TestBed } from '@angular/core/testing';

import { IzmeniProfilService } from './izmeni-profil.service';

describe('IzmeniProfilService', () => {
  let service: IzmeniProfilService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IzmeniProfilService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
