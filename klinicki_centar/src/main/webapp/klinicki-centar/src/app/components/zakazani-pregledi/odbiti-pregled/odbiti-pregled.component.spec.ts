import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OdbitiPregledComponent } from './odbiti-pregled.component';

describe('OdbitiPregledComponent', () => {
  let component: OdbitiPregledComponent;
  let fixture: ComponentFixture<OdbitiPregledComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OdbitiPregledComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OdbitiPregledComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
