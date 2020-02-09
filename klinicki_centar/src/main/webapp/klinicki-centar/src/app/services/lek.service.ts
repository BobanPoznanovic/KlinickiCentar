import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Lek } from '../model/lek';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LekService {

  private url = 'http://localhost:8080/lek'

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  dodajLek(lek: Lek): Observable<Lek> {
    return this.http.post<Lek>(this.url,lek,this.httpOptions);
  }
}
