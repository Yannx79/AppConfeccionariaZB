package com.nk.controllers;

import com.nk.views.VVenta;
import com.nk.models.dto.VentaDTO;
import com.nk.models.bo.VentaBO;
import com.nk.models.dao.VentaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CVenta implements ActionListener {

    //frame
    VVenta frame;
    //Clase de tabla
    VentaDTO venDTO;
    VentaBO venBO;
    VentaDAO venDAO;
    //Lista de la clase
    List<VentaDTO> L_ventas = null;
    //Modelo de tabla
    DefaultTableModel modelo = null;
    //variable auxiliar
    int codVenta;

    //Constructor de controlador
    public CVenta(VVenta vista) {
        frame = vista;
        AgregarBotones(frame);
        frame.btnActualizar.setEnabled(false);
        frame.btnEliminar.setEnabled(false);
        modelo = PonerCabeceras(frame.tblListaVentas);
        venBO = new VentaBO();
        frame.setVisible(true);
    }

    //Función de botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frame.btnRegistrar) {
            venDTO = new VentaDTO();
            RegistrarVenta(venDTO, venBO);
            LimpiarEntradas(frame);
            if (frame.tblListaVentas.getRowCount() != 0) {
                Listar(venDTO, venBO);
            }
        }
        if (e.getSource() == frame.btnConsultar) {
            venDTO = new VentaDTO();
            codVenta = ConsultarVenta(venDTO, venBO);
            ActivarUPDEL(frame);
        }
        if (e.getSource() == frame.btnListar) {
            venDTO = new VentaDTO();
            Listar(venDTO, venBO);
        }
        if (e.getSource() == frame.btnActualizar) {
            venDTO = new VentaDTO();
            Actualizar(venDTO, venBO, codVenta);
            if (frame.tblListaVentas.getRowCount() != 0) {
                Listar(venDTO, venBO);
            }
            DesactivarUPDEL(frame);
            LimpiarEntradas(frame);
            codVenta = 0;
        }
        if (e.getSource() == frame.btnEliminar) {
            venDTO = new VentaDTO();
            Eliminar(venDTO, venBO, codVenta);
            if (frame.tblListaVentas.getRowCount() != 0) {
                Listar(venDTO, venBO);
            }
            DesactivarUPDEL(frame);
            LimpiarEntradas(frame);
            codVenta = 0;
        }

    }

    //Métodos auxiliares
    public void AgregarBotones(VVenta vista) {
        frame.btnActualizar.addActionListener(this);
        frame.btnConsultar.addActionListener(this);
        frame.btnEliminar.addActionListener(this);
        frame.btnListar.addActionListener(this);
        frame.btnRegistrar.addActionListener(this);
    }

    public DefaultTableModel PonerCabeceras(JTable tabla) {
        String[] titulos = {"Id Venta", "ID Usuario", "ID Cliente", "Total",
            "Fecha", "Impuesto", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        return modelo;
    }

    public void Mensaje(String m) {
        JOptionPane.showMessageDialog(null, m);
    }

    public void LimpiarEntradas(VVenta vista) {
        vista.txtId_usuario.setText("");
        vista.txtId_cliente.setText("");
        vista.txtId_usuario.requestFocus();
    }

    public void ActivarUPDEL(VVenta vista) {
        vista.btnRegistrar.setEnabled(false);
        vista.btnActualizar.setEnabled(true);
        vista.btnEliminar.setEnabled(true);
        vista.btnConsultar.setEnabled(false);
        vista.btnListar.setEnabled(false);
    }

    public void DesactivarUPDEL(VVenta vista) {
        vista.btnRegistrar.setEnabled(true);
        vista.btnActualizar.setEnabled(false);
        vista.btnEliminar.setEnabled(false);
        vista.btnConsultar.setEnabled(true);
        vista.btnListar.setEnabled(true);
    }

    //Métodos de botones
    public void RegistrarVenta(VentaDTO dto, VentaBO bo) {
        dto.setId_usuario(Integer.parseInt(frame.txtId_usuario.getText()));
        dto.setId_cliente(Integer.parseInt(frame.txtId_cliente.getText()));
        dto.setEstado(1);
        venDAO = new VentaDAO();
        bo.setVentaDAO(venDAO);
        bo.registrar(venDTO);
        Mensaje("Venta registrada");
    }

    public int ConsultarVenta(VentaDTO dto, VentaBO bo) {
        int opcion;
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código de la Venta que quiera revisar:"));
        venDAO = new VentaDAO();
        bo.setVentaDAO(venDAO);
        dto = bo.buscar(opcion);
        frame.txtId_usuario.setText(String.valueOf(dto.getId_usuario()));
        frame.txtId_cliente.setText(String.valueOf(dto.getId_cliente()));
        return dto.getId_venta();
    }

    public void Listar(VentaDTO dto, VentaBO bo) {
        if (frame.tblListaVentas.getRowCount() != 0) {
            for (int i = frame.tblListaVentas.getRowCount() - 1; i >= 0; i--) {
                modelo.removeRow(i);
            }
        }
        venDAO = new VentaDAO();
        bo.setVentaDAO(venDAO);
        L_ventas = bo.listar();
        for (int i = 0; i < L_ventas.size(); i++) {
            if (L_ventas.get(i).getEstado() == 1) {
                modelo.addRow(L_ventas.get(i).Registro());
            }
        }
    }

    public void Actualizar(VentaDTO dto, VentaBO bo, int codVen) {
        venDAO = new VentaDAO();
        bo.setVentaDAO(venDAO);
        dto.setId_venta(codVen);
        dto.setId_usuario(Integer.parseInt(frame.txtId_usuario.getText()));
        dto.setId_cliente(Integer.parseInt(frame.txtId_cliente.getText()));
        dto.setEstado(1);
        bo.actualizar(dto);
    }

    public void Eliminar(VentaDTO dto, VentaBO bo, int codVen) {
        venDAO = new VentaDAO();
        bo.setVentaDAO(venDAO);
        bo.eliminar(codVen);
    }

}
