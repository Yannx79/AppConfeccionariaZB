package com.nk.controllers;

import com.nk.models.bo.CompraBO;
import com.nk.models.bo.DetalleCompraBO;
import com.nk.models.bo.InsumoBO;
import com.nk.models.bo.ProveedorBO;
import com.nk.models.bo.UsuarioBO;
import com.nk.models.dao.CompraDAO;
import com.nk.models.dao.DetalleCompraDAO;
import com.nk.models.dao.InsumoDAO;
import com.nk.models.dao.ProveedorDAO;
import com.nk.models.dao.UsuarioDAO;
import com.nk.models.dto.CompraDTO;
import com.nk.models.dto.DetalleCompraDTO;
import com.nk.models.dto.InsumoDTO;
import com.nk.models.utilities.Desktop;
import com.nk.views.VAbastecer;
import com.nk.views.VCompras;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class CCompras implements ActionListener {

    // bo
    UsuarioBO usuarioBO;
    ProveedorBO proveedorBO;
    InsumoBO insumoBO;
    DetalleCompraBO detalleCompraBO;
    CompraBO compraBO;

    // dao
    UsuarioDAO usuarioDAO;
    ProveedorDAO proveedorDAO;
    InsumoDAO insumoDAO;
    DetalleCompraDAO detalleCompraDAO;
    CompraDAO compraDAO;

    // dto
    CompraDTO compraDTO;

    // list
    List<DetalleCompraDTO> listDetalleCompra;
    
    VCompras view;
    
    public CCompras(VCompras view) {
        this.view = view;
        this.builder();
    }
    
    public void builder() {
        this.getInstance();
        this.addAllListeners();
        this.display();
    }
    
    public void getInstance() {
        usuarioBO = new UsuarioBO();
        proveedorBO = new ProveedorBO();
        insumoBO = new InsumoBO();
        detalleCompraBO = new DetalleCompraBO();
        compraBO = new CompraBO();
        
        usuarioDAO = new UsuarioDAO();
        proveedorDAO = new ProveedorDAO();
        insumoDAO = new InsumoDAO();
        detalleCompraDAO = new DetalleCompraDAO();
        compraDAO = new CompraDAO();
        
        usuarioBO.setUsuarioDAO(usuarioDAO);
        proveedorBO.setProveedorDAO(proveedorDAO);
        insumoBO.setInsumoDAO(insumoDAO);
        detalleCompraBO.setDetalleCompraDAO(detalleCompraDAO);
        compraBO.setCompraDAO(compraDAO);
        
        compraDTO = new CompraDTO();
        
        listDetalleCompra = new LinkedList<>();
    }
    
    public void addAllListeners() {
        view.btnAgregar.addActionListener(this);
        view.btnComprar.addActionListener(this);
        view.btnRegistrar.addActionListener(this);
        view.btnVerCompras.addActionListener(this);
        view.btnVerInsumos.addActionListener(this);
    }
    
    public void display() {
        this.view.setVisible(true);
        this.view.setTitle("Compras");
        
        if (compraDTO == null) {
            
        } else {
            
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnAgregar) {
            this.actionPerformedAgregar();
        } else if (e.getSource() == view.btnComprar) {
            this.actionPerformedComprar();
        } else if (e.getSource() == view.btnRegistrar) {
            this.actionPerformedRegistrar();
        } else if (e.getSource() == view.btnVerCompras) {
            
        } else if (e.getSource() == view.btnVerInsumos) {
            
        }
    }
    
    private void actionPerformedVerCompras() {
        
    }
    
    private void actionPerformedVerInsumos() {
         VAbastecer vAbastecer = new VAbastecer();
        CAbastecer cAbastecer = new CAbastecer(vAbastecer);
        Desktop.agregarAlDesktop(CMenu.vista.desktopMenu, vAbastecer);
    
    }
    
    private void actionPerformedRegistrar() {
        int idUser = Integer.parseInt(view.txt_IdUsuario.getText());
        int idSupplier = Integer.parseInt(view.txt_IdProveedor.getText());
        
        compraDTO.setId_usuario(idUser);
        compraDTO.setId_proveedor(idSupplier);

//        view.btnRegistrar.setEnabled(false);
//        view.txt_IdUsuario.setEnabled(false);
//        view.txt_IdProveedor.setEnabled(false);
        cleanInputs(1);
    }
    
    private void actionPerformedComprar() {
        compraBO.registrar(compraDTO);
        listDetalleCompra.stream().map(x -> detalleCompraBO.registrar(x));
        listDetalleCompra.clear();
        compraDTO = new CompraDTO();
    }
    
    private void actionPerformedAgregar() {
        InsumoDTO insumoDTO = new InsumoDTO();
        DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO();
        
        int idInsumo = Integer.parseInt(view.txt_IdInsumo.getText());
        int cantidad = Integer.parseInt(view.txtCantidad.getText());
        double precio = Double.parseDouble(view.txtPrecio.getText());
        
        detalleCompraDTO.setCantidad(cantidad);
        detalleCompraDTO.setId_insumo(idInsumo);
        detalleCompraDTO.setId_compra(((LinkedList<CompraDTO>) compraBO.listar()).getLast().getId_compra() + 1);
        
        listDetalleCompra.add(detalleCompraDTO);
        cleanInputs(2);
    }
    
    private void efectuarLineaCompra() {
        
    }
    
    private void cleanInputs(int option) {
        switch (option) {
            case 1: {
                view.txt_IdUsuario.setText("");
                view.txt_IdProveedor.setText("");
            }
            case 2: {
                view.txt_IdInsumo.setText("");
                view.txtCantidad.setText("");
                view.txtPrecio.setText("");
            }
            default: {
                
            }
        }
    }
    
}
