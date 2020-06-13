import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PotvrditiPregledComponent } from './potvrditi-pregled.component';

describe('PotvrditiPregledComponent', () => {
  let component: PotvrditiPregledComponent;
  let fixture: ComponentFixture<PotvrditiPregledComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PotvrditiPregledComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PotvrditiPregledComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
