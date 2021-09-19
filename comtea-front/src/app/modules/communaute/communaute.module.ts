import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {GestionCommunauteComponent} from './pages/gestion-communaute/gestion-communaute.component';
import {TableModule} from "primeng/table";
import {ButtonModule} from "primeng/button";


@NgModule({
  declarations: [
    GestionCommunauteComponent
  ],
  imports: [
    CommonModule,
    TableModule,
    ButtonModule
  ]
})
export class CommunauteModule {
}
