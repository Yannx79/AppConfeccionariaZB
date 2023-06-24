package com.nk.models.dto;

import java.io.Serializable;

public class InsumoDTO implements Serializable {

    // attributes
    private int idInsumo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private int estado;
    private String fechaInserccion;
    private String fechaActualizacion;
    private String fechaEliminacion;
    private double descuento;

    // constructor
    public InsumoDTO() {
    }

    // getters and setters
    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFechaInserccion() {
        return fechaInserccion;
    }

    public void setFechaInserccion(String fechaInserccion) {
        this.fechaInserccion = fechaInserccion;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getFechaEliminacion() {
        return fechaEliminacion;
    }

    public void setFechaEliminacion(String fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "InsumoDTO{" + "idInsumo=" + idInsumo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock + ", estado=" + estado + ", fechaInserccion=" + fechaInserccion + ", fechaActualizacion=" + fechaActualizacion + ", fechaEliminacion=" + fechaEliminacion + ", descuento=" + descuento + '}';
    }

}
