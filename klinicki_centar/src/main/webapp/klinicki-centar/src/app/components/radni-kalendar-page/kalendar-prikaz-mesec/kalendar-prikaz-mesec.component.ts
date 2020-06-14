import { Component, OnInit, Input } from '@angular/core';
import { Lekar } from 'src/app/model/lekar';
import { RadniKalendarServiceService } from 'src/app/services/radni-kalendar-service.service';
import { CalendarMonth } from 'src/app/model/calendarMonth';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-kalendar-prikaz-mesec',
  templateUrl: './kalendar-prikaz-mesec.component.html',
  styleUrls: ['./kalendar-prikaz-mesec.component.css']
})
export class KalendarPrikazMesecComponent implements OnInit {

  constructor(private kalendarService : RadniKalendarServiceService) { }

  @Input() lekar : Lekar;
  month : CalendarMonth;

  mesecForm = new FormGroup({
    datum: new FormControl(''),  
  });

  ngOnInit(): void {
    
  }

  onSubmit() {
    this.kalendarService.getMesec(this.lekar, this.mesecForm.controls.datum.value).subscribe(data => this.month = data)
  }

}
