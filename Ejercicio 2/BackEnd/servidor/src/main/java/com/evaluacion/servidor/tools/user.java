package com.evaluacion.servidor.tools;
//esta clase es solo para manejar los datos sin contraseña

public class user {
    private Long id_usuario;
    private String user_name;
    private String first_name;
    private String last_name;
    private String location;
    private String rol;
    
    public user(Long id_usuario, String user_name, String first_name, String last_name, String location, String rol) {
        this.id_usuario = id_usuario;
        this.user_name = user_name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.location = location;
        this.rol = rol;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }  
    
    
    
}
