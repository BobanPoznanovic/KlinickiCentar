import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AdminKlinickogCentra } from '../model/adminKlinickogCentra';

@Injectable({
  providedIn: 'root'
})
export class AdminKlinickogCentraService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  private url = 'http://localhost:8080/admin/centar'

  constructor(private http: HttpClient) { }

  dodajAdmina(admin: AdminKlinickogCentra): Observable<AdminKlinickogCentra> {
    return this.http.post<AdminKlinickogCentra>(this.url, admin, this.httpOptions);
  }
}
