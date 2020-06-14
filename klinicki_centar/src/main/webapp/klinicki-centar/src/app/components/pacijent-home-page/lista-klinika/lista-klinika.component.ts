import { Component, OnInit } from '@angular/core';
import {Klinika} from '../../../model/klinika';
import {TipPregleda} from '../../../model/tipPregleda';
import {Lekar} from '../../../model/lekar';
import {Pacijent} from '../../../model/pacijent';
import {PacijentHomepageService} from '../../../services/pacijent-homepage.service';
import {Router} from '@angular/router';
import {PacijentService} from '../../../services/pacijent.service';
import {DatePipe} from '@angular/common';
import {Sort} from '@angular/material/sort';
import {Observable} from 'rxjs';
import {AuthService} from "../../../services/auth.service";

@Component({
  selector: 'app-lista-klinika',
  templateUrl: './lista-klinika.component.html',
  styleUrls: ['./lista-klinika.component.css'],
  providers: [DatePipe]
})
export class ListaKlinikaComponent implements OnInit {

  availableTerms: string[];
  selectedTerm: string;
  hiddenTerms = true;
  hiddenLabel = true;
  hiddenHeader = true;

  klinike: Klinika[] = [];
  tipoviPregleda: TipPregleda[] = [];

  selectedOption: string;
  realSelectedOptionById: number;
  selectedDate: any;
  selectedClinicId: number;
  selectedDoctorId: number;
  selectedName: string;
  selectedRating: number;
  lekari: Lekar[] = [];
  pronadjeniLekari: Lekar[] = [];

  hiddenSend: boolean;
  isAnyClinicSelected: boolean;
  isTypeSelected: boolean;
  isSearchHidden = false;
  isSearchDoctorHidden = false;
  selectedFirstName: string;
  selectedLastName: string;
  selectedDoctorRating: number;

  realDateAsString: string;
  todayDate: string;

  previousDoctor: string;

  auth: AuthService;

  public pacijent: Pacijent;
  public sortedData: Klinika[];

  constructor(private pacijentHomepageService: PacijentHomepageService,
              private router: Router, private  pacijentService: PacijentService,
              private datePipe: DatePipe) {
    this.selectedDate = new Date();
    this.realDateAsString = this.datePipe.transform(this.selectedDate, 'yyyy-MM-dd');
    this.todayDate = this.datePipe.transform(new Date(), 'yyyy-MM-dd');
    this.pacijent = new Pacijent();
  }

  ngOnInit(): void {
    // this.pacijentService.getMyInfo();
    // this.pacijent = this.pacijentService.currentUser;

    this.pacijentHomepageService.getSveKlinike()
      .subscribe(data => {
        this.klinike = data;
        this.sortedData = data;
      });

    this.pacijentHomepageService.getSveTipovePregleda()
      .subscribe(data => {
        this.tipoviPregleda = data;
      });

  }

  onSearchSubmit(selectedOption: string, selectedName: string, selectedRating: number) {
    this.isTypeSelected = true;
    if (selectedOption === 'No type') {
      this.selectedOption = 'No type';
      this.resetAllForm();
    } else {
      this.pacijentHomepageService.pretragaKlinika(this.realSelectedOptionById, selectedName, selectedRating).subscribe(data => {
        this.klinike = data;
        this.sortedData = data;
      });
    }
  }

  onSelectChange() {
    console.log(this.selectedOption);
    let counter = 0;
    let pom = 0;
    for (const a of this.tipoviPregleda) {
      if (a.naziv === this.selectedOption) {
        pom = counter + 1;
        this.realSelectedOptionById = pom;
        console.log(this.realSelectedOptionById);
      }
      counter++;
    }
    console.log(this.realSelectedOptionById);
  }

  resetAllForm() {
    this.hiddenSend = false;
    this.isTypeSelected = false;
    this.isAnyClinicSelected = false;
    this.pacijentHomepageService.getSveKlinike().subscribe(data => {
      this.klinike = data;
    });
  }

  getDoctorFromSelectedClinic(selectedOption: string, id: number) {
    this.isAnyClinicSelected = true;
    this.selectedClinicId = id;
    this.pacijentHomepageService.pretragaLekaraZaPregled(this.realSelectedOptionById, id, this.realDateAsString).subscribe(data => {
      this.lekari = data;
      this.pronadjeniLekari = data;
    });
    this.hiddenHeader = true;
    this.hiddenTerms = true;
    this.hiddenLabel = true;
  }

