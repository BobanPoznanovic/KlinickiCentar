import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OdbitiZahtevZaRegistracijuComponent } from './odbiti-zahtev-za-registraciju.component';

describe('OdbitiZahtevZaRegistracijuComponent', () => {
  let component: OdbitiZahtevZaRegistracijuComponent;
  let fixture: ComponentFixture<OdbitiZahtevZaRegistracijuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OdbitiZahtevZaRegistracijuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OdbitiZahtevZaRegistracijuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
