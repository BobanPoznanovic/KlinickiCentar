import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ZdravstveniKarton } from '../model/zdravstveniKarton';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ZdravstveniKartonService {

  private backEndUrl = 'http://localhost:8080/karton';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  getKarton(id: number): Observable<ZdravstveniKarton> {
    return this.http.get<ZdravstveniKarton>(this.backEndUrl+'/'+id);
  }

  dodajKarton(karton: ZdravstveniKarton): Observable<ZdravstveniKarton> {
    return this.http.post<ZdravstveniKarton>(this.backEndUrl, karton, this.httpOptions);
  }

  updateKarton(karton: ZdravstveniKarton): Observable<ZdravstveniKarton> {
    return this.http.put<ZdravstveniKarton>(this.backEndUrl, karton, this.httpOptions);
  }

  getPacijentovKarton(id: number) {
    return this.http.get<ZdravstveniKarton>(this.backEndUrl + '/pacijent/' + id);
  }

}
