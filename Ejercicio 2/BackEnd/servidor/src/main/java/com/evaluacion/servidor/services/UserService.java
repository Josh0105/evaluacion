package com.evaluacion.servidor.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

import com.evaluacion.servidor.models.UserModel;
import com.evaluacion.servidor.repositories.UserRepositorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepositorie userRepositorie;

    public ArrayList<UserModel> obtenerUsuarios(){
        return (ArrayList<UserModel>) userRepositorie.findAll();
    }

    public UserModel guardarUsuario(UserModel usuario){
        //System.out.println(usuario.getPassword()); 
        usuario.setPassword(getSHA256(usuario.getPassword()));
        //System.out.println(usuario.getPassword());        
        return userRepositorie.save(usuario);
    }

    
    public UserModel obtenerPorUserName(String username){
        //userRepositorie.f
        return userRepositorie.findByUsername(username);
    }
    
    public String getSHA256(String input){

        String toReturn = null;
        try {
            //System.out.println("Ingreso al algoritmo");
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
