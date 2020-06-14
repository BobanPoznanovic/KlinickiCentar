import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Pacijent} from "../../../model/pacijent";
import {IzmeniProfilService} from "../../../services/izmeni-profil.service";
import {PacijentService} from "../../../services/pacijent.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-izmeni-profil',
  templateUrl: './izmeni-profil.component.html',
  styleUrls: ['./izmeni-profil.component.css']
})
export class IzmeniProfilComponent implements OnInit {

  userData: FormGroup;
  pacijent: Pacijent;

  constructor(private izmeniProfilService: IzmeniProfilService,
              private route: ActivatedRoute, private router: Router,
              private formBuilder: FormBuilder,
              private pacijentService: PacijentService) {

    this.pacijent = new Pacijent();
  }

  ngOnInit(): void {
    this.pacijentService.getByID(Number(localStorage.getItem('pacijentID')))
      .subscribe(data =>
        this.pacijent = data
      );

    this.userData = this.formBuilder.group({
      firstName: ['', [Validators.required, Validators.pattern(/^[a-zA-Z\s]*$/)]],
      lastName: ['', [Validators.required, Validators.pattern(/^[a-zA-Z\s]*$/)]],
      country: ['', [Validators.required, Validators.pattern(/^[a-zA-Z\s]*$/)]],
      city: ['', [Validators.required, Validators.pattern(/^[a-zA-Z\s]*$/)]],
      address: ['', [Validators.required, Validators.pattern(/^[a-zA-Z0-9\s]*$/)]],
      phone: ['', [Validators.required, Validators.pattern(/^[0-9]*$/), Validators.minLength(9), Validators.maxLength(10)]]
    });
  }

  get f() {
    return this.userData.controls;
  }

  onSubmit(){
    this.izmeniProfilService.update(this.pacijent)
      .subscribe(result => this.gotoUser());
  }

  gotoUser() {
    this.router.navigate(['/profil']);
  }

}
