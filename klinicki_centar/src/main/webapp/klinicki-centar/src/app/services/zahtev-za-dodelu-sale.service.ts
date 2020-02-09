import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ZahtevZaDodeluSale } from '../model/zahtevZaDodeluSale';

@Injectable({
  providedIn: 'root'
})
export class ZahtevZaDodeluSaleService {

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  private url = 'http://localhost:8080/zahtev/sala'

  getAll(): Observable<ZahtevZaDodeluSale[]> {
    return this.http.get<ZahtevZaDodeluSale[]>(this.url+'/all');
  }

  check(zahtev: ZahtevZaDodeluSale): Observable<ZahtevZaDodeluSale> {
    return this.http.post<ZahtevZaDodeluSale>(this.url+'/check', zahtev, this.httpOptions);
  }
}
