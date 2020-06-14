import { Component, OnInit, Input } from '@angular/core';
import { CalendarEvent } from 'src/app/model/calendarEvent';

@Component({
  selector: 'app-event-u-danu',
  templateUrl: './event-u-danu.component.html',
  styleUrls: ['./event-u-danu.component.css']
})
export class EventUDanuComponent implements OnInit {

  constructor() { }

  @Input() event : CalendarEvent;

  ngOnInit(): void {
  }

}
