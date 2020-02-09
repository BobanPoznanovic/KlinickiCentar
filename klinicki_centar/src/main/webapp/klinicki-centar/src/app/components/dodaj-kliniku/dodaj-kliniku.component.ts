import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Klinika } from 'src/app/model/klinika';
import { KlinikaService } from 'src/app/services/klinika.service';

@Component({
  selector: 'app-dodaj-kliniku',
  templateUrl: './dodaj-kliniku.component.html',
  styleUrls: ['./dodaj-kliniku.component.css']
})
export class DodajKlinikuComponent implements OnInit {

  klinikaForm = new FormGroup(
    {
      naziv: new FormControl(''),
      adresa: new FormControl(''),
      opis: new FormControl('')
    }
  );

  constructor(private klinikaService: KlinikaService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    let klinika = new Klinika();
    klinika.naziv = this.klinikaForm.controls.naziv.value;
    klinika.adresa = this.klinikaForm.controls.adresa.value;
    klinika.opis = this.klinikaForm.controls.adresa.value;

    this.klinikaService.dodajKliniku(klinika).subscribe(klinika => console.log(klinika));
  }

}
