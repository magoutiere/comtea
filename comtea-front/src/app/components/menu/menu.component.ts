import {Component, OnInit} from '@angular/core';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  items: MenuItem[] = [];

  constructor() {
  }

  ngOnInit(): void {
    this.items = [
      {label: 'Collaborateurs', routerLink: 'collaborateurs'},
      {label: 'Rôles tournants', routerLink: 'roles-tournants'},
      {label: 'Communautées', routerLink: 'communautes'}
    ]
  }

}
