package com.nk.controllers;

public abstract class IController {

    // menu del controlador
    public void operar(int state) {
        switch(state) {
            case 1 -> registrar();
            case 2 -> buscar();
            case 3 -> actualizar();
            case 4 -> eliminar();
            default -> System.out.println("Opcion Incorrecta");
        }
    }
    
    // registra un dto y actualiza la lista
    public abstract void registrar();

    // busca un dto mediante un id y lo muestra
    public abstract void buscar();

    // lista en un jtable
    public abstract void listar();

    // actualiza los datos y actualiza la lista
    public abstract void actualizar();

    // cambia el estado a 0 y actualiza la lista
    public abstract void eliminar();

    // limpia todos los campos
    public abstract void limpiar();

    // captura toda la informacion de la vista para armar un dto
    public abstract void capturarDatos();

}
