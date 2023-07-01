package com.nk.controllers;

import com.nk.models.dto.ClienteDTO;
import com.nk.models.dto.UsuarioDTO;
import com.nk.models.utilities.Desktop;
import com.nk.views.VLogin;
import com.nk.views.VMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class CMenu implements ActionListener {

    public static VMenu vista;
    public static UsuarioDTO usuarioDTO;

    public CMenu(VMenu vmenu) {
        this.vista = vmenu;
        builder();
    }

    public void construirVista() {
        this.vista.setVisible(true);
        this.vista.setTitle("Confecciones 'Z y B'");
        this.vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void inicializarObjetos() {
        usuarioDTO = new UsuarioDTO();
    }
    
    public void builder() {
        this.inicializarObjetos();
        this.addAllListener();
        this.construirVista();
        this.actionPerformedLogin();
    }
    
    public void addAllListener() { 
        this.vista.jmiAbastecer.addActionListener(this);
        this.vista.jmiCliente.addActionListener(this);
        this.vista.jmiMovimientosInternos.addActionListener(this);
        this.vista.jmiProveedor.addActionListener(this);
        this.vista.jmiVenta.addActionListener(this);
        this.vista.miLogin.addActionListener(this);
        this.vista.miLogout.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.jmiVenta) {
            this.actionPerformedVenta();
        } else if (e.getSource() == this.vista.jmiProveedor) {
            this.actionPerformedProveedor();
        } else if (e.getSource() == this.vista.jmiMovimientosInternos) {
            this.actionPerformedMovimientosInternos();
        } else if (e.getSource() == this.vista.jmiCliente) {
            this.actionPerformedCliente();
        } else if (e.getSource() == this.vista.jmiAbastecer) {
            this.actionPerformedAbastecer();
        } else if (e.getSource() == this.vista.miLogin) {
            this.actionPerformedLogin();
        } else if (e.getSource() == this.vista.miLogout) {
            this.actionPerformedLogout();
        }
    }

    private void actionPerformedVenta() {

    }

    private void actionPerformedProveedor() {

    }

    private void actionPerformedMovimientosInternos() {

    }

    private void actionPerformedCliente() {

    }

    private void actionPerformedAbastecer() {

    }

    private void actionPerformedLogin() {
        VLogin vLogin = new VLogin();
        CLogin cLogin = new CLogin(vLogin);
        Desktop.agregarAlDesktop(this.vista.desktopMenu, vLogin);
    }

    private void actionPerformedLogout() {

    }

}
