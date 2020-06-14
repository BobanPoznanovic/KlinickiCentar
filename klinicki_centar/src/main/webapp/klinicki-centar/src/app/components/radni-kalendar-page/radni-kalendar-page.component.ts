import { Component, OnInit } from '@angular/core';
import { LekarService } from 'src/app/services/lekar.service';
import { Lekar } from 'src/app/model/lekar';

@Component({
  selector: 'app-radni-kalendar-page',
  templateUrl: './radni-kalendar-page.component.html',
  styleUrls: ['./radni-kalendar-page.component.css']
})
export class RadniKalendarPageComponent implements OnInit {

  dnevni : boolean;
  nedeljni : boolean;
  mesecni : boolean;
  godisnji : boolean;

  lekar : Lekar;

  constructor(
    private lekarService : LekarService
  ) { }

  ngOnInit(): void {
    this.dnevni = false;
    this.nedeljni = false;
    this.mesecni = false;
    this.godisnji = false;

    this.lekar = new Lekar();

    this.lekar.lekarID = 1;
  }

  vrstaKalendara(tip : number) {
    switch(tip) {
      case 0:
        this.dnevni = true;
        this.nedeljni = false;
        this.mesecni = false;
        this.godisnji = false;
        break;
      case 1:
        this.dnevni = false;
        this.nedeljni = true;
        this.mesecni = false;
        this.godisnji = false;
        break;
      case 2:
        this.dnevni = false;
        this.nedeljni = false;
        this.mesecni = true;
        this.godisnji = false;
        break;
      case 3:
        this.dnevni = false;
        this.nedeljni = false;
        this.mesecni = false;
        this.godisnji = true;
        break;  
    }
  }

}
