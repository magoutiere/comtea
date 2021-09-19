import {NgModule, Provider} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {ApiModule} from "../../api/api.module";
import {RoleTournantModule} from "./modules/role-tournant/role-tournant.module";
import {CollaborateurModule} from "./modules/collaborateur/collaborateur.module";
import {ToastModule} from "primeng/toast";
import {ApiInterceptor} from "./services/api.interceptor";
import {MessageService} from "primeng/api";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {PanelModule} from "primeng/panel";
import {DividerModule} from "primeng/divider";
import { AppRoutingModule } from './app-routing.module';
import { MenuComponent } from './components/menu/menu.component';
import {MenubarModule} from "primeng/menubar";
import {CommunauteModule} from "./modules/communaute/communaute.module";

export const API_INTERCEPTOR_PROVIDER: Provider = {
  provide: HTTP_INTERCEPTORS,
  useClass: ApiInterceptor,
  multi: true
};

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ApiModule.forRoot({rootUrl: ''}),
    RoleTournantModule,
    CollaborateurModule,
    CommunauteModule,
    ToastModule,
    PanelModule,
    DividerModule,
    AppRoutingModule,
    MenubarModule
  ],
  providers: [
    ApiInterceptor,
    MessageService,
    API_INTERCEPTOR_PROVIDER
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
