import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KalendarPrikazMesecComponent } from './kalendar-prikaz-mesec.component';

describe('KalendarPrikazMesecComponent', () => {
  let component: KalendarPrikazMesecComponent;
  let fixture: ComponentFixture<KalendarPrikazMesecComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KalendarPrikazMesecComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KalendarPrikazMesecComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
