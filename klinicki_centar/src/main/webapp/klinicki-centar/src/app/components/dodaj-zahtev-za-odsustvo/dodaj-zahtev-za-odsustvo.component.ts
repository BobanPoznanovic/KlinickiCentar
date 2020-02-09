import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ZahtevZaOdsustvoService } from 'src/app/services/zahtev-za-odsustvo.service';
import { ZahtevZaOdsustvo } from 'src/app/model/zahtevZaOdsustvo';

@Component({
  selector: 'app-dodaj-zahtev-za-odsustvo',
  templateUrl: './dodaj-zahtev-za-odsustvo.component.html',
  styleUrls: ['./dodaj-zahtev-za-odsustvo.component.css']
})
export class DodajZahtevZaOdsustvoComponent implements OnInit {

  tipovi: string[] = ["Godisnji_odmor","Odsustvo"];

  zahtevForm = new FormGroup({
    tip_odsustva: new FormControl(''),
    datum_pocetka: new FormControl(''),
    datum_kraja: new FormControl('')
  });

  constructor(private zahtevService: ZahtevZaOdsustvoService) { }

  ngOnInit(): void {
  }

  onSubmit() {

    let zahtev = new ZahtevZaOdsustvo();
    zahtev.podnosilac_zahtevaID = 1;
    zahtev.tip_odsustva = this.zahtevForm.controls.tip_odsustva.value;
    zahtev.datum_pocetka = this.zahtevForm.controls.datum_pocetka.value;
    zahtev.datum_kraja = this.zahtevForm.controls.datum_kraja.value;
    zahtev.status_odobrenja = "Na_cekanju";

    this.zahtevService.kreirajZahtevZaOdsustvo(zahtev).subscribe(zahtev => console.log(zahtev));

  }

}
