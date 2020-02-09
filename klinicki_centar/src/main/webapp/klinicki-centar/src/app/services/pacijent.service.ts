import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pacijent } from '../model/pacijent';

@Injectable({
  providedIn: 'root'
})
export class PacijentService {

  private url = 'http://localhost:8080/pacijent';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Pacijent[]> {
    return this.http.get<Pacijent[]>(this.url+'/all');
  }
}
