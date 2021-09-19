import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {Collaborateur} from "../../../../../../api/models/collaborateur";
import {CollaborateurService} from "../../services/collaborateur.service";

@Component({
  selector: 'app-ajout-collaborateur',
  templateUrl: './ajout-collaborateur.component.html'
})
export class AjoutCollaborateurComponent implements OnInit {
  nouveauCollaborateurForm = new FormGroup({
    identifiant: new FormControl('')
  })

  constructor(private collaborateurService: CollaborateurService) {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    const collaborateur: Collaborateur = this.nouveauCollaborateurForm.value;
    this.collaborateurService.creerCollaborateur(collaborateur)
      .then(() => this.nouveauCollaborateurForm.reset())
      .catch(() => {
      });
  }
}
