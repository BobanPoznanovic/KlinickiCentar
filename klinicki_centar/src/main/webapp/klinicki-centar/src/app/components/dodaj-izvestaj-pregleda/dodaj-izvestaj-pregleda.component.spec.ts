import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DodajIzvestajPregledaComponent } from './dodaj-izvestaj-pregleda.component';

describe('DodajIzvestajPregledaComponent', () => {
  let component: DodajIzvestajPregledaComponent;
  let fixture: ComponentFixture<DodajIzvestajPregledaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DodajIzvestajPregledaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DodajIzvestajPregledaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
