
package com.nk.models.dao;

import com.nk.models.dto.ProveedorDTO;
import com.nk.models.idao.IProveedorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class ProveedorDAO implements IProveedorDAO<ProveedorDTO, Integer> {
 @Override
    public boolean create(ProveedorDTO t) {
        boolean isCreated = false;
        try {
            Connection connection = CONEXION.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_CREATE);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApPaterno());
            ps.setString(3, t.getApMaterno());
            ps.setString(4, t.getRuc());
            ps.setString(5, t.getDni());
            ps.setString(6, t.getTelefono());
            ps.setString(7, t.getfInsercion());
            ps.setString(8, t.getfActualizacion());
            ps.setString(9, t.getfEliminacion());
            ps.setInt(10, t.getEstado());
            isCreated = (ps.executeUpdate() == 1) ? !isCreated : isCreated;
        } catch (Exception e) {
            System.out.println("Error ProveedorDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isCreated;
    }
    @Override
    public ProveedorDTO read(Integer key) {
        ProveedorDTO proveedorDTO = new ProveedorDTO();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                proveedorDTO.setIdProveedor(rs.getInt(1));
                proveedorDTO.setNombres(rs.getString(2));
                proveedorDTO.setApPaterno(rs.getString(3));
                proveedorDTO.setApMaterno(rs.getString(4));
                proveedorDTO.setRuc(rs.getString(5));
                proveedorDTO.setDni(rs.getString(6));
                proveedorDTO.setTelefono(rs.getString(7));
                proveedorDTO.setfInsercion(rs.getString(8));
                proveedorDTO.setfActualizacion(rs.getString(9));
                proveedorDTO.setfEliminacion(rs.getString(10));
                proveedorDTO.setEstado(rs.getInt(11));
            }
        } catch (Exception e) {
            System.out.println("Error ProveedorDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return proveedorDTO;
    }

  @Override
    public List<ProveedorDTO> readAll() {
        List<ProveedorDTO> list = new LinkedList<>();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ProveedorDTO proveedorDTO = new ProveedorDTO();
                proveedorDTO.setIdProveedor(rs.getInt(1));
                proveedorDTO.setNombres(rs.getString(2));
                proveedorDTO.setApPaterno(rs.getString(3));
                proveedorDTO.setApMaterno(rs.getString(4));
                proveedorDTO.setRuc(rs.getString(5));
                proveedorDTO.setDni(rs.getString(6));
                proveedorDTO.setTelefono(rs.getString(7));
                proveedorDTO.setfInsercion(rs.getString(8));
                proveedorDTO.setfActualizacion(rs.getString(9));
                proveedorDTO.setfEliminacion(rs.getString(10));
                proveedorDTO.setEstado(rs.getInt(11));
                list.add(proveedorDTO);
            }
        } catch (Exception e) {
            System.out.println("Error ProveedorDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return list;
    }   
    @Override
    public boolean update(ProveedorDTO t) {
        boolean isUpdate = false;
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApPaterno());
            ps.setString(3, t.getApMaterno());
            ps.setString(4, t.getRuc());
            ps.setString(5, t.getDni());
            ps.setString(6, t.getTelefono());
            ps.setString(7, t.getfInsercion());
            ps.setString(8, t.getfActualizacion());
            ps.setString(9, t.getfEliminacion());
            ps.setInt(10, t.getEstado());
            ps.setInt(11, t.getIdProveedor());
            isUpdate = (ps.executeUpdate() == 1) ? !isUpdate : isUpdate;
        } catch (Exception e) {
            System.out.println("Error ProveedorDAO: " + e);
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
            System.out.println("Error ProveedorDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isDeleted;
    }
}
