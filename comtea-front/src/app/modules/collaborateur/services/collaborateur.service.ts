import {Injectable} from '@angular/core';
import {CollaborateurApiService} from "../../../../../api/services/collaborateur-api.service";
import {BehaviorSubject} from "rxjs";
import {Collaborateur} from "../../../../../api/models";
import {NotificationService} from "../../../services/notification.service";

@Injectable({
  providedIn: 'root'
})
export class CollaborateurService {

  private collaborateurs = new BehaviorSubject(new Array<Collaborateur>());
  collaborateursCourant = this.collaborateurs.asObservable();

  constructor(private collaborateurApiService: CollaborateurApiService, private notificationService: NotificationService) {
  }

  majCollaborateurs() {
    return this.collaborateurApiService.recupererCollaborateurs().toPromise()
      .then(value => this.collaborateurs.next(value));
  }

  creerCollaborateur(collaborateur: Collaborateur) {
    return this.collaborateurApiService.creerCollaborateur({body: collaborateur}).toPromise()
      .then(() => this.notificationService.success({titre: 'Succès', message: `Collaborateur ${collaborateur.identifiant} créé !`}))
      .then(() => this.majCollaborateurs());
  }

  supprimerCollaborateur(collaborateur: Collaborateur) {
    const identifiant = collaborateur.identifiant;
    this.collaborateurApiService.supprimerCollaborateur({identifiant}).toPromise()
      .then(() => this.notificationService.success({titre: 'Succès', message: `Collaborateur ${collaborateur.identifiant} supprimé !`}))
      .then(() => this.majCollaborateurs());
  }
}
