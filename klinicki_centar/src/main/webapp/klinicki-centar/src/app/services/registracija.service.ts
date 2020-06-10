import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ZahtevZaRegistraciju} from '../model/zahtevZaRegistraciju';

@Injectable({
  providedIn: 'root'
})
export class RegistracijaService {

  private registerUrl = 'http://localhost:8080/zahtev/registracija';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private httpClient: HttpClient) {  }

  public register(zahtev : ZahtevZaRegistraciju): Observable<ZahtevZaRegistraciju> {
    return this.httpClient.post<ZahtevZaRegistraciju>(this.registerUrl, zahtev, this.httpOptions);
  }

  public save(zahtev: ZahtevZaRegistraciju) {
    return this.httpClient.post<ZahtevZaRegistraciju>(this.registerUrl, zahtev, this.httpOptions);
  }
}
