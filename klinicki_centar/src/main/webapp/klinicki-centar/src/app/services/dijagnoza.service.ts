import { Injectable } from '@angular/core';
import { Dijagnoza } from '../model/dijagnoza';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DijagnozaService {
  
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  private url = 'http://localhost:8080/dijagnoza'

  constructor(private http: HttpClient) { }

  dodajDijagnozu(dijagnoza: Dijagnoza): Observable<Dijagnoza> {
    return this.http.post<Dijagnoza>(this.url, dijagnoza, this.httpOptions);
  }

  getAll(): Observable<Dijagnoza[]> {
    return this.http.get<Dijagnoza[]>(this.url+'/all');
  }
}
