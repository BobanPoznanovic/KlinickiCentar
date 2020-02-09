import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DodajAdminaKlinikeComponent } from './dodaj-admina-klinike.component';

describe('DodajAdminaKlinikeComponent', () => {
  let component: DodajAdminaKlinikeComponent;
  let fixture: ComponentFixture<DodajAdminaKlinikeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DodajAdminaKlinikeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DodajAdminaKlinikeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
