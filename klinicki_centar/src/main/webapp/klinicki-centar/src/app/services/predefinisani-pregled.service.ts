import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {any} from 'codelyzer/util/function';
import {Pregled} from "../model/pregled";

@Injectable({
  providedIn: 'root'
})
export class PredefinisaniPregledService {

  constructor(private http: HttpClient) { }

  nadjiPredefinisanePregledeSaKlinike(id: number){
    return this.http.get<Pregled[]>('http://localhost:8080/pregled/predefinisanNaKlinici/' + id);
  }

  zakaziPredefinisaniPregled(id: number, pacijentID: number) {
    return this.http.put('http://localhost:8080/pregled/zakazivanjePredefinisanogPregleda/' + id + '/' + pacijentID, any);
  }

}
