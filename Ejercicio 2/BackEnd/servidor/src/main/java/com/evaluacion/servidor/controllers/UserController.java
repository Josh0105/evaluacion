package com.evaluacion.servidor.controllers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

import com.evaluacion.servidor.models.UserModel;
import com.evaluacion.servidor.services.UserService;
import com.evaluacion.servidor.tools.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<user> obtenerUsuarios(){
        ArrayList<UserModel> listaUsuarios =  userService.obtenerUsuarios();
        //creamos una lista de la clase users, para devolver datos sin contraseñas
        ArrayList<user> listaDatosUsuarios = new ArrayList<user>();
        for(UserModel elemento :listaUsuarios){
            listaDatosUsuarios.add(new user(elemento.getId_usuario(),elemento.getUsername(), elemento.getFirst_name(), elemento.getLast_name(), elemento.getLocation(), elemento.getRol()));
        }
        //return userService.obtenerUsuarios();
        return listaDatosUsuarios;
    }
    
    @PostMapping()
    public user guardarUsuario(@RequestBody UserModel usuario){
        UserModel nuevoUsuario = this.userService.guardarUsuario(usuario);
        //return "{\"nombre\": "+ " \""+ nuevoUsuario.getFirst_name() + "\"}";
        user usuarioDatos = new user(nuevoUsuario.getId_usuario(),nuevoUsuario.getUsername(), nuevoUsuario.getFirst_name(), nuevoUsuario.getLast_name(), nuevoUsuario.getLocation(), nuevoUsuario.getRol());
        return usuarioDatos;
    }

    @GetMapping(path ="/login")
    public user obtenerUsuarioPorUserName(@RequestParam("username") String user_name,@RequestParam("password") String password){
        UserModel nuevoUsuario = this.userService.obtenerPorUserName(user_name);
        //return "{\"nombre\": "+ " \""+ nuevoUsuario.getFirst_name() + "\"}";
        user usuarioDatos;
        try {
            usuarioDatos = new user(nuevoUsuario.getId_usuario(),nuevoUsuario.getUsername(), nuevoUsuario.getFirst_name(), nuevoUsuario.getLast_name(), nuevoUsuario.getLocation(), nuevoUsuario.getRol());
            if(nuevoUsuario.getPassword().equals(getSHA256(password))){
                System.out.println("logeo correcto");
                return usuarioDatos;
            }else{
                System.out.println("logeo incorrecto");
                usuarioDatos = null;
                return usuarioDatos;
            }
        } catch (Exception e) {
            usuarioDatos = null;
            return usuarioDatos;
        }
        //return usuarioDatos;
        //return this.userService.obtenerPorUserName(user_name);
    }



    public String getSHA256(String input){
        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return toReturn;
    }
    
}
