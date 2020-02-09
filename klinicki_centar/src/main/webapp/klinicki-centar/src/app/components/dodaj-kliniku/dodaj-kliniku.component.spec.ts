import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DodajKlinikuComponent } from './dodaj-kliniku.component';

describe('DodajKlinikuComponent', () => {
  let component: DodajKlinikuComponent;
  let fixture: ComponentFixture<DodajKlinikuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DodajKlinikuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DodajKlinikuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
