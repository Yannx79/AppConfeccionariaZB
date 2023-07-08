package com.nk.app;

import com.nk.controllers.CMenu;
import com.nk.views.VMenu;

public class App {
    
    private static VMenu vista;
    private static CMenu controlador;
    
    public static void main(String[] args) {
        vista = new VMenu();
        controlador = new CMenu(vista);
    }
    
}
