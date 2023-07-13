package com.nk.controllers;

import com.nk.views.VCliente;
import com.nk.models.dto.ClienteDTO;
import com.nk.models.bo.ClienteBO;
import com.nk.models.dao.ClienteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CCliente implements ActionListener {

    //frame
    VCliente frame;
    //Clase de tabla
    ClienteDTO cliDTO;
    ClienteBO cliBO;
    ClienteDAO cliDAO;
    //Lista de la clase
    List<ClienteDTO> L_clientes = null;
    //Modelo de tabla
    DefaultTableModel modelo = null;
    int codCliente;

    //Constuctor de controlador
    public CCliente(VCliente vista) {
        frame = vista;
        AgregarBotones(frame);
        frame.btnActualizar.setEnabled(false);
        frame.btnEliminar.setEnabled(false);
        modelo = PonerCabeceras(frame.tblListaClientes);
        cliBO = new ClienteBO();
        frame.setVisible(true);

        // listar
        cliDTO = new ClienteDTO();
        Listar(cliDTO, cliBO);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frame.btnRegistrar) {
            cliDTO = new ClienteDTO();
            RegistrarCliente(cliDTO, cliBO);
            LimpiarEntradas(frame);
            if (frame.tblListaClientes.getRowCount() != 0) {
                Listar(cliDTO, cliBO);
            }
        }
        if (e.getSource() == frame.btnConsultar) {
            cliDTO = new ClienteDTO();
            codCliente = ConsultarCliente(cliDTO, cliBO);
            ActivarUPDEL(frame);
        }
        if (e.getSource() == frame.btnListar) {
            cliDTO = new ClienteDTO();
            Listar(cliDTO, cliBO);
        }
        if (e.getSource() == frame.btnActualizar) {
            cliDTO = new ClienteDTO();
            Actualizar(cliDTO, cliBO, codCliente);
            if (frame.tblListaClientes.getRowCount() != 0) {
                Listar(cliDTO, cliBO);
            }
            DesactivarUPDEL(frame);
            LimpiarEntradas(frame);
            codCliente = 0;
        }
        if (e.getSource() == frame.btnEliminar) {
            cliDTO = new ClienteDTO();
            Eliminar(cliDTO, cliBO, codCliente);
            if (frame.tblListaClientes.getRowCount() != 0) {
                Listar(cliDTO, cliBO);
            }
            DesactivarUPDEL(frame);
            LimpiarEntradas(frame);
            codCliente = 0;
        }
    }

    public void AgregarBotones(VCliente vista) {
        frame.btnActualizar.addActionListener(this);
        frame.btnConsultar.addActionListener(this);
        frame.btnEliminar.addActionListener(this);
        frame.btnListar.addActionListener(this);
        frame.btnRegistrar.addActionListener(this);
    }

    public DefaultTableModel PonerCabeceras(JTable tabla) {
        String[] titulos = {"Id Cliente", "Nombre", "Apellido Paterno", "Apellido Materno",
            "DNI", "Telefono", "F. Inserción", "F. Actualización",
            "F. Eliminación", "estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        return modelo;
    }

    public void Mensaje(String m) {
        JOptionPane.showMessageDialog(null, m);
    }

    public void LimpiarEntradas(VCliente vista) {
        vista.txtNombre.setText("");
        vista.txtApellPa.setText("");
        vista.txtApellMa.setText("");
        vista.txtDNI.setText("");
        vista.txtTelefono.setText("");
        vista.txtNombre.requestFocus();
    }

    public void ActivarUPDEL(VCliente vista) {
        vista.btnRegistrar.setEnabled(false);
        vista.btnActualizar.setEnabled(true);
        vista.btnEliminar.setEnabled(true);
        vista.btnConsultar.setEnabled(false);
        vista.btnListar.setEnabled(false);
    }

    public void DesactivarUPDEL(VCliente vista) {
        vista.btnRegistrar.setEnabled(true);
        vista.btnActualizar.setEnabled(false);
        vista.btnEliminar.setEnabled(false);
        vista.btnConsultar.setEnabled(true);
        vista.btnListar.setEnabled(true);
    }

    public void RegistrarCliente(ClienteDTO dto, ClienteBO bo) {
        dto.setNombres(frame.txtNombre.getText());
        dto.setApPaterno(frame.txtApellPa.getText());
        dto.setApMaterno(frame.txtApellMa.getText());
        dto.setDni(frame.txtDNI.getText());
        dto.setTelefono(frame.txtTelefono.getText());
        dto.setEstado(1);
        cliDAO = new ClienteDAO();
        bo.setClienteDAO(cliDAO);
        bo.registrar(cliDTO);
        Mensaje("Cliente registrado");
    }

    public int ConsultarCliente(ClienteDTO dto, ClienteBO bo) {
        int opcion;
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del cliente que quiera revisar:"));
        cliDAO = new ClienteDAO();
        bo.setClienteDAO(cliDAO);
        dto = bo.buscar(opcion);
        frame.txtNombre.setText(dto.getNombres());
        frame.txtApellPa.setText(dto.getApPaterno());
        frame.txtApellMa.setText(dto.getApMaterno());
        frame.txtDNI.setText(dto.getDni());
        frame.txtTelefono.setText(dto.getTelefono());
        return dto.getIdCliente();
    }

    public void Listar(ClienteDTO dto, ClienteBO bo) {
        if (frame.tblListaClientes.getRowCount() != 0) {
            for (int i = frame.tblListaClientes.getRowCount() - 1; i >= 0; i--) {
                modelo.removeRow(i);
            }
        }
        cliDAO = new ClienteDAO();
        bo.setClienteDAO(cliDAO);
        L_clientes = bo.listar();
        for (int i = 0; i < L_clientes.size(); i++) {
            modelo.addRow(L_clientes.get(i).Registro());
        }
    }

    public void Actualizar(ClienteDTO dto, ClienteBO bo, int codCli) {
        cliDAO = new ClienteDAO();
        bo.setClienteDAO(cliDAO);
        dto.setIdCliente(codCli);
        dto.setNombres(frame.txtNombre.getText());
        dto.setApPaterno(frame.txtApellPa.getText());
        dto.setApMaterno(frame.txtApellMa.getText());
        dto.setDni(frame.txtDNI.getText());
        dto.setTelefono(frame.txtTelefono.getText());
        bo.actualizar(dto);
    }

    public void Eliminar(ClienteDTO dto, ClienteBO bo, int codCli) {
        cliDAO = new ClienteDAO();
        bo.setClienteDAO(cliDAO);
        bo.eliminar(codCli);
    }
}
