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
import { LoginComponent } from './components/login/login.component';
import { ConsultarNitComponent } from './components/consultar-nit/consultar-nit.component';
import { HeaderUserComponent } from './components/header-user/header-user.component';
import { ListarNitComponent } from './components/listar-nit/listar-nit.component';
import { CargaMasivaComponent } from './components/carga-masiva/carga-masiva.component';

@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    HeaderPublicoComponent,
    CrearUserComponent,
    RecuperarPasswordComponent,
    LoginComponent,
    ConsultarNitComponent,
    HeaderUserComponent,
    ListarNitComponent,
    CargaMasivaComponent
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
