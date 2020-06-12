import { Component, OnInit, Input } from '@angular/core';
import { MedicinskaSestra} from '../../model/medicinskaSestra';
import { ReceptService } from 'src/app/services/recept.service';
import { Recept } from 'src/app/model/recept';
import { NavigationEnd, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Lek } from 'src/app/model/lek';
import { LekService } from 'src/app/services/lek.service';

@Component({
  selector: 'app-recepti',
  templateUrl: './recepti.component.html',
  styleUrls: ['./recepti.component.css']
})
export class ReceptiComponent implements OnInit {

  constructor(
    private receptService: ReceptService,
    private lekService: LekService
  ) { }

  @Input() medsestra: MedicinskaSestra;
  neovereniReceptiSaKlinike: Recept[];

  ngOnInit(): void {
    this.receptService.getNeovereniSaKlinike(this.medsestra.klinikaID).subscribe(recepti=>this.neovereniReceptiSaKlinike = recepti);
  }

  overi(recept: Recept) {
    this.receptService.overiRecept(recept.receptID, this.medsestra).subscribe(recepti => this.neovereniReceptiSaKlinike = recepti);
  }

  getLek(lekID: number): Observable<Lek> {

    return this.lekService.getLek(lekID);
  }

}
