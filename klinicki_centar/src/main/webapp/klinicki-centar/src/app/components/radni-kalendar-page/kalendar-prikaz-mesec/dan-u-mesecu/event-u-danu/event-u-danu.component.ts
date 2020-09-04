import { Component, OnInit, Input } from '@angular/core';
import  {CalendarEvent } from '../../../../../model/calendarEvent';
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
  selectedPregledID: number;

  ngOnInit(): void {
    if(this.event.tip == 0) {
      //Pregled je
      let pregledID = this.event.eventID;
      this.pregledService.getById(pregledID).subscribe(
        data => {
          this.pregled = data;
          console.log('pregled: ');
          console.log(this.pregled);
          this.pregledService.getIzvestajByPregledID(pregledID).subscribe(
            res => {
              console.log('Response za izvestajByPregledID');
              console.log(res);
              if(res!=null) {
                this.izvestajPregleda = res;
              }
            }
          );
        }
        );
    }
  }

  kreirajPregled(pregled: Pregled) {
    this.selectedPregledID = pregled.pregledID;
  }

}
