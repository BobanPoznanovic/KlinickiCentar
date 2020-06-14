import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Pacijent} from '../model/pacijent';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IzmeniProfilService {

  private readonly url: string;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/pacijent/update';
  }

  public update(pacijent: Pacijent): Observable<Pacijent> {
    return this.http.put<Pacijent>(this.url, pacijent);
  }
}
