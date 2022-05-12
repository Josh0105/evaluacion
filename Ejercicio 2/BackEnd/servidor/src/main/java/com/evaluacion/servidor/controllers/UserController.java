package com.evaluacion.servidor.controllers;

import java.util.ArrayList;

import com.evaluacion.servidor.models.UserModel;
import com.evaluacion.servidor.services.UserService;

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
    public ArrayList<UserModel> obtenerUsuarios(){
        return userService.obtenerUsuarios();
    }
    

    @PostMapping()
    public  UserModel guardarUsuario(@RequestBody UserModel usuario){
        return this.userService.guardarUsuario(usuario);
    }
}
