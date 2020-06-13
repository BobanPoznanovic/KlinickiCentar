import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pacijent } from '../model/pacijent';
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class PacijentService {

  private url = 'http://localhost:8080/pacijent';
  ulogovanPacijent: Pacijent;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  getAll(): Observable<Pacijent[]> {
    return this.http.get<Pacijent[]>(this.url+'/all');
  }

  getByID(id: number): Observable<Pacijent> {
    return this.http.get<Pacijent>(this.url + '/' + id);
  // .pipe( map (pacijent => {
  //     this.ulogovanPacijent = pacijent;
  //     return pacijent;
  //   }))
  }

  getByEmail(email: string): Observable<Pacijent> {
    return this.http.get<Pacijent>(this.url + '/email/' + email)
      // .pipe( map (pacijent => {
      //       this.ulogovanPacijent = pacijent;
      //       console.log('UlogovanPacijent ID  -  ' + this.ulogovanPacijent.pacijentID);
      //       return pacijent;
      //     }))
      ;
  }

  login(pacijent: Pacijent) {
    return this.http.post(this.url + '/login', pacijent);

  }
}
