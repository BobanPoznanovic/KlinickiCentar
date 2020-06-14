import { Component, OnInit } from '@angular/core';
import {Pacijent} from "../../../model/pacijent";
import {Pregled} from "../../../model/pregled";
import {ActivatedRoute} from "@angular/router";
import {PredefinisaniPregledService} from "../../../services/predefinisani-pregled.service";
import {PacijentService} from "../../../services/pacijent.service";
import {Lekar} from "../../../model/lekar";
import {TipPregleda} from "../../../model/tipPregleda";
import {LekarService} from "../../../services/lekar.service";
import {TipPregledaService} from "../../../services/tip-pregleda.service";

@Component({
  selector: 'app-predefinisani-pregledi',
  templateUrl: './predefinisani-pregledi.component.html',
  styleUrls: ['./predefinisani-pregledi.component.css']
})
export class PredefinisaniPreglediComponent implements OnInit {

  klinikaID: number;
  ulogovanPacijent: Pacijent;
  pregled: Pregled;
  predefinisaniPregledi: Pregled[] = [];
  lekar: Lekar;
  tipPregleda: TipPregleda;

  constructor(private activatedRoute: ActivatedRoute,
              private predefinisaniPregledService: PredefinisaniPregledService,
              private pacijentService: PacijentService,
              private lekarService: LekarService,
              private tipPregledaService: TipPregledaService) {

    this.klinikaID = Number(this.activatedRoute.snapshot.paramMap.get('id'));
    this.lekar = new Lekar();
    this.tipPregleda = new TipPregleda();

    // this.activatedRoute.queryParams.subscribe(params => {
    //   this.klinikaID = params.id;
    // });
  }

  ngOnInit(): void {
    // @ts-ignore
    this.ulogovanPacijent = this.pacijentService.getByID(Number(localStorage.getItem('pacijentID')))
      .subscribe(data => {
        this.ulogovanPacijent = data;

      });

    this.predefinisaniPregledService.nadjiPredefinisanePregledeSaKlinike(this.klinikaID)
      .subscribe(data2 =>
        this.predefinisaniPregledi = data2
      );
  }

  getPregled(id: number){
    this.pregled = this.predefinisaniPregledi.find(d => d.tip_pregledaID === id);
  }

  zakaziPredefinisaniPregled(id: number) {
    this.predefinisaniPregledService.zakaziPredefinisaniPregled(id, Number(localStorage.getItem('pacijentID')))
      .subscribe(result => this.ngOnInit());
  }

}
