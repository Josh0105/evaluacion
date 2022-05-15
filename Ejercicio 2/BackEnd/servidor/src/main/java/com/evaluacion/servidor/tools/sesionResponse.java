package com.evaluacion.servidor.tools;

public class sesionResponse {
    private int status;
    private String descripcion;
    private String username;
    
    public sesionResponse() {
        this.status = -1;
        this.descripcion = "Error desconocido";
        this.username = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
}
