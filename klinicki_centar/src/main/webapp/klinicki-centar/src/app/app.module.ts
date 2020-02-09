import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule }    from '@angular/common/http';
import { AppComponent } from './app.component';
import { AdminKlinickogCentraHomeComponent } from './components/admin-klinickog-centra-home/admin-klinickog-centra-home.component';
import { AdminCentraNavComponent } from './components/admin-centra-nav/admin-centra-nav.component';
import { ZahteviZaRegistracijuComponent } from './components/zahtevi-za-registraciju/zahtevi-za-registraciju.component';
import { DodajKlinikuComponent } from './components/dodaj-kliniku/dodaj-kliniku.component';
import { ReactiveFormsModule } from '@angular/forms';
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
    ListaZahtevaZaDodeluSaleComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
