import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InicioComponent } from './components/inicio/inicio.component';
import { HeaderPublicoComponent } from './components/header-publico/header-publico.component';
import { CrearUserComponent } from './components/crear-user/crear-user.component';
import { RecuperarPasswordComponent } from './components/recuperar-password/recuperar-password.component';

@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    HeaderPublicoComponent,
    CrearUserComponent,
    RecuperarPasswordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
