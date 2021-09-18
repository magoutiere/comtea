import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {PageAdminCollaborateurComponent} from "./modules/collaborateur/pages/page-admin-collaborateur/page-admin-collaborateur.component";
import {PageHistoriqueRolesComponent} from "./modules/role-tournant/pages/page-historique-roles/page-historique-roles.component";

const appRoutes: Routes = [
  {path: 'collaborateurs', component: PageAdminCollaborateurComponent},
  {path: 'roles-tournants', component: PageHistoriqueRolesComponent},
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
