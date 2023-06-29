package com.nk.models.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

// attributes
    private int idUsuario;
    private String nombres;
    private String apPaterno;
    private String apMaterno;
    private String usuario;
    private String pass;

    // constructor
    public UsuarioDTO() {
    }

    //getters and setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "idUsuario=" + idUsuario + ", nombres=" + nombres + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno + ", usuario=" + usuario + ", pass=" + pass + '}';
    }

}
