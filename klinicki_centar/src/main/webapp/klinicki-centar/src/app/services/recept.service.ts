import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Recept } from '../model/recept';
import { MedicinskaSestra } from '../model/medicinskaSestra';

@Injectable({
  providedIn: 'root'
})
export class ReceptService {

  private backendURL = "http://localhost:8080/recept";

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  getNeovereniSaKlinike(klinikaID: number): Observable<Recept[]> {
    return this.http.get<Recept[]>(this.backendURL+'/all/neovereni/klinika/'+klinikaID);
  }

  overiRecept(receptID: number, sestra: MedicinskaSestra): Observable<Recept[]> { 
    let sestraID = sestra.medicinska_sestraID;
    this.http.get<Recept>(this.backendURL+'/overi/'+receptID+'/'+sestraID).subscribe();
    return this.getNeovereniSaKlinike(sestra.klinikaID);
  }
}
