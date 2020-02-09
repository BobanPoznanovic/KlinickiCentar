import { Injectable } from '@angular/core';
import { ZahtevZaRegistraciju } from '../model/zahtevZaRegistraciju';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ZahteviZaRegistracijuService {

  private backEndURL = 'http://localhost:8080/zahtev/registracija'

  constructor(private http: HttpClient) { }

  getZahtevi(): Observable<ZahtevZaRegistraciju[]> {
    return this.http.get<ZahtevZaRegistraciju[]>(this.backEndURL+'/all');  
  }

  prihvatiZahtev(id: number): Observable<ZahtevZaRegistraciju> {
    const url = '/prihvati/';
    return this.http.get<ZahtevZaRegistraciju>(this.backEndURL+url+id);
  }
}
