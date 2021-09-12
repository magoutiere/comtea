import {NgModule, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ListeCollaborateurComponent} from './components/liste-collaborateur/liste-collaborateur.component';
import {FormAjoutCollaborateurComponent} from './components/form-ajout-collaborateur/form-ajout-collaborateur.component';
import {InputTextModule} from "primeng/inputtext";
import {ButtonModule} from "primeng/button";
import {ReactiveFormsModule} from "@angular/forms";
import {DataViewModule} from "primeng/dataview";
import {CardModule} from "primeng/card";
import {TableModule} from "primeng/table";
import {RippleModule} from "primeng/ripple";
import {PrimeNGConfig} from "primeng/api";

@NgModule({
  declarations: [
    ListeCollaborateurComponent,
    FormAjoutCollaborateurComponent
  ],
  exports: [
    FormAjoutCollaborateurComponent,
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
    RippleModule
  ]
})
export class CollaborateurModule implements OnInit {

  constructor(private primengConfig: PrimeNGConfig) {
  }

  ngOnInit(): void {
    this.primengConfig.ripple = true;
  }
}
