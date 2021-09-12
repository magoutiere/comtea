import {Injectable} from '@angular/core';
import {CollaborateurApiService} from "../../../api/services/collaborateur-api.service";
import {BehaviorSubject} from "rxjs";
import {Collaborateur} from "../../../api/models";

@Injectable({
  providedIn: 'root'
})
export class CollaborateurService {

  private collaborateurs = new BehaviorSubject(new Array<Collaborateur>());
  collaborateursCourant = this.collaborateurs.asObservable();

  constructor(private collaborateurApiService: CollaborateurApiService) {
  }

  majCollaborateurs() {
    return this.collaborateurApiService.liste().toPromise()
      .then(value => this.collaborateurs.next(value));
  }

  creerCollaborateur(collaborateur: Collaborateur) {
    return this.collaborateurApiService.creer({body: collaborateur}).toPromise()
      .then(() => this.majCollaborateurs());
  }

}
