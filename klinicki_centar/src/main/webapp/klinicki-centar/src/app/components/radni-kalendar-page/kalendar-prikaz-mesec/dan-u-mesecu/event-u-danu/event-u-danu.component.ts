import { Component, OnInit, Input } from '@angular/core';
import { CalendarEvent } from 'src/app/model/calendarEvent';
import { PregledService } from 'src/app/services/pregled.service';
import { Pregled } from 'src/app/model/pregled';
import { IzvestajPregleda } from 'src/app/model/izvestajPregleda';

@Component({
  selector: 'app-event-u-danu',
  templateUrl: './event-u-danu.component.html',
  styleUrls: ['./event-u-danu.component.css']
})
export class EventUDanuComponent implements OnInit {

  constructor(
    private pregledService : PregledService
  ) { }

  @Input() event : CalendarEvent;
  pregled : Pregled;
  izvestajPregleda : IzvestajPregleda;

  ngOnInit(): void {
    if(this.event.tip == 0) {
      //Pregled je
      let pregledID = this.event.eventID;
      this.pregledService.getById(pregledID).subscribe(
        data => {
          this.pregled = data;
          this.pregledService.getIzvestajByPregledID(this.event.eventID).subscribe(
            res => {
              if(res!=null) {
                this.izvestajPregleda = res;
              }
            }
          );
        }
        );
    }
  }

}
