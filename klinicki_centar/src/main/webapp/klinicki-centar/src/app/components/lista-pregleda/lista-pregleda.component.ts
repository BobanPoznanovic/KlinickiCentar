import { Component, OnInit } from '@angular/core';
import { PregledService } from 'src/app/services/pregled.service';
import { Pregled } from 'src/app/model/pregled';

@Component({
  selector: 'app-lista-pregleda',
  templateUrl: './lista-pregleda.component.html',
  styleUrls: ['./lista-pregleda.component.css']
})
export class ListaPregledaComponent implements OnInit {

  pregledi: Pregled[];
  selectedPregled: Pregled;
  selectedID: number;

  constructor(private pregledService: PregledService) { }

  ngOnInit(): void {
    this.pregledService.getAll().subscribe(pregledi => this.pregledi = pregledi);
  }

  onClick(pregled: Pregled) {
    console.log(pregled);
    this.selectedID = pregled.pregledID;
  }

}
