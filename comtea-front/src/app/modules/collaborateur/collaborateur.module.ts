import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ListeCollaborateurComponent} from './components/liste-collaborateur/liste-collaborateur.component';
import {AjoutCollaborateurComponent} from './components/ajout-collaborateur/ajout-collaborateur.component';
import {InputTextModule} from "primeng/inputtext";
import {ButtonModule} from "primeng/button";
import {ReactiveFormsModule} from "@angular/forms";
import {DataViewModule} from "primeng/dataview";
import {CardModule} from "primeng/card";
import {TableModule} from "primeng/table";
import { GestionCollaborateurComponent } from './pages/gestion-collaborateur/gestion-collaborateur.component';
import {PanelModule} from "primeng/panel";
import {DividerModule} from "primeng/divider";

@NgModule({
  declarations: [
    ListeCollaborateurComponent,
    AjoutCollaborateurComponent,
    GestionCollaborateurComponent
  ],
  exports: [
    AjoutCollaborateurComponent,
    ListeCollaborateurComponent
  ],
  imports: [
    CommonModule,
    InputTextModule,
    ButtonModule,
    ReactiveFormsModule,
    DataViewModule,
    CardModule,
    TableModule,
    PanelModule,
    DividerModule
  ]
})
export class CollaborateurModule {

  constructor() {
  }
}
