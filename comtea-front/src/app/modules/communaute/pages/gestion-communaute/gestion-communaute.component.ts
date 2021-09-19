import {Component, OnInit} from '@angular/core';
import {CommunauteService} from "../../services/communaute.service";
import {Communaute} from "../../../../../../api/models/communaute";

@Component({
  selector: 'app-gestion-communaute',
  templateUrl: './gestion-communaute.component.html'
})
export class GestionCommunauteComponent implements OnInit {
  communautes: Array<Communaute> = [];

  constructor(private communauteService: CommunauteService) {
  }

  ngOnInit(): void {
    this.communauteService.communautes.subscribe(value => this.communautes = value)
    this.communauteService.majCommunautes();
  }

  supprimer(communaute: any) {

  }
}
