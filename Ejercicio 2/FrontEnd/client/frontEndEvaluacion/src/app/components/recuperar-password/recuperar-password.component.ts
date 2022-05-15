import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-recuperar-password',
  templateUrl: './recuperar-password.component.html',
  styleUrls: ['./recuperar-password.component.css']
})
export class RecuperarPasswordComponent implements OnInit {
  first_name:any;
  last_name:any;
  location:any;
  username:any;
  rol:any;
  newPassword:any;
  confirmNewpassword:any;


  constructor(private service: UserService) {
    this.first_name="";
    this.last_name="";
    this.location="";
    this.username="";
    this.rol="admin";
    this.newPassword="";
    this.confirmNewpassword="";
   }

  ngOnInit(): void {

  }

  Registrar(){
      //window.alert(this.texto1)
      if((this.first_name!="")&&(this.last_name!="")&&(this.location!="")&&(this.username!="")&&(this.rol!="")&&(this.newPassword!="")&&(this.confirmNewpassword!="")){
          if(this.newPassword==this.confirmNewpassword){
              var json = {
                  "first_name": this.first_name,
                  "last_name" : this.last_name,
                  "location" : this.location,
                  "username" : this.username,
                  "rol" : this.rol,
                  "newPassword" : this.newPassword

              }
          //console.log(json);
          
          this.service.RecuperarPassword(json).subscribe(
              (res:any)=>{
                  //window.alert(res);
                  //console.log(res);
                  //this.texto2 = res.resultado;
                  if(res.status==1){
                      window.alert("Contraseña cambiada correctamente");
                      window.location.href="inicio";
                  }else{
                      window.alert("Error:\n" + res.descripcion);
                  }
              },
              (err)=>{
                  window.alert("Error desconocido");
              }
          )
          }else{
              window.alert("Los campos de contraseña no coinciden")
          }
      }else{
          window.alert("Todos los campos son obligatorios")
      }
  }


}
