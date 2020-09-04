import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Lekar } from 'src/app/model/lekar';
import { CalendarMonth } from 'src/app/model/calendarMonth';
import { RadniKalendarServiceService } from 'src/app/services/radni-kalendar-service.service';

@Component({
  selector: 'app-kalendar-prikaz-godina',
  templateUrl: './kalendar-prikaz-godina.component.html',
  styleUrls: ['./kalendar-prikaz-godina.component.css']
})
export class KalendarPrikazGodinaComponent implements OnInit {

  constructor(private kalendarService : RadniKalendarServiceService) { }

  @Input() lekar : Lekar;
  january: CalendarMonth;
  february: CalendarMonth;
  march: CalendarMonth;
  april: CalendarMonth;
  may: CalendarMonth;
  june: CalendarMonth;
  july: CalendarMonth;
  august: CalendarMonth
  september: CalendarMonth;
  october: CalendarMonth;
  november: CalendarMonth;
  december: CalendarMonth;

  godinaForm = new FormGroup({
    datum: new FormControl(''),  
  });

  ngOnInit(): void {
  }

  onSubmit() {

    var datum = this.godinaForm.controls.datum.value;
    var splitted = datum.split("-",1);
    var str_year = splitted[0];

    var date_jan = str_year+"-"+"01"+"-"+"01";
    this.kalendarService.getMesec(this.lekar, date_jan).subscribe(data => {this.january = data})

    var date_feb = str_year+"-"+"02"+"-"+"01";
    this.kalendarService.getMesec(this.lekar, date_feb).subscribe(data => {this.february = data})

    var date_march = str_year+"-"+"03"+"-"+"01";
    this.kalendarService.getMesec(this.lekar, date_march).subscribe(data => {this.march = data})

    var date_april = str_year+"-"+"04"+"-"+"01";
    this.kalendarService.getMesec(this.lekar, date_april).subscribe(data => {this.april = data})

    var date_may = str_year+"-"+"05"+"-"+"01";
    this.kalendarService.getMesec(this.lekar, date_may).subscribe(data => {this.may = data})

    var date_june = str_year+"-"+"06"+"-"+"01";
    this.kalendarService.getMesec(this.lekar, date_june).subscribe(data => {this.june = data})

    var date_july = str_year+"-"+"07"+"-"+"01";
    this.kalendarService.getMesec(this.lekar, date_july).subscribe(data => {this.july = data})

    var date_august = str_year+"-"+"08"+"-"+"01";
    this.kalendarService.getMesec(this.lekar, date_august).subscribe(data => {this.august = data})

    var date_september = str_year+"-"+"09"+"-"+"01";
    this.kalendarService.getMesec(this.lekar, date_september).subscribe(data => {this.september = data})

    var date_october = str_year+"-"+"10"+"-"+"01";
    this.kalendarService.getMesec(this.lekar, date_october).subscribe(data => {this.october = data})

    var date_november = str_year+"-"+"11"+"-"+"01";
    this.kalendarService.getMesec(this.lekar, date_november).subscribe(data => {this.november = data})

    var date_december = str_year+"-"+"12"+"-"+"01";
    this.kalendarService.getMesec(this.lekar, date_december).subscribe(data => {this.december = data})

  }

}
