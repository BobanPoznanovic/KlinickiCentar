import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EventUDanuComponent } from './event-u-danu.component';

describe('EventUDanuComponent', () => {
  let component: EventUDanuComponent;
  let fixture: ComponentFixture<EventUDanuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EventUDanuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventUDanuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
