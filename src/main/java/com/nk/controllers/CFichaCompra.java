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
        DesactivarTXTs(frame);
        modelo = PonerCabeceras(frame.tblListaCompras);
        comBO = new CompraBO();
        comDTO = new CompraDTO();
        Listar(comDTO,comBO);        
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frame.btnConsultar){
            comDTO = new CompraDTO();
            codCompra = ConsultarCompra(comDTO,comBO);
            ActivarUPDEL(frame);
        }
        if(e.getSource() == frame.btnActualizar){
            comDTO = new CompraDTO();
            Actualizar(comDTO,comBO,codCompra);
            if(frame.tblListaCompras.getRowCount() != 0){
                Listar(comDTO,comBO);
            }
            DesactivarUPDEL(frame);
            LimpiarEntradas(frame);
            codCompra = 0;
        }
        if(e.getSource() == frame.btnEliminar){
            comDTO = new CompraDTO();
            Eliminar(comDTO,comBO,codCompra);
            if(frame.tblListaCompras.getRowCount() != 0){
                Listar(comDTO,comBO);
            }
            DesactivarUPDEL(frame);
            LimpiarEntradas(frame);
            codCompra = 0;
        }
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
    
    public void Mensaje (String m){
        JOptionPane.showMessageDialog(null, m);
    }
    
    public void LimpiarEntradas(VFichaCompra vista){
        vista.txt_IdCompra.setText("");
        vista.txt_IdProveedor.setText("");
        vista.txt_IdUsuario.setText("");
        vista.txtEstado.setText("");
        vista.txtFecha.setText("");
    }
    
    public void ActivarUPDEL(VFichaCompra vista){
        vista.btnActualizar.setEnabled(true);
        vista.btnEliminar.setEnabled(true);
        vista.btnConsultar.setEnabled(false);        
    }
    
    public void DesactivarUPDEL(VFichaCompra vista){
        vista.btnActualizar.setEnabled(false);
        vista.btnEliminar.setEnabled(false);
        vista.btnConsultar.setEnabled(true);        
    }
    
    public void DesactivarTXTs (VFichaCompra vista){
        vista.txt_IdCompra.setEnabled(false);
        vista.txt_IdProveedor.setEnabled(false);
        vista.txt_IdUsuario.setEnabled(false);
        vista.txtFecha.setEnabled(false);
    }
    
    public void Listar(CompraDTO dto, CompraBO bo){
        if(frame.tblListaCompras.getRowCount() != 0){
        for(int i=frame.tblListaCompras.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
            }
        }
        comDAO = new CompraDAO();
        bo.setCompraDAO(comDAO);
        L_compras = bo.listar();
        for(int i=0;i<L_compras.size();i++){
            if(L_compras.get(i).getEstado()== 1 || L_compras.get(i).getEstado()== 2){
               modelo.addRow(L_compras.get(i).Registro());
            }
        } 
    }
    
    public int ConsultarCompra (CompraDTO dto,CompraBO bo){
        int opcion;
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código de la compra que quiera revisar:"));
        comDAO = new CompraDAO();
        bo.setCompraDAO(comDAO);
        dto = bo.buscar(opcion);
        frame.txt_IdCompra.setText(String.valueOf(dto.getId_compra()));
        frame.txt_IdProveedor.setText(String.valueOf(dto.getId_proveedor()));
        frame.txt_IdUsuario.setText(String.valueOf(dto.getId_usuario()));
        frame.txtFecha.setText(dto.getFecha());
        frame.txtEstado.setText(String.valueOf(dto.getEstado()));
        return dto.getId_compra();
    }
    
    public void Actualizar(CompraDTO dto, CompraBO bo,int codCom){
        comDAO = new CompraDAO(); 
        bo.setCompraDAO(comDAO);
        dto.setId_compra(codCom);
        dto.setEstado(Integer.parseInt(frame.txtEstado.getText()));
        bo.actualizar(dto);        
    }
    
    public void Eliminar(CompraDTO dto, CompraBO bo, int codCom){
       comDAO = new CompraDAO();
       bo.setCompraDAO(comDAO);
       bo.eliminar(codCom);       
   }
    
   
    
}
