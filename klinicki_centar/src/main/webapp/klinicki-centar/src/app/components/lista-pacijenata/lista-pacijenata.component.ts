import { Component, OnInit } from '@angular/core';
import { PacijentService } from 'src/app/services/pacijent.service';
import { Pacijent } from 'src/app/model/pacijent';

@Component({
  selector: 'app-lista-pacijenata',
  templateUrl: './lista-pacijenata.component.html',
  styleUrls: ['./lista-pacijenata.component.css']
})
export class ListaPacijenataComponent implements OnInit {

  pacijenti: Pacijent[];

  constructor(private pacijentService: PacijentService) { }

  ngOnInit(): void {
    this.pacijentService.getAll().subscribe(pacijenti => this.pacijenti = pacijenti);
  }

}
