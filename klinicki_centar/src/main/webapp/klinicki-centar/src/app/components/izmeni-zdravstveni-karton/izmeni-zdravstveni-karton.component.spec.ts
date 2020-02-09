import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IzmeniZdravstveniKartonComponent } from './izmeni-zdravstveni-karton.component';

describe('IzmeniZdravstveniKartonComponent', () => {
  let component: IzmeniZdravstveniKartonComponent;
  let fixture: ComponentFixture<IzmeniZdravstveniKartonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IzmeniZdravstveniKartonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IzmeniZdravstveniKartonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
