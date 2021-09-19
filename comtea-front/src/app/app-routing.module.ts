import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {GestionCollaborateurComponent} from "./modules/collaborateur/pages/gestion-collaborateur/gestion-collaborateur.component";
import {HistoriqueRolesComponent} from "./modules/role-tournant/pages/historique-roles/historique-roles.component";
import {GestionCommunauteComponent} from "./modules/communaute/pages/gestion-communaute/gestion-communaute.component";

const appRoutes: Routes = [
  {path: 'collaborateurs', component: GestionCollaborateurComponent},
  {path: 'roles-tournants', component: HistoriqueRolesComponent},
  {path: 'communautes', component: GestionCommunauteComponent},
  {path: '', redirectTo: '/roles-tournants', pathMatch: 'full'}
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: true} // <-- debugging purposes only
    )
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}