  showSendRequestButton(id: number) {
    console.log('termin je ' + this.selectedTerm);
    this.selectedDoctorId = id;
    this.hiddenSend = true;
  }

  nadjiTermine(selectedType: string, selectedDate: string) {
    this.pacijentHomepageService.nadjiSlobodneTermineLekara(this.selectedDoctorId, this.realDateAsString).subscribe(data => {
      this.availableTerms = data;
      if (this.availableTerms.includes(this.selectedTerm)) {
        this.pacijentHomepageService.posaljiZahtevZaPregled(
              this.realSelectedOptionById,
              this.realDateAsString,
              this.selectedClinicId,
              this.selectedDoctorId,
              Number(localStorage.getItem('pacijentID')),
              this.selectedTerm
        );
        this.resetAllForm();
        console.log('Zahtev je poslat');
        this.hiddenLabel = true;
        this.hiddenHeader = true;
        this.hiddenTerms = true;
      } else {
        console.log('Izaberite drugi termin');
      }
    });

  }

  showSearch($event: MouseEvent) {
    if (this.isSearchHidden) {
      this.isSearchHidden = false;
    } else {
      this.isSearchHidden = true;
    }
  }

  showSearchDoctor($event: MouseEvent) {
    if (this.isSearchDoctorHidden) {
      this.isSearchDoctorHidden = false;
    } else {
      this.isSearchDoctorHidden = true;
    }
  }

  onSearchDoctorSubmit(selectedFirstName: string, selectedLastName: string, selectedDoctorRating: number) {
    if (!selectedFirstName && !selectedLastName && !selectedDoctorRating) {
      this.pronadjeniLekari = this.lekari;
    } else {
      if (selectedFirstName === undefined || selectedFirstName === null) {
        selectedFirstName = '';
      }
      if (selectedLastName === undefined || selectedLastName === null) {
        selectedLastName = '';
      }
      if (selectedDoctorRating === undefined || selectedDoctorRating === null) {
        selectedDoctorRating = 0;
      }
      this.pronadjeniLekari = this.lekari.filter(x =>
        x.ime.trim().toLowerCase().includes(selectedFirstName.trim().toLowerCase())
        && x.prezime.trim().toLowerCase().includes(selectedLastName.trim().toLowerCase())
        && x.prosecna_ocena >= selectedDoctorRating
      );
    }
  }

  showTerms(id: number) {
    this.pacijentHomepageService.nadjiSlobodneTermineLekara(id, this.realDateAsString).subscribe(data => {
      this.availableTerms = data;
      this.hiddenHeader = false;
      if (this.availableTerms.length === 0) {
        this.hiddenLabel = false;
      } else {
        this.hiddenTerms = false;
      }
    });
  }

  dateChanged($event: Event) {
    console.log((this.selectedDate));
    this.realDateAsString = this.datePipe.transform(this.selectedDate, 'yyyy-MM-dd');
    console.log(this.realDateAsString);
  }

  parseDate(dateString: Date): Date {
    if (dateString) {
      return new Date(dateString);
    }
    return null;
  }

  sortData(sort: Sort) {
    const data = this.klinike.slice();
    if (!sort.active || sort.direction === '') {
      this.sortedData = data;
      return;
    }

    this.sortedData = data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';

      switch (sort.active) {
        case 'name':
          return compare(a.naziv, b.naziv, isAsc);
        case 'address':
          return compare(a.adresa, b.adresa, isAsc);
        case 'city':
          return compare(a.grad, b.grad, isAsc);
        default:
          return 0;
      }
    });
  }

  showOnlySelectedTd(id: number) {
    if (document.getElementById(this.previousDoctor) != null) {
      document.getElementById(this.previousDoctor).hidden = true;
      this.hiddenSend = true;
    }
    document.getElementById('terms-' + id).hidden = false;
    this.previousDoctor = 'terms-' + id;
    this.showTerms(id);
  }

  showPredefinedExams(id: number) {

    this.router.navigate(['/predefinisaniPregledi']);
  }



}

function compare(a: number | string, b: number | string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}
