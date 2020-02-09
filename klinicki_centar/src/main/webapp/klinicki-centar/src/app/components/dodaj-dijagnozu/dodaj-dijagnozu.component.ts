import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { DijagnozaService } from 'src/app/services/dijagnoza.service';
import { Dijagnoza } from 'src/app/model/dijagnoza';

@Component({
  selector: 'app-dodaj-dijagnozu',
  templateUrl: './dodaj-dijagnozu.component.html',
  styleUrls: ['./dodaj-dijagnozu.component.css']
})
export class DodajDijagnozuComponent implements OnInit {

  dijagnozaForm = new FormGroup({
    naziv : new FormControl('')
  });

  constructor(private dijagnozaService: DijagnozaService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    let dijagnoza = new Dijagnoza();
    dijagnoza.naziv = this.dijagnozaForm.controls.naziv.value;

    this.dijagnozaService.dodajDijagnozu(dijagnoza).subscribe(dijagnoza => console.log(dijagnoza));
  }

}
