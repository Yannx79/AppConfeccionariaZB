package com.nk.models.dto;

import java.io.Serializable;

public class DetalleVentaDTO implements Serializable {

    //atributos
    private int id_producto;
    private int id_venta;
    private double subtotal;
    private int cantidad;
    private int estado;

    //Constructor
    public DetalleVentaDTO() {
    }

    //Getters y setters
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
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
        return "DetalleVentaDTO{" + "id_producto=" + id_producto + ", id_venta=" + id_venta + ", subtotal=" + subtotal + ", cantidad=" + cantidad + ", estado=" + estado + '}';
    }

    public Object[] Registro() {
        Object[] fila = {id_producto, id_venta, subtotal, cantidad, estado};
        return fila;
    }
}
