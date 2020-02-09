import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminKlinickogCentraHomeComponent } from './admin-klinickog-centra-home.component';

describe('AdminKlinickogCentraHomeComponent', () => {
  let component: AdminKlinickogCentraHomeComponent;
  let fixture: ComponentFixture<AdminKlinickogCentraHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminKlinickogCentraHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminKlinickogCentraHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
