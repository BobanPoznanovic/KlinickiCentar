import { Component, OnInit } from '@angular/core';
import {Pacijent} from "../../../model/pacijent";
import {PacijentHomepageService} from "../../../services/pacijent-homepage.service";
import {PacijentService} from "../../../services/pacijent.service";

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  pacijent: Pacijent;

  constructor(private pacijentHomepageService: PacijentHomepageService,
              private pacijentService: PacijentService) {
    this.pacijent = new Pacijent();
  }

  ngOnInit(): void {
    this.pacijentService.getByID(Number(localStorage.getItem('pacijentID')))
      .subscribe(data =>
        this.pacijent = data
      );
  }

}
