package com.evaluacion.servidor.controllers;

import java.util.ArrayList;

import com.evaluacion.servidor.models.UserModel;
import com.evaluacion.servidor.services.UserService;
import com.evaluacion.servidor.tools.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<user> obtenerUsuarios(){
        ArrayList<UserModel> listaUsuarios =  userService.obtenerUsuarios();
        ArrayList<user> listaDatosUsuarios = new ArrayList<user>();
        for(UserModel elemento :listaUsuarios){
            listaDatosUsuarios.add(new user(elemento.getId_usuario(),elemento.getUser_name(), elemento.getFirst_name(), elemento.getLast_name(), elemento.getLocation(), elemento.getRol()));
        }
        //return userService.obtenerUsuarios();
        return listaDatosUsuarios;
    }
    

    @PostMapping()
    public user guardarUsuario(@RequestBody UserModel usuario){
        UserModel nuevoUsuario = this.userService.guardarUsuario(usuario);
        //return "{\"nombre\": "+ " \""+ nuevoUsuario.getFirst_name() + "\"}";
        user usuarioDatos = new user(nuevoUsuario.getId_usuario(),nuevoUsuario.getUser_name(), nuevoUsuario.getFirst_name(), nuevoUsuario.getLast_name(), nuevoUsuario.getLocation(), nuevoUsuario.getRol());
        return usuarioDatos;
        

    }
}
