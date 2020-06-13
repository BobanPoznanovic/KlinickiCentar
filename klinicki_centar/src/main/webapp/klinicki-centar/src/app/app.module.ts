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
    ZakazivanjePregledaComponent
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
