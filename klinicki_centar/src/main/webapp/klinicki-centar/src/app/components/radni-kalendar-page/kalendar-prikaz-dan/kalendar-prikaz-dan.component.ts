import { Component, OnInit, Input } from '@angular/core';
import { RadniKalendarServiceService } from 'src/app/services/radni-kalendar-service.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Lekar } from 'src/app/model/lekar';
import { CalendarEvent } from 'src/app/model/calendarEvent';

@Component({
  selector: 'app-kalendar-prikaz-dan',
  templateUrl: './kalendar-prikaz-dan.component.html',
  styleUrls: ['./kalendar-prikaz-dan.component.css']
})
export class KalendarPrikazDanComponent implements OnInit {

  constructor(private kalendarService : RadniKalendarServiceService) { }

  @Input() lekar : Lekar;
  events : CalendarEvent[];

  danForm = new FormGroup({
    datum: new FormControl(''),  
  });

  ngOnInit(): void {

  }

  onSubmit() {
    this.kalendarService.getDan(this.lekar, this.danForm.controls.datum.value).subscribe(rezultat => this.events = rezultat);
  }

}
