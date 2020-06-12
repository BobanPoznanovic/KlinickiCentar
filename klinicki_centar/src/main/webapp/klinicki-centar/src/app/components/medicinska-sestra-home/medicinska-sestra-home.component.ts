import { Component, OnInit } from '@angular/core';
import { MedicinskaSestraService } from 'src/app/services/medicinska-sestra.service';
import { MedicinskaSestra} from '../../model/medicinskaSestra';

@Component({
  selector: 'app-medicinska-sestra-home',
  templateUrl: './medicinska-sestra-home.component.html',
  styleUrls: ['./medicinska-sestra-home.component.css']
})
export class MedicinskaSestraHomeComponent implements OnInit {

  sestra : MedicinskaSestra;
  overa : Boolean;

  constructor(
    private medicinskaSestraService : MedicinskaSestraService
  ) { }

  ngOnInit(): void {
    this.medicinskaSestraService.getMedicinskaSestra(1).subscribe(sestra => this.sestra = sestra);
    this.overa = false;
  }

  overaRecepata() {
    if(this.sestra) {
      this.overa = true;
    }
    
  }

}
