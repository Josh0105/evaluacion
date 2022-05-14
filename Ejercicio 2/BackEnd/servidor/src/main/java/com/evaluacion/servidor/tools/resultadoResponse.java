package com.evaluacion.servidor.tools;

public class resultadoResponse {
    private int status;
    private String descripcion;
    
    public resultadoResponse() {
        this.status = -1;
        this.descripcion = "Error desconocido";
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
