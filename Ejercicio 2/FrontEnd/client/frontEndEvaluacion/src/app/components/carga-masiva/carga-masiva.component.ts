import { JsonpClientBackend } from '@angular/common/http';
import { XmlParser } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-carga-masiva',
  templateUrl: './carga-masiva.component.html',
  styleUrls: ['./carga-masiva.component.css']
})
export class CargaMasivaComponent implements OnInit {
  file:any;
  consola:any;
  textFile:String;

  constructor(private service: UserService) { 
    this.consola = ""
    this.textFile = ""
  }

  ngOnInit(): void {
    try {
      this.consola = sessionStorage.getItem("consola")
      sessionStorage.removeItem('consola')
    } catch (error) {
      this.consola = ""
    }
  }

  //aplicamos calquier cambio de la ruta del archivo
  fileChanged(e:any) { 
    this.file = e.target.files[0]; 
  }

  leerArchivo() {

    if (!this.file) {
      return;
    }
    //si existe archivo seleccionado y click, lo leemos
    let fileReader = new FileReader(); 
    fileReader.onload = (e) => { 
      //window.alert(fileReader.result);
      this.cargarArchivo(fileReader.result); 
    } 
    fileReader.readAsText(this.file); 
    //this.textFile = ""
    //this.fileChanged($event)
  }

  cargarArchivo(contenido:any){
    this.consola=""
    var parser = new DOMParser();
    try {
      var xmlDoc = parser.parseFromString(contenido,"text/xml");
      //console.log(xmlDoc.documentElement)
  
      var listado = xmlDoc.getElementsByTagName("user")
      var listadoUsuarios = []
      
  
      for(var i=0; i<listado.length; i++){
        
        var first_name:any = ""
        var last_name:any = ""
        var location:any = ""
        var username:any = ""
        var password:any = ""
        var rol:any = ""
  
        for(var j=0; j<listado[i].children.length; j++){
          switch (listado[i].children[j].nodeName) {
            case "firstName":
              first_name=listado[i].children[j].textContent?.toString()
              break;
            case "lastName":
              last_name=listado[i].children[j].textContent?.toString()
              break;
            case "location":
              location=listado[i].children[j].textContent?.toString()
              break;
            case "username":
              username=listado[i].children[j].textContent?.toString()
              break;
            case "password":
              password=listado[i].children[j].textContent?.toString()
              break;        
            case "rol":
              rol=listado[i].children[j].textContent?.toString()
              break;        
            default:
              break;
          }
        }
        var json = {
          "first_name" : first_name,
          "last_name" : last_name,
          "location" : location,
          "username" : username,
          "password" : password,
          "rol" : rol,
  
        }
        listadoUsuarios.push(json)  
          //console.log(listado[i].children[j].nodeName)
          //console.log(listado[i].children[j])
      }
      console.log(listadoUsuarios)
      
      this.service.cargaMasiva(listadoUsuarios).subscribe(
        (res:any)=>{
          //window.alert(res);
          console.log(res);
          //this.texto2 = res.resultado;

          for (var k=0; k<res.length;k++){
            var status;
            if(res[k].status==1){
              status="Creado"
            }else{
              status="No Creado"
            }
            this.consola += "username : " + res[k].username +" \n\tResultado: " + status + "\n\tDescripcion: " + res[k].descripcion + "\n"

          }
          sessionStorage.setItem("consola",this.consola)
          window.location.href="cargaMasiva";
        },
          (err)=>{
            window.alert("Error desconocido");
          }
      )      


    } catch (error) {
      window.alert("Error en la lectura del archivo")
    }

  }

}
