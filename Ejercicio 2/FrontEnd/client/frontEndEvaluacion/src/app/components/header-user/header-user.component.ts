import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header-user',
  templateUrl: './header-user.component.html',
  styleUrls: ['./header-user.component.css']
})
export class HeaderUserComponent implements OnInit {

  activeConsultar:string;
  activeListar:string;
  activeCarga:string;
  user:string|undefined;



  constructor() {
    this.activeConsultar = "";
    this.activeListar = "",
    this.activeCarga = ""
    this.user = "No user"
   }

  ngOnInit(): void {
    try {
      this.user=sessionStorage.getItem('username')?.toString()
      if(this.user == undefined||this.user == null){
        window.location.href="inicio";
      }
    } catch (error) {
      window.location.href="inicio";
    }
    if(window.location.pathname=='/consultarNit'){
      this.activeConsultar ="active"
    }
    if(window.location.pathname=='/listarNit'){
      this.activeListar ="active"
    }
    if(window.location.pathname=='/cargaMasiva'){
      this.activeCarga ="active"
    }
  }

  LogOut(){
    sessionStorage.clear();
    window.location.href="inicio";
  }

}
