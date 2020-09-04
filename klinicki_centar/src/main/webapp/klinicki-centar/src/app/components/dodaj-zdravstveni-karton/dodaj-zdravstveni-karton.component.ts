import { Component, OnInit, Input } from '@angular/core';
import { Pacijent } from 'src/app/model/pacijent';
import { FormGroup, FormControl } from '@angular/forms';
import { ZdravstveniKarton } from 'src/app/model/zdravstveniKarton';
import { ZdravstveniKartonService } from 'src/app/services/zdravstveni-karton.service';

@Component({
  selector: 'app-dodaj-zdravstveni-karton',
  templateUrl: './dodaj-zdravstveni-karton.component.html',
  styleUrls: ['./dodaj-zdravstveni-karton.component.css']
})
export class DodajZdravstveniKartonComponent implements OnInit {

  @Input() pacijent: Pacijent;


  kartonForm = new FormGroup({
    datum_rodjenja : new FormControl(''),
    visina_pacijenta : new FormControl(''),
    tezina_pacijenta : new FormControl(''),
    krvna_grupa : new FormControl(''),
    dioptrija : new FormControl('')
  });

  constructor(private kartonService: ZdravstveniKartonService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    
    let karton = new ZdravstveniKarton();
    karton.datum_rodjenja = this.kartonForm.controls.datum_rodjenja.value;
    karton.visina_pacijenta = this.kartonForm.controls.visina_pacijenta.value;
    karton.tezina_pacijenta = this.kartonForm.controls.tezina_pacijenta.value;
    karton.krvna_grupa = this.kartonForm.controls.krvna_grupa.value;
    karton.dioptrija = this.kartonForm.controls.dioptrija.value;
    karton.pacijentID = this.pacijent.pacijentID;

    console.log(karton);

    this.kartonService.dodajKarton(karton).subscribe(data => console.log(data));
  }

}
