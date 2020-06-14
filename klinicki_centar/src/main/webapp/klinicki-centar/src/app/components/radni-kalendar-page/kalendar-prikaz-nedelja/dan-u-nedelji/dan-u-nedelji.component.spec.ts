import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DanUNedeljiComponent } from './dan-u-nedelji.component';

describe('DanUNedeljiComponent', () => {
  let component: DanUNedeljiComponent;
  let fixture: ComponentFixture<DanUNedeljiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DanUNedeljiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DanUNedeljiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
