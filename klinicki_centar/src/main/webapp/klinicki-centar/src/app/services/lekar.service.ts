import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Lekar} from "../model/lekar";

@Injectable({
  providedIn: 'root'
})
export class LekarService {

  private backEndURL = 'http://localhost:8080/lekar';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  getByID(id: number) {
    return this.http.get<Lekar>(this.backEndURL + '/' + id);
  }
}
