import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CargaMasivaComponent } from './components/carga-masiva/carga-masiva.component';
import { ConsultarNitComponent } from './components/consultar-nit/consultar-nit.component';
import { CrearUserComponent } from './components/crear-user/crear-user.component';
import { InicioComponent } from './components/inicio/inicio.component';
import { ListarNitComponent } from './components/listar-nit/listar-nit.component';
import { LoginComponent } from './components/login/login.component';
import { RecuperarPasswordComponent } from './components/recuperar-password/recuperar-password.component';

const routes: Routes = [
  {
    path: 'inicio',
    component: InicioComponent
  },
  {
    path: 'crearUsuario',
    component: CrearUserComponent
  },
  {
    path: 'recuperarPassword',
    component: RecuperarPasswordComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'consultarNit',
    component: ConsultarNitComponent
  },
  {
    path: 'listarNit',
    component: ListarNitComponent
  },
  {
    path: 'cargaMasiva',
    component: CargaMasivaComponent
  }
];




@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
