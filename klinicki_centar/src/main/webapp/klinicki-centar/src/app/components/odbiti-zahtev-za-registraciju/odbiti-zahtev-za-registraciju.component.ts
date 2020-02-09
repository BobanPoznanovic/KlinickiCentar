import { Component, OnInit, Input } from '@angular/core';
import { ZahtevZaRegistraciju } from 'src/app/model/zahtevZaRegistraciju';
import { FormGroup, FormControl } from '@angular/forms';
import { ZahteviZaRegistracijuService } from 'src/app/services/zahtevi-za-registraciju.service';

@Component({
  selector: 'app-odbiti-zahtev-za-registraciju',
  templateUrl: './odbiti-zahtev-za-registraciju.component.html',
  styleUrls: ['./odbiti-zahtev-za-registraciju.component.css']
})
export class OdbitiZahtevZaRegistracijuComponent implements OnInit {

  constructor(private zahtevService: ZahteviZaRegistracijuService) { }

  zahtevForm = new FormGroup({
    razlog_odbijanja: new FormControl('')
  });

  @Input() zahtev: ZahtevZaRegistraciju;

  ngOnInit(): void {
  }
  
  onSubmit() {
    this.zahtev.razlog_odbijanja = this.zahtevForm.controls.razlog_odbijanja.value;
    this.zahtev.status_zahteva = "Odbijen";
    this.zahtevService.odbitiZahtev(this.zahtev).subscribe(data => console.log(data));
  }

}
