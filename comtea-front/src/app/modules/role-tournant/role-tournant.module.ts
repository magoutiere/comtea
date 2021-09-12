import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HistoriqueElectionComponent} from './components/historique-election/historique-election.component';
import {TableModule} from "primeng/table";
import {ButtonModule} from "primeng/button";


@NgModule({
  declarations: [
    HistoriqueElectionComponent
  ],
  exports: [
    HistoriqueElectionComponent
  ],
  imports: [
    CommonModule,
    TableModule,
    ButtonModule
  ]
})
export class RoleTournantModule {
}
