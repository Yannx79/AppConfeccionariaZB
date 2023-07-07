package com.nk.models.dto;

import java.io.Serializable;

public class ProveedorDTO implements Serializable {
//atributes
    private int idProveedor ;
    private String nombres;
    private String apPaterno;
    private String apMaterno;
    private String ruc;
    private String dni;
    private String telefono;
    private String fInsercion;
    private String fActualizacion;
    private String fEliminacion;
    private int estado;
    
    //constructor
    public ProveedorDTO(){
    }
    
    //getters and setters

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
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
        return "ProveedorDTO{" + "idProveedor  =" + idProveedor   + ", nombres=" + nombres + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno + ", ruc=" + ruc + ", dni=" + dni + ", telefono=" + telefono + ", fInsercion=" + fInsercion + ", fActualizacion=" + fActualizacion + ", fEliminacion=" + fEliminacion + ", estado=" + estado + '}';
    }
           public Object[] Registro(){
     Object[] fila = {idProveedor,nombres,apPaterno,apMaterno,ruc,dni,telefono,
                     fInsercion,fActualizacion,fEliminacion,
                     estado};
     return fila;
    }
    
}
