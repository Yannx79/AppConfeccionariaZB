package com.nk.controllers;

import com.nk.views.VMovimientoI;
import com.nk.models.dto.ProductoDTO;
import com.nk.models.bo.ProductoBO;
import com.nk.models.dao.ProductoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CMovimientoI implements ActionListener {

    //frame
    VMovimientoI frame;
    //Clase de tabla
    ProductoDTO proDTO;
    ProductoBO proBO;
    ProductoDAO proDAO;
    //Lista de la clase
    List<ProductoDTO> L_productos = null;
    //Modelo de tabla
    DefaultTableModel modelo = null;
    //variable auxiliar
    int codProducto;

    //Constructor de controlador
    public CMovimientoI(VMovimientoI vista) {
        frame = vista;
        AgregarBotones(frame);
        frame.btnActualizar.setEnabled(false);
        frame.btnEliminar.setEnabled(false);
        modelo = PonerCabeceras(frame.tblListaProductos);
        proBO = new ProductoBO();
        frame.setVisible(true);
    }

    //Función de botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frame.btnRegistrar) {
            proDTO = new ProductoDTO();
            RegistrarProducto(proDTO, proBO);
            LimpiarEntradas(frame);
            if (frame.tblListaProductos.getRowCount() != 0) {
                Listar(proDTO, proBO);
            }
        }
        if (e.getSource() == frame.btnConsultar) {
            proDTO = new ProductoDTO();
            codProducto = ConsultarProducto(proDTO, proBO);
            ActivarUPDEL(frame);
        }
        if (e.getSource() == frame.btnListar) {
            proDTO = new ProductoDTO();
            Listar(proDTO, proBO);
        }
        if (e.getSource() == frame.btnActualizar) {
            proDTO = new ProductoDTO();
            Actualizar(proDTO, proBO, codProducto);
            if (frame.tblListaProductos.getRowCount() != 0) {
                Listar(proDTO, proBO);
            }
            DesactivarUPDEL(frame);
            LimpiarEntradas(frame);
            codProducto = 0;
        }
        if (e.getSource() == frame.btnEliminar) {
            proDTO = new ProductoDTO();
            Eliminar(proDTO, proBO, codProducto);
            if (frame.tblListaProductos.getRowCount() != 0) {
                Listar(proDTO, proBO);
            }
            DesactivarUPDEL(frame);
            LimpiarEntradas(frame);
            codProducto = 0;
        }

    }

    //Métodos auxiliares
    public void AgregarBotones(VMovimientoI vista) {
        frame.btnActualizar.addActionListener(this);
        frame.btnConsultar.addActionListener(this);
        frame.btnEliminar.addActionListener(this);
        frame.btnListar.addActionListener(this);
        frame.btnRegistrar.addActionListener(this);
    }

    public DefaultTableModel PonerCabeceras(JTable tabla) {
        String[] titulos = {"Id Producto", "Nombre", "Descripción", "Precio",
            "Stock", "Estado", "F. Inserción", "F. Actualización",
            "F. Eliminación", "Descuento"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        return modelo;
    }

    public void Mensaje(String m) {
        JOptionPane.showMessageDialog(null, m);
    }

    public void LimpiarEntradas(VMovimientoI vista) {
        vista.txtNombre.setText("");
        vista.txtDescripcion.setText("");
        vista.txtDescuento.setText("");
        vista.txtPrecio.setText("");
        vista.txtStock.setText("");
        vista.txtNombre.requestFocus();
    }

    public void ActivarUPDEL(VMovimientoI vista) {
        vista.btnRegistrar.setEnabled(false);
        vista.btnActualizar.setEnabled(true);
        vista.btnEliminar.setEnabled(true);
        vista.btnConsultar.setEnabled(false);
        vista.btnListar.setEnabled(false);
    }

    public void DesactivarUPDEL(VMovimientoI vista) {
        vista.btnRegistrar.setEnabled(true);
        vista.btnActualizar.setEnabled(false);
        vista.btnEliminar.setEnabled(false);
        vista.btnConsultar.setEnabled(true);
        vista.btnListar.setEnabled(true);
    }

    //Métodos de botones
    public void RegistrarProducto(ProductoDTO dto, ProductoBO bo) {
        dto.setNombre(frame.txtNombre.getText());
        dto.setDescripcion(frame.txtDescripcion.getText());
        dto.setPrecio(Double.parseDouble(frame.txtPrecio.getText()));
        dto.setStock(Integer.parseInt(frame.txtStock.getText()));
        dto.setEstado(1);
        dto.setDescuento(Double.parseDouble(frame.txtDescuento.getText()));
        proDAO = new ProductoDAO();
        bo.setProductoDAO(proDAO);
        bo.registrar(proDTO);
        Mensaje("Producto registrado");
    }

    public int ConsultarProducto(ProductoDTO dto, ProductoBO bo) {
        int opcion;
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del Producto que quiera revisar:"));
        proDAO = new ProductoDAO();
        bo.setProductoDAO(proDAO);
        dto = bo.buscar(opcion);
        frame.txtNombre.setText(dto.getNombre());
        frame.txtDescripcion.setText(dto.getDescripcion());
        frame.txtPrecio.setText(String.valueOf(dto.getPrecio()));
        frame.txtStock.setText(String.valueOf(dto.getStock()));
        frame.txtDescuento.setText(String.valueOf(dto.getDescuento()));
        return dto.getIdProducto();
    }

    public void Listar(ProductoDTO dto, ProductoBO bo) {
        if (frame.tblListaProductos.getRowCount() != 0) {
            for (int i = frame.tblListaProductos.getRowCount() - 1; i >= 0; i--) {
                modelo.removeRow(i);
            }
        }
        proDAO = new ProductoDAO();
        bo.setProductoDAO(proDAO);
        L_productos = bo.listar();
        for (int i = 0; i < L_productos.size(); i++) {
            modelo.addRow(L_productos.get(i).Registro());
        }
    }

    public void Actualizar(ProductoDTO dto, ProductoBO bo, int codPro) {
        proDAO = new ProductoDAO();
        bo.setProductoDAO(proDAO);
        dto.setIdProducto(codPro);
        dto.setNombre(frame.txtNombre.getText());
        dto.setDescripcion(frame.txtDescripcion.getText());
        dto.setPrecio(Double.parseDouble(frame.txtPrecio.getText()));
        dto.setStock(Integer.parseInt(frame.txtStock.getText()));
        dto.setEstado(1);
        dto.setDescuento(Double.parseDouble(frame.txtDescuento.getText()));
        bo.actualizar(dto);
    }

    public void Eliminar(ProductoDTO dto, ProductoBO bo, int codPro) {
        proDAO = new ProductoDAO();
        bo.setProductoDAO(proDAO);
        bo.eliminar(codPro);
    }

}
