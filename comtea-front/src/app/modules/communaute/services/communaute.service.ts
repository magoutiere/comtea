import {Injectable} from '@angular/core';
import {CommunauteApiService} from "../../../../../api/services/communaute-api.service";
import {BehaviorSubject} from "rxjs";
import {Communaute} from "../../../../../api/models/communaute";
import {NotificationService} from "../../../services/notification.service";

@Injectable({
  providedIn: 'root'
})
export class CommunauteService {

  private etat = new BehaviorSubject(new Array<Communaute>());
  communautes = this.etat.asObservable();

  constructor(private communauteApiService: CommunauteApiService, private notificationService: NotificationService) {
  }

  majCommunautes() {
    this.communauteApiService.recupererCommunautes().toPromise()
      .then(communautes => this.etat.next(communautes))
      .catch(() => {
      })
  }

  creerCommunaute(communaute: Communaute) {
    return this.communauteApiService.creerOuMettreAJourCommunaute({body: communaute}).toPromise()
      .then(() => this.notificationService.success({titre: 'Succès', message: `Communauté ${communaute.identifiant} créée avec succès !`}))
      .then(() => this.majCommunautes());
  }

  supprimerCommunaute(communaute: Communaute) {
    const identifiant = communaute.identifiant;
    this.communauteApiService.supprimerCommunaute({identifiant}).toPromise()
      .then(() => this.notificationService.success({titre: 'Succès', message: `Communauté ${communaute.identifiant} supprimé !`}))
      .then(() => this.majCommunautes());
  }
}
