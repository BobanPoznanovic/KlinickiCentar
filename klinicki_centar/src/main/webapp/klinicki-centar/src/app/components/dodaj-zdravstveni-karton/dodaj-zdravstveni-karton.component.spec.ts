import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DodajZdravstveniKartonComponent } from './dodaj-zdravstveni-karton.component';

describe('DodajZdravstveniKartonComponent', () => {
  let component: DodajZdravstveniKartonComponent;
  let fixture: ComponentFixture<DodajZdravstveniKartonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DodajZdravstveniKartonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DodajZdravstveniKartonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
