package com.nk.controllers;

import com.nk.views.VAbastecer;
import com.nk.models.dto.InsumoDTO;
import com.nk.models.bo.InsumoBO;
import com.nk.models.dao.InsumoDAO;
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
    InsumoDAO insDAO;
    //Lista de la clase
    List<InsumoDTO> L_insumos = null;
    //Modelo de tabla
    DefaultTableModel modelo = null;
    //variable auxiliar
    int codInsumo;
    
    //Constuctor de controlador
    public CAbastecer (VAbastecer vista){
        frame = vista;
        AgregarBotones(frame);
        frame.btnActualizar.setEnabled(false);
        frame.btnEliminar.setEnabled(false);
        modelo = PonerCabeceras(frame.tblListaInsumos);
        insBO = new InsumoBO();
        frame.setVisible(true);
    }
    
    //Función de botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frame.btnRegistrar){
            insDTO = new InsumoDTO();
            RegistrarInsumo(insDTO,insBO);
            LimpiarEntradas(frame);
            if(frame.tblListaInsumos.getRowCount() != 0){
                Listar(insDTO,insBO);
            }
        }
        if(e.getSource() == frame.btnConsultar){
            insDTO = new InsumoDTO();
            codInsumo = ConsultarInsumo(insDTO,insBO);
            ActivarUPDEL(frame);
        }
        if(e.getSource() == frame.btnListar){
            insDTO = new InsumoDTO();
            Listar(insDTO,insBO);
        }
        if(e.getSource() == frame.btnActualizar){
            insDTO = new InsumoDTO();
            Actualizar(insDTO,insBO);
            if(frame.tblListaInsumos.getRowCount() != 0){
                Listar(insDTO,insBO);
            }
        }
    }
    
    //Métodos auxiliares
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
    
    public void Mensaje (String m){
        JOptionPane.showMessageDialog(null, m);
    }
    
    public void LimpiarEntradas(VAbastecer vista){
        vista.txtNombre.setText("");
        vista.txtDescripcion.setText("");
        vista.txtDescuento.setText("");
        vista.txtPrecio.setText("");
        vista.txtStock.setText("");
        vista.txtNombre.requestFocus();       
    }
    
    public void ActivarUPDEL(VAbastecer vista){
        vista.btnRegistrar.setEnabled(false);
        vista.btnActualizar.setEnabled(true);
        vista.btnEliminar.setEnabled(true);
        vista.btnConsultar.setEnabled(false);
        vista.btnListar.setEnabled(false);
    }
    
    //Métodos de botones
    public void RegistrarInsumo(InsumoDTO dto, InsumoBO bo){
        dto.setNombre(frame.txtNombre.getText());
        dto.setDescripcion(frame.txtDescripcion.getText());
        dto.setPrecio(Double.parseDouble(frame.txtPrecio.getText()));
        dto.setStock(Integer.parseInt(frame.txtStock.getText()));
        dto.setEstado(1);
        dto.setDescuento(Double.parseDouble(frame.txtDescuento.getText()));
        insDAO = new InsumoDAO();
        bo.setInsumoDAO(insDAO);
        bo.registrar(insDTO);  
        Mensaje("Insumo registrado");
    }
    
    public int ConsultarInsumo(InsumoDTO dto,InsumoBO bo){
        int opcion;
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del insumo que quiera revisar:"));
        insDAO = new InsumoDAO();
        bo.setInsumoDAO(insDAO);
        dto = bo.buscar(opcion);
        frame.txtNombre.setText(dto.getNombre());
        frame.txtDescripcion.setText(dto.getDescripcion());
        frame.txtPrecio.setText(String.valueOf(dto.getPrecio()));
        frame.txtStock.setText(String.valueOf(dto.getStock()));
        frame.txtDescuento.setText(String.valueOf(dto.getDescuento()));
        return dto.getIdInsumo();
    }
    
    public void Listar(InsumoDTO dto, InsumoBO bo){
        if(frame.tblListaInsumos.getRowCount() != 0){
        for(int i=frame.tblListaInsumos.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
            }
        }
        insDAO = new InsumoDAO();
        bo.setInsumoDAO(insDAO);
        L_insumos = bo.listar();
        for(int i=0;i<L_insumos.size();i++){
                 modelo.addRow(L_insumos.get(i).Registro());
        } 
    }
    
    public void Actualizar(InsumoDTO dto, InsumoBO bo){
        insDAO = new InsumoDAO(); 
        bo.setInsumoDAO(insDAO);
        dto.setNombre(frame.txtNombre.getText());
        dto.setDescripcion(frame.txtDescripcion.getText());
        dto.setPrecio(Double.parseDouble(frame.txtPrecio.getText()));
        dto.setStock(Integer.parseInt(frame.txtStock.getText()));
        dto.setEstado(1);
        dto.setDescuento(Double.parseDouble(frame.txtDescuento.getText()));       
        bo.actualizar(dto);        
    }
    

}
