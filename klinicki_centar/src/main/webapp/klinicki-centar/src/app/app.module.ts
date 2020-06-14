import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AdminKlinickogCentraHomeComponent } from './components/admin-klinickog-centra-home/admin-klinickog-centra-home.component';
import { AdminCentraNavComponent } from './components/admin-centra-nav/admin-centra-nav.component';
import { ZahteviZaRegistracijuComponent } from './components/zahtevi-za-registraciju/zahtevi-za-registraciju.component';
import { DodajKlinikuComponent } from './components/dodaj-kliniku/dodaj-kliniku.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { DodajAdminaKlinikeComponent } from './components/dodaj-admina-klinike/dodaj-admina-klinike.component';
import { DodajDijagnozuComponent } from './components/dodaj-dijagnozu/dodaj-dijagnozu.component';
import { DodajLekComponent } from './components/dodaj-lek/dodaj-lek.component';
import { DodajAdminaKlinickogCentraComponent } from './components/dodaj-admina-klinickog-centra/dodaj-admina-klinickog-centra.component';
import { MedicinskaSestraHomeComponent } from './components/medicinska-sestra-home/medicinska-sestra-home.component';
import { ListaPacijenataComponent } from './components/lista-pacijenata/lista-pacijenata.component';
import { DodajZahtevZaOdsustvoComponent } from './components/dodaj-zahtev-za-odsustvo/dodaj-zahtev-za-odsustvo.component';
import { ListaPregledaComponent } from './components/lista-pregleda/lista-pregleda.component';
import { DodajIzvestajPregledaComponent } from './components/dodaj-izvestaj-pregleda/dodaj-izvestaj-pregleda.component';
import { ListaZahtevaZaDodeluSaleComponent } from './components/lista-zahteva-za-dodelu-sale/lista-zahteva-za-dodelu-sale.component';
import { OdbitiZahtevZaRegistracijuComponent } from './components/odbiti-zahtev-za-registraciju/odbiti-zahtev-za-registraciju.component';
import { DodajZdravstveniKartonComponent } from './components/dodaj-zdravstveni-karton/dodaj-zdravstveni-karton.component';
import { IzmeniZdravstveniKartonComponent } from './components/izmeni-zdravstveni-karton/izmeni-zdravstveni-karton.component';
import { RegistracijaComponent } from './components/registracija/registracija.component';
import { LoginComponent } from './components/login/login.component';
import { PacijentHomePageComponent } from './components/pacijent-home-page/pacijent-home-page.component';
import { NavComponent } from './components/nav/nav.component';
import { ListaKlinikaComponent } from './components/pacijent-home-page/lista-klinika/lista-klinika.component';
import { OcenjivanjeComponent } from './components/pacijent-home-page/ocenjivanje/ocenjivanje.component';
import { ProfilComponent } from './components/pacijent-home-page/profil/profil.component';
import { IzmeniProfilComponent } from './components/pacijent-home-page/izmeni-profil/izmeni-profil.component';
import { ZakazivanjePregledaComponent } from './components/pacijent-home-page/zakazivanje-pregleda/zakazivanje-pregleda.component';
import { AktivacijaNalogaComponent } from './components/aktivacija-naloga/aktivacija-naloga.component';
import { PotvrditiPregledComponent } from './components/zakazani-pregledi/potvrditi-pregled/potvrditi-pregled.component';
import { OdbitiPregledComponent } from './components/zakazani-pregledi/odbiti-pregled/odbiti-pregled.component';
import { ZdravstveniKartonComponent } from './components/zdravstveni-karton/zdravstveni-karton.component';
import { PredefinisaniPreglediComponent } from './components/pacijent-home-page/predefinisani-pregledi/predefinisani-pregledi.component';
import { KlinikeComponent } from './components/klinike/klinike.component';
import { ReceptiComponent } from './components/recepti/recepti.component';
import { RadniKalendarPageComponent } from './components/radni-kalendar-page/radni-kalendar-page.component';
import { KalendarPrikazDanComponent } from './components/radni-kalendar-page/kalendar-prikaz-dan/kalendar-prikaz-dan.component';
import { KalendarPrikazNedeljaComponent } from './components/radni-kalendar-page/kalendar-prikaz-nedelja/kalendar-prikaz-nedelja.component';
import { KalendarPrikazMesecComponent } from './components/radni-kalendar-page/kalendar-prikaz-mesec/kalendar-prikaz-mesec.component';
import { KalendarPrikazGodinaComponent } from './components/radni-kalendar-page/kalendar-prikaz-godina/kalendar-prikaz-godina.component';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatRippleModule } from '@angular/material/core';
import { DanUNedeljiComponent } from './components/radni-kalendar-page/kalendar-prikaz-nedelja/dan-u-nedelji/dan-u-nedelji.component';
import { DanUMesecuComponent } from './components/radni-kalendar-page/kalendar-prikaz-mesec/dan-u-mesecu/dan-u-mesecu.component';
import { EventUDanuComponent } from './components/radni-kalendar-page/kalendar-prikaz-mesec/dan-u-mesecu/event-u-danu/event-u-danu.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminKlinickogCentraHomeComponent,
    AdminCentraNavComponent,
    ZahteviZaRegistracijuComponent,
    DodajKlinikuComponent,
    DodajAdminaKlinikeComponent,
    DodajDijagnozuComponent,
    DodajLekComponent,
    DodajAdminaKlinickogCentraComponent,
    MedicinskaSestraHomeComponent,
    ListaPacijenataComponent,
    DodajZahtevZaOdsustvoComponent,
    ListaPregledaComponent,
    DodajIzvestajPregledaComponent,
    ListaZahtevaZaDodeluSaleComponent,
    OdbitiZahtevZaRegistracijuComponent,
    DodajZdravstveniKartonComponent,
    IzmeniZdravstveniKartonComponent,
    RegistracijaComponent,
    LoginComponent,
    PacijentHomePageComponent,
    NavComponent,
    ListaKlinikaComponent,
    OcenjivanjeComponent,
    ProfilComponent,
    IzmeniProfilComponent,
    ZakazivanjePregledaComponent,
    AktivacijaNalogaComponent,
    PotvrditiPregledComponent,
    OdbitiPregledComponent,
    ZdravstveniKartonComponent,
    PredefinisaniPreglediComponent,
    KlinikeComponent,
    ReceptiComponent,
    RadniKalendarPageComponent,
    KalendarPrikazDanComponent,
    KalendarPrikazNedeljaComponent,
    KalendarPrikazMesecComponent,
    KalendarPrikazGodinaComponent,
    DanUNedeljiComponent,
    DanUMesecuComponent,
    EventUDanuComponent
  ],
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
