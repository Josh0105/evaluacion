import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  first_name:any;
  last_name:any;
  location:any;
  username:any;
  rol:any;
  password:any;
  confirmNewpassword:any;


  constructor(private service: UserService) {
    this.username="";
    this.password="";
   }

  ngOnInit(): void {

  }

  LogIn(){
      //window.alert(this.texto1)
      if((this.username!="")&&(this.password!="")){

          //console.log(json);
          var json = {
              "username" : this.username,
              "password" : this.password
          }
          this.service.postLogin(json).subscribe(
              (res:any)=>{
                  //window.alert(res);
                  //console.log(res);
                  //this.texto2 = res.resultado;
                  if(res.status==1){
                      //window.alert("Logueo correcto");
                      sessionStorage.setItem("username",res.username)
                      window.location.href="consultarNit";
                  }else{
                      window.alert("Error:\n" + res.descripcion);
                  }
              },
              (err)=>{
                  window.alert("Error desconocido");
              }
          )
      }else{
          window.alert("Los campos son obligatorios")
      }
  }


}
