package com.evaluacion.servidor.controllers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

import com.evaluacion.servidor.models.UserModel;
import com.evaluacion.servidor.services.UserService;
import com.evaluacion.servidor.tools.resultadoResponse;
import com.evaluacion.servidor.tools.recuperacionRequest;
import com.evaluacion.servidor.tools.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/usuarios")
public class UserController {

    
    @Autowired
    UserService userService;

    /*
    @Autowired
	private coneccionClienteSOAP client;

    @Value("${WSDL.SOAPClient}")
	private String clientEndPoint;

    
    private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

    
    //public void init() throws Exception {
	//	marshaller.setPackagesToScan("com.evaluacion.servidor.com.claro");
	//	marshaller.afterPropertiesSet();
	//}
    */

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
    public resultadoResponse guardarUsuario(@RequestBody UserModel usuario){
        resultadoResponse respuesta = new resultadoResponse();
        UserModel nuevoUsuario = this.userService.obtenerPorUserName(usuario.getUsername());
        if(nuevoUsuario!=null){
            respuesta.setStatus(-3);
            respuesta.setDescripcion("Nombre de usuario ya existente");
        }else{
            nuevoUsuario = this.userService.guardarUsuario(usuario);
            //return "{\"nombre\": "+ " \""+ nuevoUsuario.getFirst_name() + "\"}";
            if(nuevoUsuario!=null){
                respuesta.setStatus(1);
                respuesta.setDescripcion("Usuario Creado Correctamente");
            }else{
                respuesta.setStatus(-2);
                respuesta.setDescripcion("Error en creacion");
            }
        }
        //user usuarioDatos = new user(nuevoUsuario.getId_usuario(),nuevoUsuario.getUsername(), nuevoUsuario.getFirst_name(), nuevoUsuario.getLast_name(), nuevoUsuario.getLocation(), nuevoUsuario.getRol());
        return respuesta;
    }

    /*
    @GetMapping(path ="/nit")
    public void consultarNit() throws Exception{
		marshaller.setPackagesToScan("com.evaluacion.servidor.com.claro");
		marshaller.afterPropertiesSet();
        ValidarNit request = new ValidarNit();
        request.setNit("82901201");
        ValidarNitResponse response = (ValidarNitResponse) client.callWebServices(clientEndPoint, request);
        System.out.println(response);

    }
    */


    @GetMapping(path ="/login")
    public user obtenerUsuarioPorUserName(@RequestParam("username") String username,@RequestParam("password") String password){
        UserModel nuevoUsuario = this.userService.obtenerPorUserName(username);
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
    }

    @PostMapping(path ="/recuperar_password")
    public resultadoResponse recuperarPassword(@RequestBody recuperacionRequest requestRecuperar){
        resultadoResponse respuesta = new resultadoResponse();
        //System.out.println(requestRecuperar);
        UserModel usuarioSolicitado = this.userService.obtenerPorUserName(requestRecuperar.getUsername());
        //System.out.println(usuarioSolicitado.getId_usuario());
        //return "{\"nombre\": "+ " \""+ nuevoUsuario.getFirst_name() + "\"}";
        //user nuevoUsuarioDatos=null;
        try {
            if(usuarioSolicitado!=null){
                if((usuarioSolicitado.getFirst_name().equals(requestRecuperar.getFirst_name()))
                    &&(usuarioSolicitado.getLast_name().equals(requestRecuperar.getLast_name()))
                    &&(usuarioSolicitado.getLocation().equals(requestRecuperar.getLocation()))
                    &&(usuarioSolicitado.getRol().equals(requestRecuperar.getRol()))){

                        usuarioSolicitado.setPassword(requestRecuperar.getNewPassword());
                        usuarioSolicitado = this.userService.guardarUsuario(usuarioSolicitado);
                        
                        //nuevoUsuarioDatos = new user(usuarioSolicitado.getId_usuario(),usuarioSolicitado.getUsername(), usuarioSolicitado.getFirst_name(), usuarioSolicitado.getLast_name(), usuarioSolicitado.getLocation(), usuarioSolicitado.getRol());
                        respuesta.setStatus(1);
                        respuesta.setDescripcion("Constraseña cambiada exitosamente");
                        //return nuevoUsuarioDatos;
                }else{
                    respuesta.setStatus(-2);
                    respuesta.setDescripcion("No coinciden sus datos personales");
                    //nuevoUsuarioDatos = null;
                    //return nuevoUsuarioDatos;
                }
            }else{
                respuesta.setStatus(-3);
                respuesta.setDescripcion("Usuario no existe");                
            }
            return respuesta;
        } catch (Exception e) {
            respuesta.setStatus(-4);
            respuesta.setDescripcion("Error desconocido");
            //nuevoUsuarioDatos = null;
            return respuesta;
        }
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
