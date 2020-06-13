import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {any} from 'codelyzer/util/function';

@Injectable({
  providedIn: 'root'
})
export class PotvrditiPregledService {

  constructor(private http: HttpClient) { }

  potvrdiPregled(url: string) {
    return this.http.put<any>(url, any).subscribe();
  }
}
