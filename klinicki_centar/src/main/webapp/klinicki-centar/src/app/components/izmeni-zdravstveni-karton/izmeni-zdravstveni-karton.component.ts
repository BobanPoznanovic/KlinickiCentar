import { Component, OnInit, Input } from '@angular/core';
import { Pacijent } from 'src/app/model/pacijent';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { ZdravstveniKarton } from 'src/app/model/zdravstveniKarton';
import { ZdravstveniKartonService } from 'src/app/services/zdravstveni-karton.service';

@Component({
  selector: 'app-izmeni-zdravstveni-karton',
  templateUrl: './izmeni-zdravstveni-karton.component.html',
  styleUrls: ['./izmeni-zdravstveni-karton.component.css']
})
export class IzmeniZdravstveniKartonComponent implements OnInit {

  @Input() pacijent: Pacijent;
  karton: ZdravstveniKarton;

  kartonForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private kartonService: ZdravstveniKartonService) { }

  ngOnInit(): void {

    this.karton = new ZdravstveniKarton();

    this.kartonService.getKarton(this.pacijent.zdravstveni_kartonID).subscribe(data => {
      this.karton = data;
    });

    this.kartonForm = this.formBuilder.group({
      datum_rodjenja : new FormControl(this.karton.datum_rodjenja),
      visina_pacijenta : new FormControl(''),
      tezine_pacijenta : new FormControl(''),
      krvna_grupa : new FormControl(''),
      dioptrija : new FormControl('')
    });
  }

  onSubmit() {

    console.log(this.kartonForm.controls.dioptrija.value);

    this.karton.datum_rodjenja = this.kartonForm.controls.datum_rodjenja.value;
    this.karton.visina_pacijenta = this.kartonForm.controls.visina_pacijenta.value;
    this.karton.tezine_pacijenta = this.kartonForm.controls.tezine_pacijenta.value;
    this.karton.krvna_grupa = this.kartonForm.controls.krvna_grupa.value;
    this.karton.dioptrija = this.kartonForm.controls.dioptrija.value;
    this.karton.pacijentID = this.pacijent.pacijentID;

    console.log(this.karton);

    //this.kartonService.updateKarton(this.karton).subscribe(data => this.karton = data);

  }

}
