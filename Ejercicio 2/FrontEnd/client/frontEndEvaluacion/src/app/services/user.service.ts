import { HttpClient } from '@angular/common/http';
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

  getLogIn(){
    return this.http.get(`${this.URL}/usuarios/login`);
  }

  setUsuario(json:any){
    return this.http.post(`${this.URL}/usuarios`,json);
  }
}
