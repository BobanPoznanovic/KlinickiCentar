import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AktivacijaNalogaComponent } from './aktivacija-naloga.component';

describe('AktivacijaNalogaComponent', () => {
  let component: AktivacijaNalogaComponent;
  let fixture: ComponentFixture<AktivacijaNalogaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AktivacijaNalogaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AktivacijaNalogaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
