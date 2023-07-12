package com.nk.models.dto;

import java.io.Serializable;

public class VentaDTO implements Serializable {

    //atributos
    private int id_venta;
    private int id_usuario;
    private int id_cliente;
    private double total;
    private String fecha;
    private double impuesto;
    private int estado;

    //Constructor
    public VentaDTO() {
    }

    //Getters y setters
    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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
        return "VentaDTO{" + "id_venta=" + id_venta + ", id_usuario=" + id_usuario + ", id_cliente=" + id_cliente + ", total=" + total + ", fecha=" + fecha + ", impuesto=" + impuesto + ", estado=" + estado + '}';
    }

    public Object[] Registro() {
        Object[] fila = {id_venta, id_usuario, id_cliente, total, fecha, impuesto, estado};
        return fila;
    }
}
