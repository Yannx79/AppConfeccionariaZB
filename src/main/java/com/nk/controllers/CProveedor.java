package com.nk.controllers;

import com.nk.views.VProveedor;
import com.nk.models.dto.ProveedorDTO;
import com.nk.models.bo.ProveedorBO;
import com.nk.models.dao.ProveedorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CProveedor implements ActionListener{

    //frame
    VProveedor frame;
    //Clase de tabla
    ProveedorDTO proDTO;
    ProveedorBO proBO;
    ProveedorDAO proDAO;
    //Lista de la clase
    List<ProveedorDTO> L_proveedores = null;
    //Modelo de tabla
    DefaultTableModel modelo = null;
    int codProveedor;
    
    //Constuctor de controlador
    public CProveedor (VProveedor vista){
        frame = vista;
        AgregarBotones(frame);
        frame.btnActualizar.setEnabled(false);
        frame.btnEliminar.setEnabled(false);
        modelo = PonerCabeceras(frame.tblListaProveedores);
        proBO = new ProveedorBO();
        frame.setVisible(true);
    }
    
        @Override
        public void actionPerformed(ActionEvent e) {
         if(e.getSource() == frame.btnRegistrar){
            proDTO = new ProveedorDTO();
            RegistrarProveedor(proDTO,proBO);
            LimpiarEntradas(frame);
            if(frame.tblListaProveedores.getRowCount() != 0){
                Listar(proDTO,proBO);
            }
        }
            if(e.getSource() == frame.btnConsultar){
            proDTO = new ProveedorDTO();
            codProveedor = ConsultarProveedor(proDTO,proBO);
            ActivarUPDEL(frame);
        }
        if(e.getSource() == frame.btnListar){
            proDTO = new ProveedorDTO();
            Listar(proDTO,proBO);
        }
        if(e.getSource() == frame.btnActualizar){
            proDTO = new ProveedorDTO();
            Actualizar(proDTO,proBO,codProveedor);
            if(frame.tblListaProveedores.getRowCount() != 0){
                Listar(proDTO,proBO);
            }
            DesactivarUPDEL(frame);
            LimpiarEntradas(frame);
            codProveedor =0;
        }
            if(e.getSource() == frame.btnEliminar){
            proDTO = new ProveedorDTO();
            Eliminar(proDTO,proBO,codProveedor);
            if(frame.tblListaProveedores.getRowCount() != 0){
                Listar(proDTO,proBO);
            }
            DesactivarUPDEL(frame);
            LimpiarEntradas(frame);
            codProveedor =0;
        }
        }
         
         
            public void AgregarBotones(VProveedor vista){
        frame.btnActualizar.addActionListener(this);
        frame.btnConsultar.addActionListener(this);
        frame.btnEliminar.addActionListener(this);
        frame.btnListar.addActionListener(this);
        frame.btnRegistrar.addActionListener(this);
    }
    
            public DefaultTableModel PonerCabeceras(JTable tabla){
        String[] titulos={"Id Proveedor","Nombre","Apellido Paterno","Apellido Materno",
                        "RUC","DNI","Telefono","F. Inserción","F. Actualización",
                        "F. Eliminación","estado"};
        DefaultTableModel modelo= new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
        return modelo;
    }
            public void Mensaje (String m){
        JOptionPane.showMessageDialog(null, m);
    }
            
     public void LimpiarEntradas(VProveedor vista){
        vista.txtNombres.setText("");
        vista.txtApellPa.setText("");
        vista.txtApellMa.setText("");
        vista.txtDNI.setText("");
        vista.txtTelefono.setText("");
        vista.txtRUC.setText("");  
        vista.txtNombres.requestFocus();       
    }
    
     public void ActivarUPDEL(VProveedor vista){
        vista.btnRegistrar.setEnabled(false);
        vista.btnActualizar.setEnabled(true);
        vista.btnEliminar.setEnabled(true);
        vista.btnConsultar.setEnabled(false);
        vista.btnListar.setEnabled(false);
    }
        
    public void DesactivarUPDEL(VProveedor vista){
        vista.btnRegistrar.setEnabled(true);
        vista.btnActualizar.setEnabled(false);
        vista.btnEliminar.setEnabled(false);
        vista.btnConsultar.setEnabled(true);
        vista.btnListar.setEnabled(true);
    }
    public void RegistrarProveedor (ProveedorDTO dto, ProveedorBO bo){
        dto.setNombres(frame.txtNombres.getText());
        dto.setApPaterno(frame.txtApellPa.getText());
        dto.setApMaterno(frame.txtApellMa.getText());
	dto.setRuc(frame.txtRUC.getText());
        dto.setDni(frame.txtDNI.getText());
        dto.setTelefono(frame.txtTelefono.getText());
        dto.setEstado(1);
        proDAO = new ProveedorDAO();
        bo.setProveedorDAO(proDAO);
        bo.registrar(proDTO);  
        Mensaje("Proveedor registrado");     
    }
        public int ConsultarProveedor(ProveedorDTO dto,ProveedorBO bo){
        int opcion;
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del proveedor que quiera revisar:"));
        proDAO = new ProveedorDAO();
        bo.setProveedorDAO(proDAO);
        dto = bo.buscar(opcion);
        frame.txtNombres.setText(dto.getNombres());
        frame.txtApellPa.setText(dto.getApPaterno());
        frame.txtApellMa.setText(dto.getApMaterno());
        frame.txtRUC.setText(dto.getRuc());
        frame.txtDNI.setText(dto.getDni());
        frame.txtTelefono.setText(dto.getTelefono());
        return dto.getIdProveedor();
    }
        
        public void Listar(ProveedorDTO dto, ProveedorBO bo){
        if(frame.tblListaProveedores.getRowCount() != 0){
        for(int i=frame.tblListaProveedores.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
            }
        }    
        proDAO = new ProveedorDAO();
        bo.setProveedorDAO(proDAO);
        L_proveedores = bo.listar();
        for(int i=0;i<L_proveedores.size();i++){
                 modelo.addRow(L_proveedores.get(i).Registro());
            } 
        }
        public void Actualizar(ProveedorDTO dto, ProveedorBO bo,int codPro){
        proDAO = new ProveedorDAO(); 
        bo.setProveedorDAO(proDAO);
        dto.setIdProveedor(codPro);
        dto.setNombres(frame.txtNombres.getText());
        dto.setApPaterno(frame.txtApellPa.getText());
        dto.setApMaterno(frame.txtApellMa.getText());
        dto.setRuc(frame.txtRUC.getText());
        dto.setDni(frame.txtDNI.getText());
        dto.setTelefono(frame.txtTelefono.getText());      
        bo.actualizar(dto);        
    }
   public void Eliminar(ProveedorDTO dto, ProveedorBO bo, int codPro){
       proDAO = new ProveedorDAO();
       bo.setProveedorDAO(proDAO);
       bo.eliminar(codPro);       
   }
}
