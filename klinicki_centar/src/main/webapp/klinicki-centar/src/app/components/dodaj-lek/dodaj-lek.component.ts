import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { LekService } from 'src/app/services/lek.service';
import { Lek } from 'src/app/model/lek';

@Component({
  selector: 'app-dodaj-lek',
  templateUrl: './dodaj-lek.component.html',
  styleUrls: ['./dodaj-lek.component.css']
})
export class DodajLekComponent implements OnInit {

  lekForm = new FormGroup({
    naziv: new FormControl(''),
    proizvodjac: new FormControl(''),
    doza: new FormControl('')
  });

  constructor(private lekService: LekService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    let lek = new Lek();
    lek.naziv = this.lekForm.controls.naziv.value;
    lek.proizvodjac = this.lekForm.controls.proizvodjac.value;
    lek.doza = this.lekForm.controls.doza.value;

    this.lekService.dodajLek(lek).subscribe(lek => console.log(lek));
  }
}
