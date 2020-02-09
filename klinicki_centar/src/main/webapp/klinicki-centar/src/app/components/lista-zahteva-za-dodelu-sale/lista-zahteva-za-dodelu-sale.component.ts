import { Component, OnInit } from '@angular/core';
import { ZahtevZaDodeluSaleService } from 'src/app/services/zahtev-za-dodelu-sale.service';
import { ZahtevZaDodeluSale } from 'src/app/model/zahtevZaDodeluSale';

@Component({
  selector: 'app-lista-zahteva-za-dodelu-sale',
  templateUrl: './lista-zahteva-za-dodelu-sale.component.html',
  styleUrls: ['./lista-zahteva-za-dodelu-sale.component.css']
})
export class ListaZahtevaZaDodeluSaleComponent implements OnInit {

  constructor(private zahtevService: ZahtevZaDodeluSaleService) { }

  zahtevi: ZahtevZaDodeluSale[];

  ngOnInit(): void {
    this.zahtevService.getAll().subscribe(zahtevi => this.zahtevi = zahtevi)
  }

  obradiZahtev(zahtev: ZahtevZaDodeluSale) {
    this.zahtevService.check(zahtev).subscribe(zahtev => console.log(zahtev));
  }

}
