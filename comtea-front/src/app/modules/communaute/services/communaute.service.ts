import {Injectable} from '@angular/core';
import {CommunauteApiService} from "../../../../../api/services/communaute-api.service";
import {BehaviorSubject} from "rxjs";
import {Communaute} from "../../../../../api/models/communaute";

@Injectable({
  providedIn: 'root'
})
export class CommunauteService {

  private etat = new BehaviorSubject(new Array<Communaute>());
  communautes = this.etat.asObservable();

  constructor(private communauteApiService: CommunauteApiService) {
  }

  majCommunautes() {
    this.communauteApiService.recupererCommunautes().toPromise()
      .then(communautes => this.etat.next(communautes))
      .catch(() => {
      })
  }

}
