import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminKlinickogCentraHomeComponent } from './components/admin-klinickog-centra-home/admin-klinickog-centra-home.component';
import { ZahteviZaRegistracijuComponent } from './components/zahtevi-za-registraciju/zahtevi-za-registraciju.component';
import { DodajKlinikuComponent } from './components/dodaj-kliniku/dodaj-kliniku.component';
import { DodajAdminaKlinikeComponent } from './components/dodaj-admina-klinike/dodaj-admina-klinike.component';
import { DodajDijagnozuComponent } from './components/dodaj-dijagnozu/dodaj-dijagnozu.component';
import { DodajLekComponent } from './components/dodaj-lek/dodaj-lek.component';
import { DodajAdminaKlinickogCentraComponent } from './components/dodaj-admina-klinickog-centra/dodaj-admina-klinickog-centra.component';


const routes: Routes = [
  { path: 'admin.centra', component: AdminKlinickogCentraHomeComponent},
  { path: 'admin.centra/zahtevi/registracija', component: ZahteviZaRegistracijuComponent},
  { path: 'admin.centra/klinika/dodaj', component: DodajKlinikuComponent},
  { path: 'admin.centra/klinika/new.admin', component: DodajAdminaKlinikeComponent},
  { path: 'admin.centra/dijagnoza/dodaj', component: DodajDijagnozuComponent},
  { path: 'admin.centra/lek/dodaj', component: DodajLekComponent},
  { path: 'admin.centra/new.admin', component: DodajAdminaKlinickogCentraComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
