import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Lekar } from '../model/lekar';
import { CalendarEvent } from '../model/calendarEvent';
import { Observable } from 'rxjs';
import { CalendarWeek } from '../model/calendarWeek';

@Injectable({
  providedIn: 'root'
})
export class RadniKalendarServiceService {

  private url = 'http://localhost:8080/kalendar/'

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  getDan(lekar: Lekar, datum : String) : Observable<CalendarEvent[]> {
    let lekarID = lekar.lekarID;
    
    return this.http.get<CalendarEvent[]>(this.url+'day/'+lekarID+'/'+datum)
  }

  getNedelja(lekar : Lekar, datum : String) : Observable<CalendarWeek> {
    let lekarID = lekar.lekarID;

    return this.http.get<CalendarWeek>(this.url+'week/'+lekarID+'/'+datum)
  }

}
