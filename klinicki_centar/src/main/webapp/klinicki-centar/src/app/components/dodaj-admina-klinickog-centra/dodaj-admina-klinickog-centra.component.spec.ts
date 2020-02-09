import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DodajAdminaKlinickogCentraComponent } from './dodaj-admina-klinickog-centra.component';

describe('DodajAdminaKlinickogCentraComponent', () => {
  let component: DodajAdminaKlinickogCentraComponent;
  let fixture: ComponentFixture<DodajAdminaKlinickogCentraComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DodajAdminaKlinickogCentraComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DodajAdminaKlinickogCentraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
