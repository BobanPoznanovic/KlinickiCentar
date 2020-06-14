import { Component, OnInit, Input } from '@angular/core';
import { Lekar } from 'src/app/model/lekar';
import { RadniKalendarServiceService } from 'src/app/services/radni-kalendar-service.service';
import { FormGroup, FormControl } from '@angular/forms';
import { CalendarWeek } from 'src/app/model/calendarWeek';

@Component({
  selector: 'app-kalendar-prikaz-nedelja',
  templateUrl: './kalendar-prikaz-nedelja.component.html',
  styleUrls: ['./kalendar-prikaz-nedelja.component.css']
})
export class KalendarPrikazNedeljaComponent implements OnInit {

  constructor(private kalendarService : RadniKalendarServiceService) { }

  @Input() lekar : Lekar;
  week : CalendarWeek;

  nedeljaForm = new FormGroup({
    datum: new FormControl(''),  
  });

  ngOnInit(): void {
  }

  onSubmit() {
    this.kalendarService.getNedelja(this.lekar, this.nedeljaForm.controls.datum.value).subscribe(data => this.week = data)
  }

}
