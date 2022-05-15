import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  URL = "http://localhost:8080"
  constructor(private http:HttpClient) { }

  getUsuarios(){
    return this.http.get(`${this.URL}/usuarios`);
  }

  RecuperarPassword(json:any){
    return this.http.post(`${this.URL}/usuarios/recuperar_password`,json);
  }

  postLogin(json:any){
    return this.http.post(`${this.URL}/usuarios/login`,json);
  }

  setUsuario(json:any){
    return this.http.post(`${this.URL}/usuarios`,json);
  }

  cargaMasiva(lista:any){
    return this.http.post(`${this.URL}/usuarios/cargaMasiva`,lista);
  }

}
