import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DodajZahtevZaOdsustvoComponent } from './dodaj-zahtev-za-odsustvo.component';

describe('DodajZahtevZaOdsustvoComponent', () => {
  let component: DodajZahtevZaOdsustvoComponent;
  let fixture: ComponentFixture<DodajZahtevZaOdsustvoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DodajZahtevZaOdsustvoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DodajZahtevZaOdsustvoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
