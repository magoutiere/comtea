import {Component, OnInit} from '@angular/core';
import {RoleTournantService} from "../../services/role-tournant.service";
import {HistoriqueElection} from "../../../../../../api/models/historique-election";
import {NotificationService} from "../../../../services/notification.service";
import {Collaborateur} from "../../../../../../api/models/collaborateur";

@Component({
  selector: 'app-historique-election',
  templateUrl: './historique-election.component.html'
})
export class HistoriqueElectionComponent implements OnInit {

  historiqueElection: HistoriqueElection[] = [];

  constructor(private roleTournantService: RoleTournantService, private notificationService: NotificationService) {
  }

  ngOnInit(): void {
    this.roleTournantService.historiqueElection.subscribe(value => this.historiqueElection = value)
    this.roleTournantService.majHistorique();
  }

  lancerElection() {
    this.roleTournantService.lancerElection()
      .then((vainqueur: Collaborateur) => {
        this.notificationService.success({
          titre: "Election",
          message: `Félicitation ${vainqueur.identifiant} !`
        });
      })
      .catch(() => {
      });
  }
}
