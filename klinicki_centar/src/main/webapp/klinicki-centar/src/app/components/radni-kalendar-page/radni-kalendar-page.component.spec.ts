import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RadniKalendarPageComponent } from './radni-kalendar-page.component';

describe('RadniKalendarPageComponent', () => {
  let component: RadniKalendarPageComponent;
  let fixture: ComponentFixture<RadniKalendarPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RadniKalendarPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RadniKalendarPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
