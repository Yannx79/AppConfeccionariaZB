package com.nk.controllers;

import com.nk.views.VDetalleVenta;
import com.nk.models.dto.DetalleVentaDTO;
import com.nk.models.bo.DetalleVentaBO;
import com.nk.models.dao.DetalleVentaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CDetalleVenta implements ActionListener {

    //frame
    VDetalleVenta frame;
    //Clase de tabla
    DetalleVentaDTO detDTO;
    DetalleVentaBO detBO;
    DetalleVentaDAO detDAO;
    //Lista de la clase
    List<DetalleVentaDTO> L_detalles = null;
    //Modelo de tabla
    DefaultTableModel modelo = null;
    //variable auxiliar
    int codProducto;
    int codVenta;

    //Constructor de controlador
    public CDetalleVenta(VDetalleVenta vista) {
        frame = vista;
        AgregarBotones(frame);
        frame.btnActualizar.setEnabled(false);
        frame.btnEliminar.setEnabled(false);
        modelo = PonerCabeceras(frame.tblListaDetallesVenta);
        detBO = new DetalleVentaBO();
        frame.setVisible(true);
    }

    //Función de botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frame.btnRegistrar) {
            detDTO = new DetalleVentaDTO();
            RegistrarDetalleVenta(detDTO, detBO);
            LimpiarEntradas(frame);
            if (frame.tblListaDetallesVenta.getRowCount() != 0) {
                Listar(detDTO, detBO);
            }
        }
        if (e.getSource() == frame.btnConsultar) {
            detDTO = new DetalleVentaDTO();

            codProducto = ConsultarDetalleVenta(detDTO, detBO);

            ActivarUPDEL(frame);
        }
        if (e.getSource() == frame.btnListar) {
            detDTO = new DetalleVentaDTO();
            Listar(detDTO, detBO);
        }
        if (e.getSource() == frame.btnActualizar) {
            detDTO = new DetalleVentaDTO();
            Actualizar(detDTO, detBO, codProducto, codVenta);
            if (frame.tblListaDetallesVenta.getRowCount() != 0) {
                Listar(detDTO, detBO);
            }
            DesactivarUPDEL(frame);
            LimpiarEntradas(frame);
            codProducto = 0;
            codVenta = 0;
        }
        if (e.getSource() == frame.btnEliminar) {
            detDTO = new DetalleVentaDTO();
            Eliminar(detDTO, detBO, codProducto, codVenta);
            if (frame.tblListaDetallesVenta.getRowCount() != 0) {
                Listar(detDTO, detBO);
            }
            DesactivarUPDEL(frame);
            LimpiarEntradas(frame);
            codProducto = 0;
            codVenta = 0;
        }
    }

    //Métodos auxiliares
    public void AgregarBotones(VDetalleVenta vista) {
        frame.btnActualizar.addActionListener(this);
        frame.btnConsultar.addActionListener(this);
        frame.btnEliminar.addActionListener(this);
        frame.btnListar.addActionListener(this);
        frame.btnRegistrar.addActionListener(this);
    }

    public DefaultTableModel PonerCabeceras(JTable tabla) {
        String[] titulos = {"Id Producto", "ID Venta", "SubTotal", "Cantidad", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        return modelo;
    }

    public void Mensaje(String m) {
        JOptionPane.showMessageDialog(null, m);
    }

    public void LimpiarEntradas(VDetalleVenta vista) {
        vista.txtId_producto.setText("");
        vista.txtId_venta.setText("");
        vista.txtSubTotal.setText("");
        vista.txtCantidad.setText("");
        vista.txtId_producto.requestFocus();
    }

    public void ActivarUPDEL(VDetalleVenta vista) {
        vista.btnRegistrar.setEnabled(false);
        vista.btnActualizar.setEnabled(true);
        vista.btnEliminar.setEnabled(true);
        vista.btnConsultar.setEnabled(false);
        vista.btnListar.setEnabled(false);
    }

    public void DesactivarUPDEL(VDetalleVenta vista) {
        vista.btnRegistrar.setEnabled(true);
        vista.btnActualizar.setEnabled(false);
        vista.btnEliminar.setEnabled(false);
        vista.btnConsultar.setEnabled(true);
        vista.btnListar.setEnabled(true);
    }

    //Métodos de botones
    public void RegistrarDetalleVenta(DetalleVentaDTO dto, DetalleVentaBO bo) {
        dto.setId_producto(Integer.parseInt(frame.txtId_producto.getText()));
        dto.setId_venta(Integer.parseInt(frame.txtId_venta.getText()));
        dto.setSubtotal(Double.parseDouble(frame.txtSubTotal.getText()));
        dto.setCantidad(Integer.parseInt(frame.txtCantidad.getText()));
        dto.setEstado(1);
        detDAO = new DetalleVentaDAO();
        bo.setDetalleVentaDAO(detDAO);
        bo.registrar(detDTO);
        Mensaje("Detalle de Venta registrado");
    }

    public int ConsultarDetalleVenta(DetalleVentaDTO dto, DetalleVentaBO bo) {
        String opcion, opcion2;
        // Solicitar al usuario dos datos
        opcion = JOptionPane.showInputDialog("Ingrese el código del Producto que quiera revisar:");
        opcion2 = JOptionPane.showInputDialog("Ingrese el código de la Venta que quiera revisar:");

        int codProducto = Integer.parseInt(opcion);
        int codVenta = Integer.parseInt(opcion2);

        detDAO = new DetalleVentaDAO();
        bo.setDetalleVentaDAO(detDAO);
        dto = bo.buscar(codProducto, codVenta);
        frame.txtId_producto.setText(String.valueOf(dto.getId_producto()));
        frame.txtId_venta.setText(String.valueOf(dto.getId_venta()));
        frame.txtSubTotal.setText(String.valueOf(dto.getSubtotal()));
        frame.txtCantidad.setText(String.valueOf(dto.getCantidad()));
        return dto.getId_venta();
    }

    public void Listar(DetalleVentaDTO dto, DetalleVentaBO bo) {
        if (frame.tblListaDetallesVenta.getRowCount() != 0) {
            for (int i = frame.tblListaDetallesVenta.getRowCount() - 1; i >= 0; i--) {
                modelo.removeRow(i);
            }
        }
        detDAO = new DetalleVentaDAO();
        bo.setDetalleVentaDAO(detDAO);
        L_detalles = bo.listar();
        for (int i = 0; i < L_detalles.size(); i++) {
            if (L_detalles.get(i).getEstado() == 1) {
                modelo.addRow(L_detalles.get(i).Registro());
            }
        }
    }

    public void Actualizar(DetalleVentaDTO dto, DetalleVentaBO bo, int codProducto, int codVenta) {
        detDAO = new DetalleVentaDAO();
        bo.setDetalleVentaDAO(detDAO);
        dto.setId_producto(codProducto);
        dto.setId_venta(codVenta);
        dto.setId_producto(Integer.parseInt(frame.txtId_producto.getText()));
        dto.setId_venta(Integer.parseInt(frame.txtId_venta.getText()));
        dto.setSubtotal(Double.parseDouble(frame.txtSubTotal.getText()));
        dto.setCantidad(Integer.parseInt(frame.txtCantidad.getText()));
        dto.setEstado(1);
        bo.actualizar(dto);
    }

    public void Eliminar(DetalleVentaDTO dto, DetalleVentaBO bo, int codProducto, int codVenta) {
        detDAO = new DetalleVentaDAO();
        bo.setDetalleVentaDAO(detDAO);
        dto.setId_producto(codProducto);
        dto.setId_venta(codVenta);
        bo.eliminar(dto.getId_producto(), dto.getId_venta()); 
    }
}
