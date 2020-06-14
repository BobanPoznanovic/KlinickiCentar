import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pregled } from '../model/pregled';
import { IzvestajPregleda } from '../model/izvestajPregleda';

@Injectable({
  providedIn: 'root'
})
export class PregledService {

  private url = "http://localhost:8080/pregled"
  private izvestajURL = "http://localhost:8080/pregled/izvestaj";

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  getAll(): Observable<Pregled[]> {
    return this.http.get<Pregled[]>(this.url+'/all');
  }

  dodajIzvestajPregleda(izvestaj: IzvestajPregleda): Observable<IzvestajPregleda> {
    return this.http.post<IzvestajPregleda>(this.izvestajURL, izvestaj, this.httpOptions);
  }

  getById(pregledID: number): Observable<Pregled> {
    return this.http.get<Pregled>(this.url+'/'+pregledID)
  }

  getIzvestajByPregledID(pregledID : number) : Observable<IzvestajPregleda> {
    return this.http.get<IzvestajPregleda>(this.izvestajURL+'/pregledID/'+pregledID)
  }
}
