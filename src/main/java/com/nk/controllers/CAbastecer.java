package com.nk.controllers;

import com.nk.views.VAbastecer;
import com.nk.models.dto.InsumoDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CAbastecer implements ActionListener{
    //frame
    VAbastecer frame;
    //Clase de tabla
    InsumoDTO insDTO;    
    //Lista de la clase
    List<InsumoDTO> L_insumos = null;
    
    DefaultTableModel modelo = null;
    public CAbastecer (VAbastecer vista){
        frame = vista;
        AgregarBotones(frame);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    public void AgregarBotones(VAbastecer vista){
        frame.btnActualizar.addActionListener(this);
        frame.btnConsultar.addActionListener(this);
        frame.btnEliminar.addActionListener(this);
        frame.btnListar.addActionListener(this);
        frame.btnRegistrar.addActionListener(this);
    }
    
    public DefaultTableModel PonerCabeceras(JTable tabla){
        String[] titulos={"Id Insumo","Nombre","Descripción","Precio",
                        "Stock","Estado","F. Inserción","F. Actualización",
                        "F. Eliminación","Descuento"};
        DefaultTableModel modelo= new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
        return modelo;
    }

}
