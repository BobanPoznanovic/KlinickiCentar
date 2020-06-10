import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Pacijent} from '../../model/pacijent';
import {RegistracijaService} from '../../services/registracija.service';
import {ActivatedRoute, Router} from '@angular/router';
import {PacijentService} from '../../services/pacijent.service';
import {ZahteviZaRegistracijuService} from '../../services/zahtevi-za-registraciju.service';
import {ZahtevZaRegistraciju} from '../../model/zahtevZaRegistraciju';

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.css']
})
export class RegistracijaComponent implements OnInit {

  userData: FormGroup;
  submitted = false;
  success = false;
  passwordRepeat: string;

  zahtev: ZahtevZaRegistraciju;



  constructor(private registracijaService: RegistracijaService,
              private route: ActivatedRoute, private router: Router,
              private  pacijentService: PacijentService,
              private formBuilder: FormBuilder,
              private zahtevZaRegistraciju: ZahteviZaRegistracijuService) {

    this.zahtev = new ZahtevZaRegistraciju();
  }

  ngOnInit(): void {
    this.userData = this.formBuilder.group({
      brojOsiguranika: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(9), Validators.pattern(/^[0-9]*$/)]],
      email: ['', [Validators.required, Validators.pattern(/[^ @]*@[^ @]*/)]],
      password: ['', [Validators.required, Validators.minLength(5)]],
      passwordRepeat: ['', [Validators.required, Validators.minLength(5)]],
      firstName: ['', [Validators.required, Validators.pattern(/^[a-zA-Z\s]*$/)]],
      lastName: ['', [Validators.required, Validators.pattern(/^[a-zA-Z\s]*$/)]],
      country: ['', [Validators.required, Validators.pattern(/^[a-zA-Z\s]*$/)]],
      city: ['', [Validators.required, Validators.pattern(/^[a-zA-Z\s]*$/)]],
      address: ['', [Validators.required, Validators.pattern(/^[a-zA-Z\s]*$/)]],
      phone: ['', [Validators.required, Validators.pattern(/^[0-9]*$/), Validators.minLength(9), Validators.maxLength(10)]]
    },
      {validator: this.checkPasswords});
  }

  checkPasswords(group: FormGroup) {
    if (!group.controls.password.touched) {
      return null;
    }
    const pass = group.controls.password.value;
    const confirmPass = group.controls.passwordRepeat.value;
    return pass === confirmPass ? null : {notSame: true};
  }

  onSubmit() {
    this.submitted = true;

    if (this.userData.invalid) {
      return;
    }

    this.success = true;

    this.zahtev.broj_osiguranika = this.userData.controls.brojOsiguranika.value;
    this.zahtev.email = this.userData.controls.email.value;
    this.zahtev.password = this.userData.controls.password.value;
    this.zahtev.ime = this.userData.controls.firstName.value;
    this.zahtev.prezime = this.userData.controls.lastName.value;
    this.zahtev.drzava = this.userData.controls.country.value;
    this.zahtev.grad = this.userData.controls.city.value;
    this.zahtev.adresa = this.userData.controls.address.value;
    this.zahtev.broj_telefona = this.userData.controls.phone.value;

    this.registracijaService.register(this.zahtev).subscribe(zahtev => console.log(zahtev));;
  }
}
