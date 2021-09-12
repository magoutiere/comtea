import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HistoriqueElectionComponent } from './components/historique-election/historique-election.component';



@NgModule({
  declarations: [
    HistoriqueElectionComponent
  ],
  exports: [
    HistoriqueElectionComponent
  ],
  imports: [
    CommonModule
  ]
})
export class RoleTournantModule { }
