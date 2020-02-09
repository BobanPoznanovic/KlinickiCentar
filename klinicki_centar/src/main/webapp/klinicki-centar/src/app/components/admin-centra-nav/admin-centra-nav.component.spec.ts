import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCentraNavComponent } from './admin-centra-nav.component';

describe('AdminCentraNavComponent', () => {
  let component: AdminCentraNavComponent;
  let fixture: ComponentFixture<AdminCentraNavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCentraNavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCentraNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
