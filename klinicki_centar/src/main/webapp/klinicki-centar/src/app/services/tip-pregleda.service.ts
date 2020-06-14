import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {TipPregleda} from "../model/tipPregleda";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TipPregledaService {

  private backEndURL = 'http://localhost:8080/tipPregleda/';

  constructor(private http: HttpClient) { }

  getByID(id: number) {
    return this.http.get<TipPregleda>(this.backEndURL + '/' + id);
  }

  getAll(): Observable<TipPregleda[]> {
    return this.http.get<TipPregleda[]>(this.backEndURL + '/all');
  }
}
