import { Injectable } from '@angular/core';
import {MedicinskaSestra} from '../model/medicinskaSestra';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class MedicinskaSestraService {

  private backendURL = "http://localhost:8080/sestra";

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  getMedicinskaSestra(id: number): Observable<MedicinskaSestra> {
    return this.http.get<MedicinskaSestra>(this.backendURL+'/'+id);
  }
}
