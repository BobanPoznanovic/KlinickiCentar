import { Component, OnInit } from '@angular/core';
import {Klinika} from "../../model/klinika";
import {KlinikaService} from "../../services/klinika.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-klinike',
  templateUrl: './klinike.component.html',
  styleUrls: ['./klinike.component.css']
})
export class KlinikeComponent implements OnInit {

  klinike: Observable<Klinika[]>;

  constructor(private klinikaService: KlinikaService) { }

  ngOnInit(): void {
    this.getAllKlinike();
  }

  getAllKlinike() {
    this.klinike = this.klinikaService.getAll();
  }

}
