import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {OdbitiPregledService} from "../../../services/odbiti-pregled.service";

@Component({
  selector: 'app-odbiti-pregled',
  templateUrl: './odbiti-pregled.component.html',
  styleUrls: ['./odbiti-pregled.component.css']
})
export class OdbitiPregledComponent implements OnInit {

  currentUrl: string;

  constructor(private router: Router,
              private odbitiPregledService: OdbitiPregledService) { }

  ngOnInit(): void {
    this.currentUrl = this.router.url;
    this.odbitiPregledService.odbitiPregled('http://localhost:8080/pregled' + this.currentUrl);
  }

}
