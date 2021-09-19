import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {GestionCommunauteComponent} from './pages/gestion-communaute/gestion-communaute.component';
import {TableModule} from "primeng/table";
import {ButtonModule} from "primeng/button";
import {PanelModule} from "primeng/panel";
import {ReactiveFormsModule} from "@angular/forms";
import {InputTextModule} from "primeng/inputtext";


@NgModule({
  declarations: [
    GestionCommunauteComponent
  ],
  imports: [
    CommonModule,
    TableModule,
    ButtonModule,
    PanelModule,
    ReactiveFormsModule,
    InputTextModule
  ]
})
export class CommunauteModule {
}
