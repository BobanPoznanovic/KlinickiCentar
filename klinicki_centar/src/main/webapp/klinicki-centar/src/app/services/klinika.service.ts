import { Injectable } from '@angular/core';
import { Klinika } from '../model/klinika';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AdminKlinike } from '../model/adminKlinike';

@Injectable({
  providedIn: 'root'
})
export class KlinikaService {

  private backEndURL = 'http://localhost:8080/klinika';
  private adminURL = 'http://localhost:8080/admin/klinika';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  dodajKliniku(klinika: Klinika): Observable<Klinika> {
    return this.http.post<Klinika>(this.backEndURL, klinika, this.httpOptions);
  }

  dodajAdminaKlinike(admin: AdminKlinike): Observable<AdminKlinike> {
    return this.http.post<AdminKlinike>(this.adminURL, admin, this.httpOptions);
  }

  getByID(id: number) {
    return this.http.get<Klinika>(this.backEndURL + '/' + id);
  }

  getAll(): Observable<Klinika[]> {
    return this.http.get<Klinika[]>(this.backEndURL + '/all');
  }
}
