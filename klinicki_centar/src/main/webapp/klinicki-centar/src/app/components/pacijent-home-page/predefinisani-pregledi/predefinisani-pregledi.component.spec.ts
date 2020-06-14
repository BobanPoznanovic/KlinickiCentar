import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PredefinisaniPreglediComponent } from './predefinisani-pregledi.component';

describe('PredefinisaniPreglediComponent', () => {
  let component: PredefinisaniPreglediComponent;
  let fixture: ComponentFixture<PredefinisaniPreglediComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PredefinisaniPreglediComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PredefinisaniPreglediComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
