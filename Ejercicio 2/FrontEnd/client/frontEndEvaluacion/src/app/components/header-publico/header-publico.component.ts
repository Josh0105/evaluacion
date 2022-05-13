import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header-publico',
  templateUrl: './header-publico.component.html',
  styleUrls: ['./header-publico.component.css']
})
export class HeaderPublicoComponent implements OnInit {

  activeInicio:string;
  activeCrear:string;
  activeRecuperar:string;
  activeLogIn:string;


  constructor() {
    this.activeInicio = "";
    this.activeCrear = "",
    this.activeRecuperar = "",
    this.activeLogIn = ""
   }

  ngOnInit(): void {
    if(window.location.pathname=='/inicio'){
      this.activeInicio ="active"
    }
    if(window.location.pathname=='/crearUsuario'){
      this.activeCrear ="active"
    }
    if(window.location.pathname=='/recuperarPasword'){
      this.activeRecuperar ="active"
    }
    if(window.location.pathname=='/login'){
      this.activeLogIn ="active"
    }
  }
}
