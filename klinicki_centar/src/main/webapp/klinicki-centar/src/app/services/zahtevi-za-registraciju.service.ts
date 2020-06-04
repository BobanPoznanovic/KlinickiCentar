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

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  getZahtevi(): Observable<ZahtevZaRegistraciju[]> {
    return this.http.get<ZahtevZaRegistraciju[]>(this.backEndURL+'/all');
  }

  prihvatiZahtev(id: number): Observable<ZahtevZaRegistraciju> {
    const url = '/prihvati/';
    return this.http.get<ZahtevZaRegistraciju>(this.backEndURL+url+id);
  }

  odbitiZahtev(zahtev: ZahtevZaRegistraciju): Observable<ZahtevZaRegistraciju> {
    const url = '/odbiti'
    return this.http.post<ZahtevZaRegistraciju>(this.backEndURL+url, zahtev, this.httpOptions);
  }

  odbijanjeZahteva(id: number, message: string) {
    const url = '/odbijanje/'
    return this.http.delete(this.backEndURL + url + id + '/' + message, this.httpOptions);
  }
}
