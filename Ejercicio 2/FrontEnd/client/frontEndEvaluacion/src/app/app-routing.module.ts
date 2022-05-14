import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrearUserComponent } from './components/crear-user/crear-user.component';
import { InicioComponent } from './components/inicio/inicio.component';
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
];




@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
