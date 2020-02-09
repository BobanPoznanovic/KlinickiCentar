import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { AdminKlinike } from 'src/app/model/adminKlinike';
import { KlinikaService } from 'src/app/services/klinika.service';

@Component({
  selector: 'app-dodaj-admina-klinike',
  templateUrl: './dodaj-admina-klinike.component.html',
  styleUrls: ['./dodaj-admina-klinike.component.css']
})
export class DodajAdminaKlinikeComponent implements OnInit {

  adminForm = new FormGroup({
    ime : new FormControl(''),
    prezime : new FormControl(''),
    username : new FormControl(''),
    password : new FormControl(''),
    email : new FormControl(''),
    kontakt_telefon : new FormControl(''),
    adresa : new FormControl('')
  });

  constructor(private klinikaService: KlinikaService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    let admin = new AdminKlinike();
    admin.adresa = this.adminForm.controls.adresa.value;
    admin.email = this.adminForm.controls.email.value;
    admin.ime = this.adminForm.controls.ime.value;
    admin.izmenjana_sifra_nakon_prvog_logovanja = false;
    admin.kontakt_telefon = this.adminForm.controls.kontakt_telefon.value;
    admin.password = this.adminForm.controls.password.value;
    admin.prezime = this.adminForm.controls.prezime.value;
    admin.username = this.adminForm.controls.username.value;

    this.klinikaService.dodajAdminaKlinike(admin).subscribe(admin=>console.log(admin));
  }

}
