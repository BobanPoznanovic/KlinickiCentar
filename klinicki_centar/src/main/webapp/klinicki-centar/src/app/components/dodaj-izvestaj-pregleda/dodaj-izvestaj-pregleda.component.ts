import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Dijagnoza } from 'src/app/model/dijagnoza';
import { DijagnozaService } from 'src/app/services/dijagnoza.service';
import { IzvestajPregleda } from 'src/app/model/izvestajPregleda';
import { PregledService } from 'src/app/services/pregled.service';

@Component({
  selector: 'app-dodaj-izvestaj-pregleda',
  templateUrl: './dodaj-izvestaj-pregleda.component.html',
  styleUrls: ['./dodaj-izvestaj-pregleda.component.css']
})
export class DodajIzvestajPregledaComponent implements OnInit {

  @Input() pregledID: number;

  dijagnoze: Dijagnoza[];

  izvestajForm = new FormGroup({
    dijagnozaID : new FormControl(''),
    opis_pregleda : new FormControl('')
  });

  constructor(
    private dijagnozaService: DijagnozaService,
    private pregledService: PregledService) { }

  ngOnInit(): void {
    this.dijagnozaService.getAll().subscribe(dijagnoze => this.dijagnoze = dijagnoze)
  }

  onSubmit() {
    console.log(this.pregledID);
    console.log(this.izvestajForm.controls.dijagnozaID.value);
    console.log(this.izvestajForm.controls.opis_pregleda.value);
    let izvestaj = new IzvestajPregleda();
    izvestaj.dijagnozaID = this.izvestajForm.controls.dijagnozaID.value;
    izvestaj.opis_pregleda = this.izvestajForm.controls.opis_pregleda.value;
    izvestaj.pregledID = this.pregledID;

    this.pregledService.dodajIzvestajPregleda(izvestaj).subscribe(izvestaj => console.log(izvestaj));
  }

}
