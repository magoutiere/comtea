import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HistoriqueElectionComponent} from './components/historique-election/historique-election.component';
import {TableModule} from "primeng/table";
import {ButtonModule} from "primeng/button";
import { PageHistoriqueRolesComponent } from './pages/page-historique-roles/page-historique-roles.component';
import {PanelModule} from "primeng/panel";


@NgModule({
  declarations: [
    HistoriqueElectionComponent,
    PageHistoriqueRolesComponent
  ],
  exports: [
    HistoriqueElectionComponent
  ],
    imports: [
        CommonModule,
        TableModule,
        ButtonModule,
        PanelModule
    ]
})
export class RoleTournantModule {
}
