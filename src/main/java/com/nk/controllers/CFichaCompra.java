package com.nk.controllers;

import com.nk.views.VFichaCompra;
import com.nk.models.dto.CompraDTO;
import com.nk.models.bo.CompraBO;
import com.nk.models.dao.CompraDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CFichaCompra implements ActionListener {
    //frame
    VFichaCompra frame;
    //Clase de tabla
    CompraDTO comDTO;
    CompraBO comBO;
    CompraDAO comDAO;
    //Lista de la clase
    List<CompraDTO> L_compras = null;
    //Modelo de tabla
    DefaultTableModel modelo = null;
    //variable auxiliar
    int codCompra;
    
    public CFichaCompra(VFichaCompra vista){
        frame = vista;
        AgregarBotones(frame);
        frame.btnActualizar.setEnabled(false);
        frame.btnEliminar.setEnabled(false);
        modelo = PonerCabeceras(frame.tblListaCompras);
        comBO = new CompraBO();
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    public void AgregarBotones(VFichaCompra vista){
        vista.btnConsultar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
    }
    
    public DefaultTableModel PonerCabeceras(JTable tabla){
        String[] titulos={"Id Compra","ID Proveedor","ID Usuario","Total",
                        "Fecha","Impuesto","Estado"};
        DefaultTableModel modelo= new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
        return modelo;
    }
    

    
    
}
