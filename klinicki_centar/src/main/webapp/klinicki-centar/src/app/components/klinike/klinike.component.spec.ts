import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KlinikeComponent } from './klinike.component';

describe('KlinikeComponent', () => {
  let component: KlinikeComponent;
  let fixture: ComponentFixture<KlinikeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KlinikeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KlinikeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
