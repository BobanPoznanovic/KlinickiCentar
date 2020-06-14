import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {PotvrditiPregledService} from '../../../services/potvrditi-pregled.service';

@Component({
  selector: 'app-potvrditi-pregled',
  templateUrl: './potvrditi-pregled.component.html',
  styleUrls: ['./potvrditi-pregled.component.css']
})
export class PotvrditiPregledComponent implements OnInit {

  currentUrl: string;

  constructor(private router: Router,
              private potvrditiPregledService: PotvrditiPregledService) { }

  ngOnInit(): void {
    this.currentUrl = this.router.url;
    this.potvrditiPregledService.potvrdiPregled('http://localhost:8080/pregled' + this.currentUrl);
  }

}
