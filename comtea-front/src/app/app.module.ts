import {NgModule, Provider} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {ApiModule} from "../../api/api.module";
import {RoleTournantModule} from "./role-tournant/role-tournant.module";
import {CollaborateurModule} from "./collaborateur/collaborateur.module";
import {ToastModule} from "primeng/toast";
import {ApiInterceptor} from "./api.interceptor";
import {MessageService} from "primeng/api";
import {MessagesModule} from "primeng/messages";
import {MessageModule} from "primeng/message";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {PanelModule} from "primeng/panel";

export const API_INTERCEPTOR_PROVIDER: Provider = {
  provide: HTTP_INTERCEPTORS,
  useClass: ApiInterceptor,
  multi: true
};

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ApiModule.forRoot({rootUrl: ''}),
    RoleTournantModule,
    CollaborateurModule,
    MessagesModule,
    MessageModule,
    ToastModule,
    PanelModule
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
