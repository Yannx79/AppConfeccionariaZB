package com.nk.models.dao;
// a

import com.nk.models.dto.ClienteDTO;
import com.nk.models.idao.IClienteDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class ClienteDAO implements IClienteDAO<ClienteDTO, Integer> {

    @Override
    public boolean create(ClienteDTO t) {
        boolean isCreated = false;
        try {
            Connection connection = CONEXION.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_CREATE);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApPaterno());
            ps.setString(3, t.getApMaterno());
            ps.setString(4, t.getDni());
            ps.setString(5, t.getTelefono());
            ps.setDouble(6, t.getEstado());
            isCreated = (ps.executeUpdate() == 1) ? !isCreated : isCreated;
        } catch (Exception e) {
            System.out.println("Error ClienteDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isCreated;
    }

    @Override
    public ClienteDTO read(Integer key) {
        ClienteDTO clienteDTO = new ClienteDTO();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clienteDTO.setIdCliente(rs.getInt(1));
                clienteDTO.setNombres(rs.getString(2));
                clienteDTO.setApPaterno(rs.getString(3));
                clienteDTO.setApMaterno(rs.getString(4));
                clienteDTO.setDni(rs.getString(5));
                clienteDTO.setTelefono(rs.getString(6));
                clienteDTO.setfInsercion(rs.getString(7));
                clienteDTO.setfActualizacion(rs.getString(8));
                clienteDTO.setfEliminacion(rs.getString(9));
                clienteDTO.setEstado(rs.getInt(10));
            }
        } catch (Exception e) {
            System.out.println("Error ClienteDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return clienteDTO;
    }

    @Override
    public List<ClienteDTO> readAll() {
        List<ClienteDTO> list = new LinkedList<>();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ClienteDTO clienteDTO = new ClienteDTO();
                clienteDTO.setIdCliente(rs.getInt(1));
                clienteDTO.setNombres(rs.getString(2));
                clienteDTO.setApPaterno(rs.getString(3));
                clienteDTO.setApMaterno(rs.getString(4));
                clienteDTO.setDni(rs.getString(5));
                clienteDTO.setTelefono(rs.getString(6));
                clienteDTO.setfInsercion(rs.getString(7));
                clienteDTO.setfActualizacion(rs.getString(8));
                clienteDTO.setfEliminacion(rs.getString(9));
                clienteDTO.setEstado(rs.getInt(10));
                list.add(clienteDTO);
            }
        } catch (Exception e) {
            System.out.println("Error ClienteDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return list;
    }

    @Override
    public boolean update(ClienteDTO t) {
        boolean isUpdate = false;
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApPaterno());
            ps.setString(3, t.getApMaterno());
            ps.setString(4, t.getDni());
            ps.setString(5, t.getTelefono());
            ps.setInt(6, t.getEstado());
            ps.setInt(7, t.getIdCliente());
            isUpdate = (ps.executeUpdate() == 1) ? !isUpdate : isUpdate;
        } catch (Exception e) {
            System.out.println("Error ClienteDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isUpdate;
    }

    @Override
    public boolean delete(Integer key) {
        boolean isDeleted = false;
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE);
            ps.setInt(1, key);
            isDeleted = (ps.executeUpdate() == 1) ? !isDeleted : isDeleted;
        } catch (Exception e) {
            System.out.println("Error ClienteDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isDeleted;
    }

}
