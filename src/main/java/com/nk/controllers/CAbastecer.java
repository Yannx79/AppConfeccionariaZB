package com.nk.controllers;

import com.nk.views.VAbastecer;
import com.nk.models.dto.InsumoDTO;
import com.nk.models.bo.InsumoBO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CAbastecer implements ActionListener{
    //frame
    VAbastecer frame;
    //Clase de tabla
    InsumoDTO insDTO;
    InsumoBO insBO;
    //Lista de la clase
    List<InsumoDTO> L_insumos = null;
    //Modelo de tabla
    DefaultTableModel modelo = null;
    
    //Constuctor de controlador
    public CAbastecer (VAbastecer vista){
        frame = vista;
        AgregarBotones(frame);
        modelo = PonerCabeceras(frame.tblListaInsumos);
        insBO = new InsumoBO();
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frame.btnRegistrar){
            insDTO = new InsumoDTO();
            Registrar(insDTO,insBO);
        }
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
    
    public void Mensaje (String men){
        JOptionPane.showMessageDialog(null, men);
    }
    
    public void Registrar(InsumoDTO dto, InsumoBO bo){
        dto.setNombre(frame.txtNombre.getText());
        dto.setDescripcion(frame.txtDescripcion.getText());
        dto.setPrecio(Double.parseDouble(frame.txtPrecio.getText()));
        dto.setStock(Integer.parseInt(frame.txtStock.getText()));
        dto.setEstado(1);
        dto.setDescuento(Double.parseDouble(frame.txtDescuento.getText()));
        bo.registrar(insDTO);  
        Mensaje("Insumo registrado");
    }

}
