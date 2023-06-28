package com.nk.models.dto;

import java.io.serializable;

public class ClienteDTO implements Serializable {

//atributes
    private int idCliente;
    private String nombres;
    private String apPaterno;
    private String apMaterno;
    private String dni;
    private String telefono;
    private String fInsercion;
    private String fActualizacion;
    private String fEliminacion;
    private int estado;

//constructor
    public ClienteDTO() {
    }
//getters and setters

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getfInsercion() {
        return fInsercion;
    }

    public void setfInsercion(String fInsercion) {
        this.fInsercion = fInsercion;
    }

    public String getfActualizacion() {
        return fActualizacion;
    }

    public void setfActualizacion(String fActualizacion) {
        this.fActualizacion = fActualizacion;
    }

    public String getfEliminacion() {
        return fEliminacion;
    }

    public void setfEliminacion(String fEliminacion) {
        this.fEliminacion = fEliminacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    @Override
    public String toString() {
        return "ClienteDTO{" + "idCliente=" + idCliente + ", nombres=" + nombres + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno + ", dni=" + dni + ", telefono=" + telefono + ", fInsercion=" + fInsercion + ", fActualizacion=" + fActualizacion + ", fEliminacion=" + fEliminacion + ", estado=" + estado + '}';
    }

}
