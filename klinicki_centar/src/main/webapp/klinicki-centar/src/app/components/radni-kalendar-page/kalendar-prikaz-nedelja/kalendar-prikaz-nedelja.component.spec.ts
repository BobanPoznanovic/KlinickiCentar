import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KalendarPrikazNedeljaComponent } from './kalendar-prikaz-nedelja.component';

describe('KalendarPrikazNedeljaComponent', () => {
  let component: KalendarPrikazNedeljaComponent;
  let fixture: ComponentFixture<KalendarPrikazNedeljaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KalendarPrikazNedeljaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KalendarPrikazNedeljaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
