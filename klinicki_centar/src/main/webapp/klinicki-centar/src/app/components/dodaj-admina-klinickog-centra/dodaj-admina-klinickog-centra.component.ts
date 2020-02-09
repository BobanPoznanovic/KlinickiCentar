import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { AdminKlinickogCentraService } from 'src/app/services/admin-klinickog-centra.service';
import { AdminKlinickogCentra } from 'src/app/model/adminKlinickogCentra';

@Component({
  selector: 'app-dodaj-admina-klinickog-centra',
  templateUrl: './dodaj-admina-klinickog-centra.component.html',
  styleUrls: ['./dodaj-admina-klinickog-centra.component.css']
})
export class DodajAdminaKlinickogCentraComponent implements OnInit {

  adminForm = new FormGroup({
    ime: new FormControl(''),
    prezime: new FormControl(''),
    username: new FormControl(''),
    password: new FormControl(''),
    email: new FormControl(''),
    kontakt_telefon: new FormControl(''),
    adresa: new FormControl('')
  });

  constructor(private adminService: AdminKlinickogCentraService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    let admin = new AdminKlinickogCentra();
    admin.ime = this.adminForm.controls.ime.value;
    admin.prezime = this.adminForm.controls.prezime.value;
    admin.username = this.adminForm.controls.username.value;
    admin.password = this.adminForm.controls.password.value;
    admin.email = this.adminForm.controls.email.value;
    admin.kontakt_telefon = this.adminForm.controls.kontakt_telefon.value;
    admin.adresa = this.adminForm.controls.adresa.value;
    admin.izmenjana_sifra_nakon_prvog_logovanja = false;

    this.adminService.dodajAdmina(admin).subscribe(admin => console.log(admin));
  }

}
