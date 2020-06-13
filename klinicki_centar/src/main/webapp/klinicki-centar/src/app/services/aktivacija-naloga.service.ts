import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Subscription} from 'rxjs';
import {any} from 'codelyzer/util/function';

@Injectable({
  providedIn: 'root'
})
export class AktivacijaNalogaService {

  constructor(private http: HttpClient) { }

  public aktivacijaNaloga(url: string): Subscription {
    return this.http.put<any>(url, any).subscribe();
  }

}
