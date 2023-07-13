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
import com.nk.models.utilities.Mensaje;
import com.nk.views.VAbastecer;
import com.nk.views.VCompras;
import com.nk.views.VFichaCompra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

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
    List<DetalleCompraDTO> listDetalleCompra = new LinkedList<>();

    VCompras view;
    
    //variable auxiliar
    int idCom;
    double acuPrecio;

    public CCompras(VCompras view) {
        this.view = view;
        this.builder();
        idCom = UltimoID();
        this.view.btnAgregar.setEnabled(false);
        this.view.btnComprar.setEnabled(false);
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

        //listDetalleCompra = new LinkedList<>();
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
            //this.actionPerformedAgregar();
            this.Agregar();
        } else if (e.getSource() == view.btnComprar) {
            //this.actionPerformedComprar();
            this.Comprar();
        } else if (e.getSource() == view.btnRegistrar) {
            this.actionPerformedRegistrar();
        } else if (e.getSource() == view.btnVerCompras) {
            actionPerformedVerCompras();
        } else if (e.getSource() == view.btnVerInsumos) {
            this.actionPerformedVerInsumos();
        }
    }

    private void actionPerformedVerCompras() {
        VFichaCompra vFichaCompra = new VFichaCompra();
        CFichaCompra cFichaCompra = new CFichaCompra(vFichaCompra);
        view.moveToBack();
        Desktop.agregarAlDesktop(CMenu.vista.desktopMenu, vFichaCompra);
    }

    private void actionPerformedVerInsumos() {
        VAbastecer vAbastecer = new VAbastecer();
        CAbastecer cAbastecer = new CAbastecer(vAbastecer);
        view.moveToBack();
        Desktop.agregarAlDesktop(CMenu.vista.desktopMenu, vAbastecer);

    }

    private void actionPerformedRegistrar() {
        int idUser = Integer.parseInt(view.txt_IdUsuario.getText());
        int idSupplier = Integer.parseInt(view.txt_IdProveedor.getText());

        compraDTO.setId_usuario(idUser);
        compraDTO.setId_proveedor(idSupplier);

        view.btnRegistrar.setEnabled(false);
//        view.txt_IdUsuario.setEnabled(false);
//        view.txt_IdProveedor.setEnabled(false);
        cleanInputs(1);
        this.view.btnAgregar.setEnabled(true);
        Mensaje.mostrar("Se registros los datos del Proveedor y Usuario Exitosamente");
    }

   /* private void actionPerformedComprar() {
        compraBO.registrar(compraDTO);
        listDetalleCompra.stream().map(x -> detalleCompraBO.registrar(x));
        
        listDetalleCompra.clear();
        compraDTO = new CompraDTO();
        
        view.btnRegistrar.setEnabled(true);
        Mensaje.mostrar("Se registro existosamente la compra");
    }

    private void actionPerformedAgregar() {
        DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO();

        int idInsumo = Integer.parseInt(view.txt_IdInsumo.getText());
        int cantidad = Integer.parseInt(view.txtCantidad.getText());
        double precio = Double.parseDouble(view.txtPrecio.getText());

        detalleCompraDTO.setCantidad(cantidad);
        detalleCompraDTO.setId_insumo(idInsumo);
        if (compraBO.listar().size() != 0) {
            detalleCompraDTO.setId_compra(((LinkedList<CompraDTO>) compraBO.listar()).getLast().getId_compra() + 1);
        } else {
            detalleCompraDTO.setId_compra(1);
        }
        
        listDetalleCompra.add(detalleCompraDTO);
        cleanInputs(2);
    }*/
    
    private void Agregar(){
        DetalleCompraDTO detcom = new DetalleCompraDTO();
        detcom.setId_compra(idCom);
        detcom.setId_insumo(Integer.parseInt(view.txt_IdInsumo.getText()));
        detcom.setCantidad(Integer.parseInt(view.txtCantidad.getText()));
        detcom.setSubtotal((Double.parseDouble(view.txtPrecio.getText()))*
                (Integer.parseInt(view.txtCantidad.getText())));
        detcom.setEstado(1);
        listDetalleCompra.add(detcom);
        acuPrecio+=(Double.parseDouble(view.txtPrecio.getText())*
                Integer.parseInt(view.txtCantidad.getText()));
        cleanInputs(2);
        int opc = JOptionPane.showConfirmDialog(null,"¿Desea registrar otro pedido?",
                                                    "Pedido",JOptionPane.YES_NO_OPTION);
            switch(opc){
                case 0: cleanInputs(2);break;
                case 1: this.view.btnAgregar.setEnabled(false);
                        this.view.btnComprar.setEnabled(true);
                        cleanInputs(2);break;
            }
    }
    
    private void Comprar(){
        compraDTO.setTotal(acuPrecio);
        compraBO.registrar(compraDTO);
        for(int i=0;i<listDetalleCompra.size();i++){
            detalleCompraBO.registrar(listDetalleCompra.get(i));
        }
        acuPrecio=0;
        listDetalleCompra.clear();
        this.view.btnRegistrar.setEnabled(true);
        this.view.btnAgregar.setEnabled(true);
        this.view.btnComprar.setEnabled(false);
        Mensaje.mostrar("Se registro existosamente la compra");
    }
    
    
    private void cleanInputs(int option) {
        switch (option) {
            case 1: {
                view.txt_IdUsuario.setText("");
                view.txt_IdProveedor.setText("");
                view.txt_IdInsumo.requestFocus();
            }
            case 2: {
                view.txt_IdInsumo.setText("");
                view.txtCantidad.setText("");
                view.txtPrecio.setText("");
                view.txt_IdInsumo.requestFocus();
            }
            default: {

            }
        }
    }
    
    public int UltimoID(){
        int id;
        if (compraBO.listar().size() != 0) {
            id =((LinkedList<CompraDTO>) compraBO.listar()).getLast().getId_compra() + 1;
        } else {
            return 1;
        }
        return id;
    }

}
