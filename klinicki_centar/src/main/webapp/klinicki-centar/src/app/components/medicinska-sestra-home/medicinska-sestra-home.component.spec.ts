import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicinskaSestraHomeComponent } from './medicinska-sestra-home.component';

describe('MedicinskaSestraHomeComponent', () => {
  let component: MedicinskaSestraHomeComponent;
  let fixture: ComponentFixture<MedicinskaSestraHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicinskaSestraHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicinskaSestraHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
