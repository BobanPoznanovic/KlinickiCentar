import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KalendarPrikazDanComponent } from './kalendar-prikaz-dan.component';

describe('KalendarPrikazDanComponent', () => {
  let component: KalendarPrikazDanComponent;
  let fixture: ComponentFixture<KalendarPrikazDanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KalendarPrikazDanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KalendarPrikazDanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
