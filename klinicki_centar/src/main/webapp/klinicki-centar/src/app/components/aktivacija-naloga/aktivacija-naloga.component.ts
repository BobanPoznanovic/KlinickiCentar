import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AktivacijaNalogaService} from "../../services/aktivacija-naloga.service";

@Component({
  selector: 'app-aktivacija-naloga',
  templateUrl: './aktivacija-naloga.component.html',
  styleUrls: ['./aktivacija-naloga.component.css']
})
export class AktivacijaNalogaComponent implements OnInit {

  currentUrl: string;

  constructor(private router: Router,
              private aktivacijaNalogaService: AktivacijaNalogaService) { }

  ngOnInit(): void {
    this.currentUrl = this.router.url;
    console.log(this.currentUrl)
    this.aktivacijaNalogaService.aktivacijaNaloga('http://localhost:8080/pacijent' + this.currentUrl);
  }

}
