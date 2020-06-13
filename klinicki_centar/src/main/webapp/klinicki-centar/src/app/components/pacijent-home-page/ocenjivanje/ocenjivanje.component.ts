import { Component, OnInit } from '@angular/core';
import {Pacijent} from '../../../model/pacijent';
import {Pregled} from '../../../model/pregled';
import {Operacija} from '../../../model/operacija';
import {Router} from '@angular/router';
import {PacijentService} from '../../../services/pacijent.service';
import {PacijentHomepageService} from '../../../services/pacijent-homepage.service';
import {KlinikaService} from '../../../services/klinika.service';
import {Klinika} from '../../../model/klinika';
import {Lekar} from '../../../model/lekar';
import {LekarService} from '../../../services/lekar.service';

@Component({
  selector: 'app-ocenjivanje',
  templateUrl: './ocenjivanje.component.html',
  styleUrls: ['./ocenjivanje.component.css']
})
export class OcenjivanjeComponent implements OnInit {

  ulogovanPacijent: Pacijent;
  klinika: Klinika;
  lekar: Lekar;
  pregledi: Pregled[];
  operacije: Operacija[];
  klinika_ocenjena_P = false;
  klinika_ocenjena_O = false;
  lekar_ocenjen_P = false;
  lekar_ocenjen_O = false;

  constructor(private router: Router, private pacijentService: PacijentService,
              private pacijentHomepageService: PacijentHomepageService,
              private klinikaService: KlinikaService,
              private lekarService: LekarService) {
    this.ulogovanPacijent = new Pacijent();
    this.klinika = new Klinika();
    this.lekar = new Lekar();
  }

  ngOnInit(): void {
    // @ts-ignore
    this.pacijentService.getByID(Number(localStorage.getItem('pacijentID')))
      .subscribe(data => {
        this.ulogovanPacijent = data;
        this.pacijentHomepageService.nadjiSvePregledeZaOcenjivanje(this.ulogovanPacijent.pacijentID)
          .subscribe(data2 => {
            this.pregledi = data2;
          });

        this.pacijentHomepageService.nadjiSveOperacijeZaOcenjivanje(this.ulogovanPacijent.pacijentID)
          .subscribe(data3 => {
            this.operacije = data3;
          });
      });

  }

  onChangeSelect(ocena: number, pregled: Pregled) {
    pregled.klinikaRating = ocena;
    // console.log(pregled.pregledID);
    console.log(pregled.klinikaRating);
  }

  rateClinic(pregled: Pregled) {
    if (pregled.klinikaRating === undefined) {
      pregled.klinikaRating = 5;
    }

    console.log('Lekar ID iz pregleda  -  ' + pregled.lekarID);
    // @ts-ignore
    this.lekar = this.lekarService.getByID(pregled.lekarID);

    console.log('Lekar ID nakon pronalazenja  -  ' + pregled.lekarID);

    this.pacijentHomepageService.oceniKlinikuPregled(pregled.pregledID, pregled.klinikaRating, this.lekar.klinikaID);
    this.klinika_ocenjena_P = true;
  }

  onChangeSelect2(ocena: number, pregled: Pregled) {
    pregled.lekarRating = ocena;
    // console.log(pregled.pregledID);
    console.log(pregled.lekarRating);
  }

  rateDoctor(pregled: Pregled) {
    if (pregled.lekarRating === undefined) {
      pregled.lekarRating = 5;
    }
    this.pacijentHomepageService.oceniLekaraPregled(pregled.pregledID, pregled.lekarRating, pregled.lekarID);
    this.lekar_ocenjen_P = true;
  }

  onChangeSelect12(id: any, operacija: Operacija) {
    operacija.klinikaRating = id;
    console.log(operacija.klinikaRating);
  }

  onChangeSelect22(id: any, operacija: Operacija) {
    operacija.lekarRating = id;
    console.log(operacija.lekarRating);
  }

  rateClinicO(operacija: Operacija) {

    // @ts-ignore
    this.lekarService.getByID(operacija.lekarID)
      .subscribe(data => {
        this.lekar = data;
        console.log('Lekar ID nakon pronalazenja  -  ' + this.lekar.klinikaID);
        this.pacijentHomepageService.oceniKlinikuOperacija(operacija.operacijaID, operacija.klinikaRating, this.lekar.klinikaID);
      });
    this.klinika_ocenjena_O = true;

  }

  rateDoctorO(operacija: Operacija) {
    this.pacijentHomepageService.oceniLekaraOperacija(operacija.operacijaID, operacija.lekarRating, operacija.lekarID);
    this.lekar_ocenjen_O = true;
  }

}
