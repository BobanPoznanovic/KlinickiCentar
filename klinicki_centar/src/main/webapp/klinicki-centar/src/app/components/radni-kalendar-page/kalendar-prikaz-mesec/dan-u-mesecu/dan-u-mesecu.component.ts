import { Component, OnInit, Input } from '@angular/core';
import { CalendarDay } from 'src/app/model/calendarDay';

@Component({
  selector: 'app-dan-u-mesecu',
  templateUrl: './dan-u-mesecu.component.html',
  styleUrls: ['./dan-u-mesecu.component.css']
})
export class DanUMesecuComponent implements OnInit {

  constructor() { }

  @Input() day : CalendarDay;
  dayInWeekStr : string;
  @Input() month : number;
  monthStr : string;

  ngOnInit(): void {
    this.whatDay(this.day.dayInWeek);
    this.whatMonth(this.month);

  }

  whatDay(orderNumber : number) {
    switch(this.day.dayInWeek) {
      case 1:
        this.dayInWeekStr = "Nedelja";
        break;
      case 2:
        this.dayInWeekStr = "Ponedeljak";
        break;
      case 3:
        this.dayInWeekStr = "Utorak";
        break;
      case 4:
        this.dayInWeekStr = "Sreda";
        break;
      case 5:
        this.dayInWeekStr = "Cetvrtak";
        break;
      case 6:
        this.dayInWeekStr = "Petak";
        break;
      case 7:
        this.dayInWeekStr = "Subota";
        break; 
    }
  }

  whatMonth(orderNumber : number) {
    switch(this.month) {
      case 0:
        this.monthStr = "Januar";
        break;
      case 1:
        this.monthStr = "Februar";
        break;
      case 2:
        this.monthStr = "Mart";
        break;
      case 3:
        this.monthStr = "April";
        break;
      case 4:
        this.monthStr = "Maj";
        break;
      case 5:
        this.monthStr = "Jun";
        break;
      case 6:
        this.monthStr = "Jul";
        break;
      case 7:
        this.monthStr = "Avgust";
        break;
      case 8:
        this.monthStr = "Septembar";
        break;
      case 9:
        this.monthStr = "Oktobar";
        break;
      case 10:
        this.monthStr = "Novembar";
        break;
      case 11:
        this.monthStr = "Decembar";
        break;
    }
  }

}
