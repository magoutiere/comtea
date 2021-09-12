import {Injectable} from '@angular/core';
import {RoleTournantApiService} from "../../../../../api/services/role-tournant-api.service";
import {BehaviorSubject} from "rxjs";
import {HistoriqueElection} from "../../../../../api/models/historique-election";
import {Collaborateur} from "../../../../../api/models/collaborateur";

@Injectable({
  providedIn: 'root'
})
export class RoleTournantService {

  private watchHistoriqueElection = new BehaviorSubject(new Array<HistoriqueElection>());
  historiqueElection = this.watchHistoriqueElection.asObservable();

  constructor(private roleTournantApiService: RoleTournantApiService) {
  }

  majHistorique() {
    this.roleTournantApiService.historique({role: 'cafe'}).toPromise()
      .then(value => this.watchHistoriqueElection.next(value))
      .catch(() => {
      })
  }

  lancerElection(): Promise<Collaborateur> {
    return this.roleTournantApiService.election({role: 'cafe'}).toPromise()
      .then(vainqueur => {
        this.majHistorique();
        return vainqueur;
      })
  }
}
