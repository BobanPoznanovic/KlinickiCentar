import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminKlinickogCentraHomeComponent } from './components/admin-klinickog-centra-home/admin-klinickog-centra-home.component';
import { ZahteviZaRegistracijuComponent } from './components/zahtevi-za-registraciju/zahtevi-za-registraciju.component';
import { DodajKlinikuComponent } from './components/dodaj-kliniku/dodaj-kliniku.component';
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
import {LoginComponent} from './components/login/login.component';
import {RegistracijaComponent} from './components/registracija/registracija.component';
import {PacijentHomePageComponent} from './components/pacijent-home-page/pacijent-home-page.component';
import {ListaKlinikaComponent} from './components/pacijent-home-page/lista-klinika/lista-klinika.component';
import {ProfilComponent} from './components/pacijent-home-page/profil/profil.component';
import {IzmeniProfilComponent} from './components/pacijent-home-page/izmeni-profil/izmeni-profil.component';
import {AktivacijaNalogaComponent} from './components/aktivacija-naloga/aktivacija-naloga.component';
import {PotvrditiPregledComponent} from './components/zakazani-pregledi/potvrditi-pregled/potvrditi-pregled.component';
import {OdbitiPregledComponent} from './components/zakazani-pregledi/odbiti-pregled/odbiti-pregled.component';
import {ZdravstveniKartonComponent} from './components/zdravstveni-karton/zdravstveni-karton.component';
import {OcenjivanjeComponent} from './components/pacijent-home-page/ocenjivanje/ocenjivanje.component';


const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegistracijaComponent},
  { path: 'admin.centra', component: AdminKlinickogCentraHomeComponent},
  { path: 'admin.centra/zahtevi/registracija', component: ZahteviZaRegistracijuComponent},
  { path: 'admin.centra/klinika/dodaj', component: DodajKlinikuComponent},
  { path: 'admin.centra/klinika/new.admin', component: DodajAdminaKlinikeComponent},
  { path: 'admin.centra/dijagnoza/dodaj', component: DodajDijagnozuComponent},
  { path: 'admin.centra/lek/dodaj', component: DodajLekComponent},
  { path: 'admin.centra/new.admin', component: DodajAdminaKlinickogCentraComponent},
  { path: 'sestra', component: MedicinskaSestraHomeComponent},
  { path: 'pacijent/home', component: PacijentHomePageComponent },
  { path: 'pacijent/all', component: ListaPacijenataComponent},
  { path: 'zahtev/odsustvo/dodaj', component: DodajZahtevZaOdsustvoComponent},
  { path: 'pregled/izvestaj/dodaj', component: DodajIzvestajPregledaComponent},
  { path: 'pregled/all', component: ListaPregledaComponent},
  { path: 'admin.klinika/zahtevi/sala', component: ListaZahtevaZaDodeluSaleComponent},
  { path: 'listaKlinika', component: ListaKlinikaComponent },
  { path: 'profil', component: ProfilComponent },
  { path: 'izmeniProfil', component: IzmeniProfilComponent },
  { path: 'aktivacija/:id', component: AktivacijaNalogaComponent },
  { path: 'potvrditi/:id', component: PotvrditiPregledComponent },
  { path: 'odbiti/:id', component: OdbitiPregledComponent },
  { path: 'zdravstveni-karton', component: ZdravstveniKartonComponent },
  { path: 'pregledi-operacije', component: OcenjivanjeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
