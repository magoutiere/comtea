import {Component, OnInit} from '@angular/core';
import {RoleTournantApiService} from "../../../../../api/services/role-tournant-api.service";

@Component({
  selector: 'app-historique-election',
  templateUrl: './historique-election.component.html',
  styleUrls: ['./historique-election.component.css']
})
export class HistoriqueElectionComponent implements OnInit {

  constructor(private roleTournantApiService: RoleTournantApiService) {
  }

  ngOnInit(): void {
    this.roleTournantApiService.historique({role: 'cafe'})
      .toPromise()
      .then(value => console.log(value));
  }

}
