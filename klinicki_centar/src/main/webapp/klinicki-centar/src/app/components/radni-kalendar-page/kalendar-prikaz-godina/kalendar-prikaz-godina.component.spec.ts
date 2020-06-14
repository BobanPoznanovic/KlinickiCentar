import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KalendarPrikazGodinaComponent } from './kalendar-prikaz-godina.component';

describe('KalendarPrikazGodinaComponent', () => {
  let component: KalendarPrikazGodinaComponent;
  let fixture: ComponentFixture<KalendarPrikazGodinaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KalendarPrikazGodinaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KalendarPrikazGodinaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
