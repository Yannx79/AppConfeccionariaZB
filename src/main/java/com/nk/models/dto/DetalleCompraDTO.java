package com.nk.models.dto;

import java.io.Serializable;

public class DetalleCompraDTO {

    //atributos
    private int id_insumo;
    private int id_compra;
    private double subtotal;
    private int cantidad;
    private int estado;
    
    //Constructor
    public DetalleCompraDTO() {
    }

    public int getId_insumo() {
        return id_insumo;
    }

    public void setId_insumo(int id_insumo) {
        this.id_insumo = id_insumo;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "DetalleCompraDTO{" + "id_insumo=" + id_insumo + ", id_compra=" + id_compra + ", subtotal=" + subtotal + ", cantidad=" + cantidad + ", estado=" + estado + '}';
    }
    
    
}
