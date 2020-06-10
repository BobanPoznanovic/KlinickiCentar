import { Component, OnInit } from '@angular/core';
import {FormGroup} from '@angular/forms';
import {Pacijent} from '../../model/pacijent';

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

  pacijent: Pacijent;



  constructor() { }

  ngOnInit(): void {
  }

  onSubmit() {

  }
}
