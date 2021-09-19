import {Component, OnInit} from '@angular/core';
import {CommunauteService} from "../../services/communaute.service";
import {Communaute} from "../../../../../../api/models/communaute";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-gestion-communaute',
  templateUrl: './gestion-communaute.component.html'
})
export class GestionCommunauteComponent implements OnInit {
  communautes: Array<Communaute> = [];

  formNouveau = new FormGroup({
    identifiant: new FormControl(''),
    nom: new FormControl('')
  })

  constructor(private communauteService: CommunauteService) {
  }

  ngOnInit(): void {
    this.communauteService.communautes.subscribe(value => this.communautes = value)
    this.communauteService.majCommunautes();
  }

  supprimer(communaute: Communaute) {
    this.communauteService.supprimerCommunaute(communaute);
  }

  creer() {
    const communaute: Communaute = this.formNouveau.value;
    this.communauteService.creerCommunaute(communaute)
      .then(() => this.formNouveau.reset())
      .catch(() => {
      });
  }
}
