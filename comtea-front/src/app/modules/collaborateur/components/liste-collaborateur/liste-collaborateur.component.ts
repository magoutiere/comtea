import {Component, OnInit} from '@angular/core';
import {Collaborateur} from "../../../../../../api/models/collaborateur";
import {CollaborateurService} from "../../services/collaborateur.service";

@Component({
  selector: 'app-liste-collaborateur',
  templateUrl: './liste-collaborateur.component.html',
  styleUrls: ['./liste-collaborateur.component.css']
})
export class ListeCollaborateurComponent implements OnInit {
  collaborateurs: Array<Collaborateur> = [];

  constructor(private collaborateurService: CollaborateurService) {
  }

  ngOnInit(): void {
    this.collaborateurService.collaborateursCourant.subscribe(value => this.collaborateurs = value);
    this.collaborateurService.majCollaborateurs();
  }


  supprimer(collaborateur: Collaborateur) {
    this.collaborateurService.supprimerCollaborateur(collaborateur);
  }
}
