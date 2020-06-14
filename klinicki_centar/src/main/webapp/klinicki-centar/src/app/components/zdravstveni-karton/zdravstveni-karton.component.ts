import { Component, OnInit } from '@angular/core';
import {ZdravstveniKarton} from "../../model/zdravstveniKarton";
import {Pacijent} from "../../model/pacijent";
import {Pregled} from "../../model/pregled";
import {ActivatedRoute} from "@angular/router";
import {ZdravstveniKartonService} from "../../services/zdravstveni-karton.service";
import {PacijentService} from "../../services/pacijent.service";

@Component({
  selector: 'app-zdravstveni-karton',
  templateUrl: './zdravstveni-karton.component.html',
  styleUrls: ['./zdravstveni-karton.component.css']
})
export class ZdravstveniKartonComponent implements OnInit {

  zdravstveniKarton: ZdravstveniKarton;
  pacijent: Pacijent;
  pregled: Pregled;

  constructor(private activatedRoute: ActivatedRoute,
              private pacijentService: PacijentService,
              private zdravstveniKartonService: ZdravstveniKartonService) {

    this.pacijent = new Pacijent();
    this.zdravstveniKarton = new ZdravstveniKarton();
  }

  ngOnInit(): void {

    this.pacijentService.getByID(Number(localStorage.getItem('pacijentID')))
      .subscribe(data => {
        this.pacijent = data;
        this.zdravstveniKartonService.getPacijentovKarton(this.pacijent.pacijentID)
          .subscribe(data2 =>
            this.zdravstveniKarton = data2
          );
      });
  }

}
