import { Injectable } from '@angular/core';
import {Pregled} from '../model/pregled';
import {HttpClient} from '@angular/common/http';
import {Operacija} from '../model/operacija';
import {Observable} from 'rxjs';
import {Pacijent} from '../model/pacijent';
import {Klinika} from '../model/klinika';
import {any} from 'codelyzer/util/function';
import {TipPregleda} from '../model/tipPregleda';
import {Lekar} from '../model/lekar';

@Injectable({
  providedIn: 'root'
})
export class PacijentHomepageService {

  private readonly url: string;
  pacijentID;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/pacijent/';
  }

  nadjiSvePregledeZaOcenjivanje(id: number) {
    return this.http.get<Pregled[]>('http://localhost:8080/pregled/pacijentoviPreglediOcenjivanje/' + id);
  }

  nadjiSveOperacijeZaOcenjivanje(id: number) {
    return this.http.get<Operacija[]>('http://localhost:8080/operacija/pacijentoveOperacijeOcenjivanje/' + id);
  }

  public getPacijent(id: number): Observable<Pacijent> {
    return this.http.get<Pacijent>(this.url + id);
  }

  getSveKlinike(): Observable<Klinika[]> {
    return this.http.get<Klinika[]>('http://localhost:8080/klinika/all');
  }

  oceniKlinikuPregled(pregledID: number, ocena: number, klinikaID: number) {
    return this.http.put<any>('http://localhost:8080/klinika/oceniKlinikuPregled/' + pregledID + '/' + ocena + '/' + klinikaID, any).subscribe();
  }

  oceniLekaraPregled(pregledID: number, ocena: number, lekarID: number) {
    return this.http.put<any>('http://localhost:8080/lekar/oceniLekaraPregled/' + pregledID + '/' + ocena + '/' + lekarID, any).subscribe();
  }

  oceniKlinikuOperacija(operacijaID: number, ocena: number, klinikaID: number) {
    return this.http.put<any>('http://localhost:8080/klinika/oceniKlinikuOperacija/' + operacijaID + '/' + ocena + '/' + klinikaID, any).subscribe();
  }

  oceniLekaraOperacija(operacijaID: number, ocena: number, lekarID: number) {
    return this.http.put<any>('http://localhost:8080/lekar/oceniLekaraOperacija/' + operacijaID + '/' + ocena + '/' + lekarID, any).subscribe();
  }

  getSveTipovePregleda() {
    return this.http.get<TipPregleda[]>('http://localhost:8080/tipPregleda/all');
  }

  pretragaKlinika(tipPregledaID: number, selectedName: string, selectedRating: number) {
    if (selectedName === undefined || selectedName === '') {
      selectedName = ' ';
    }
    if (selectedRating === undefined || selectedRating === null) {
      selectedRating = 0.0;
    }

    return this.http.get<Klinika[]>('http://localhost:8080/klinika/pretragaKlinika/'
      + tipPregledaID + '/' + selectedName + '/' + selectedRating);
  }

  pretragaLekaraZaPregled(tipPregledaID: number, klinikaID: number, datum: string) {
    return this.http.get<Lekar[]>('http://localhost:8080/lekar/search/lekariZaPregled/'
    + tipPregledaID + '/' + klinikaID + '/' + datum);
  }

  posaljiZahtevZaPregled(selectedTip: number, selectedDate: string, selectedKlinikaId: number, selectedLekarId: number,
                         pacijentId: number, selectedTermin: string) {
    return this.http.put<any>('http://localhost:8080/zahtevZaPregled/slanjeZahteva/'
      + selectedTip + '/' + selectedDate + '/' + selectedKlinikaId + '/'
      + selectedLekarId + '/' + pacijentId + '/' + selectedTermin, any).subscribe();
  }

  nadjiSlobodneTermineLekara(lekarID: number, datum: string) {
    console.log('\n\nnadjiSlobodneTermineLekara  -  ' + 'lekarID: ' +
      lekarID + '\ndatum: ' + datum  );
    return this.http.get<string[]>('http://localhost:8080/pregled/slobodniTermini/' + lekarID + '/' + datum);
  }

}
