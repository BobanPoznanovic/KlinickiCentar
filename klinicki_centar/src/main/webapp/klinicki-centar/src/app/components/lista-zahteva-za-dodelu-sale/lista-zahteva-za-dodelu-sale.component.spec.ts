import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaZahtevaZaDodeluSaleComponent } from './lista-zahteva-za-dodelu-sale.component';

describe('ListaZahtevaZaDodeluSaleComponent', () => {
  let component: ListaZahtevaZaDodeluSaleComponent;
  let fixture: ComponentFixture<ListaZahtevaZaDodeluSaleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaZahtevaZaDodeluSaleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaZahtevaZaDodeluSaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
