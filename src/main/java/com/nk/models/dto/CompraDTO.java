
package com.nk.models.dto;

import java.io.Serializable;

public class CompraDTO implements Serializable {
        // attributes
    private int id_compra;
    private int id_proveedor;
    private int id_usuario;
    private double total;
    private String fecha;
    private double impuesto;
    private int estado;
    
    // constructor
    public CompraDTO() {
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }  

    @Override
    public String toString() {
        return "CompraDTO{" + "id_compra=" + id_compra + ", id_proveedor=" + id_proveedor + ", id_usuario=" + id_usuario + ", total=" + total + ", fecha=" + fecha + ", impuesto=" + impuesto + ", estado=" + estado + '}';
    }
    
    public Object[] Registro(){
     Object[] fila = {id_compra,id_proveedor,id_usuario,total,fecha,impuesto,estado};
     return fila;
    }   

}
