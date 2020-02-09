import { Component, OnInit } from '@angular/core';
import { ZahteviZaRegistracijuService } from 'src/app/services/zahtevi-za-registraciju.service';
import { ZahtevZaRegistraciju } from 'src/app/model/zahtevZaRegistraciju';

@Component({
  selector: 'app-zahtevi-za-registraciju',
  templateUrl: './zahtevi-za-registraciju.component.html',
  styleUrls: ['./zahtevi-za-registraciju.component.css']
})
export class ZahteviZaRegistracijuComponent implements OnInit {

  zahtevi: ZahtevZaRegistraciju[];
  selectedZahtev: ZahtevZaRegistraciju;

  constructor(
    private zahteviService : ZahteviZaRegistracijuService) { }

  ngOnInit(): void {
  }

  onSelect(zahtev: ZahtevZaRegistraciju): void {
    this.selectedZahtev = zahtev;
  }

  getZahtevi() {
    this.zahteviService.getZahtevi()
    .subscribe(zahtevi => this.zahtevi = zahtevi);
  }

  prihvatiZahtev(id: number) {
    console.log('Odobri zahtev: ', id);
    this.zahteviService.prihvatiZahtev(id).subscribe(zahtev => console.log(zahtev));
  }

}
