import { Component, OnInit } from '@angular/core';
import {Pacijent} from '../../model/pacijent';
import {PacijentService} from '../../services/pacijent.service';
import {ActivatedRoute} from '@angular/router';
import {PacijentHomepageService} from '../../services/pacijent-homepage.service';
import {AuthService} from "../../services/auth.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-pacijent-home-page',
  templateUrl: './pacijent-home-page.component.html',
  styleUrls: ['./pacijent-home-page.component.css']
})
export class PacijentHomePageComponent implements OnInit {

  public pacijent: Pacijent;
  auth: AuthService;
  ulogovanPacijent: Pacijent;

  constructor(private pacijentService: PacijentService,
              private activatedRoute: ActivatedRoute,
              private pacijentHomepageService: PacijentHomepageService,
              private authService: AuthService) {
    this.pacijent = new Pacijent();
    this.ulogovanPacijent = new Pacijent();
    this.pacijent.email = authService.getToken();
    console.log('Pacijent home page:  email  -  ' + this.pacijent.email);
  }

  ngOnInit(): void {

  }

}
