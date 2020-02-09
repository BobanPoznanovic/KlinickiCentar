import { Injectable } from '@angular/core';
import { ZahtevZaOdsustvo } from '../model/zahtevZaOdsustvo';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ZahtevZaOdsustvoService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  private url = 'http://localhost:8080/zahtev/odsustvo'

  constructor(private http: HttpClient) { }

  kreirajZahtevZaOdsustvo(zahtev: ZahtevZaOdsustvo): Observable<ZahtevZaOdsustvo> {
    return this.http.post<ZahtevZaOdsustvo>(this.url, zahtev, this.httpOptions);
  }
}
