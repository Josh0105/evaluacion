import { Component, OnInit } from '@angular/core';
import { windowWhen } from 'rxjs';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-crear-user',
  templateUrl: './crear-user.component.html',
  styleUrls: ['./crear-user.component.css']
})
export class CrearUserComponent implements OnInit {
  first_name:any;
  last_name:any;
  location:any;
  username:any;
  rol:any;
  password:any;
  confirmPasword:any;


  constructor(private service: UserService) {
    this.first_name="";
    this.last_name="";
    this.location="";
    this.username="";
    this.rol="admin";
    this.password="";
    this.confirmPasword="";
   }

  ngOnInit(): void {

  }

  Registrar(){
      //window.alert(this.texto1)
      if((this.first_name!="")&&(this.last_name!="")&&(this.location!="")&&(this.username!="")&&(this.rol!="")&&(this.password!="")&&(this.confirmPasword!="")){
          if(this.password==this.confirmPasword){
              var json = {
                  "first_name": this.first_name,
                  "last_name" : this.last_name,
                  "location" : this.location,
                  "username" : this.username,
                  "rol" : this.rol,
                  "password" : this.password

              }
          //console.log(json);
          
          this.service.setUsuario(json).subscribe(
              (res:any)=>{
                  //window.alert(res);
                  //console.log(res);
                  //this.texto2 = res.resultado;
                  if(res.status==1){
                      window.alert("Usuario creado Correctamente");
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
              window.alert("Contraseñas no coinciden")
          }
      }else{
          window.alert("Todos los campos son obligatorios")
      }
  }


}
