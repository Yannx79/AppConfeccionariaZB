package com.nk.models.dao;

import com.nk.models.dto.VentaDTO;
import com.nk.models.idao.IVentaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class VentaDAO implements IVentaDAO<VentaDTO, Integer>{

    @Override
    public boolean create(VentaDTO t) {
        boolean isCreated = false;
        try {
            Connection connection = CONEXION.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_CREATE);
            ps.setInt(1, t.getId_usuario());
            ps.setInt(2, t.getId_cliente());
            ps.setDouble(3, t.getTotal());
            ps.setDouble(4, t.getImpuesto());
            isCreated = (ps.executeUpdate() == 1) ? !isCreated : isCreated;
        } catch (Exception e) {
            System.out.println("Error VentaDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isCreated;
    }

    @Override
    public VentaDTO read(Integer key) {
        VentaDTO ventaDTO = new VentaDTO();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ventaDTO.setId_venta(rs.getInt(1));
                ventaDTO.setId_usuario(rs.getInt(2));
                ventaDTO.setId_cliente(rs.getInt(3));
                ventaDTO.setTotal(rs.getDouble(4));
                ventaDTO.setFecha(rs.getString(5));
                ventaDTO.setImpuesto(rs.getDouble(6));
                ventaDTO.setEstado(rs.getInt(7));
                
            }
        } catch (Exception e) {
            System.out.println("Error VentaDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return ventaDTO;
    }

    @Override
    public List<VentaDTO> readAll() {
        List<VentaDTO> list = new LinkedList<>();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                VentaDTO ventaDTO = new VentaDTO();
                ventaDTO.setId_venta(rs.getInt(1));
                ventaDTO.setId_usuario(rs.getInt(2));
                ventaDTO.setId_cliente(rs.getInt(3));
                ventaDTO.setTotal(rs.getDouble(4));
                ventaDTO.setFecha(rs.getString(5));
                ventaDTO.setImpuesto(rs.getDouble(6));
                ventaDTO.setEstado(rs.getInt(7));
                list.add(ventaDTO);
            }
        } catch (Exception e) {
            System.out.println("Error VentaDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return list;
    }

    @Override
    public boolean update(VentaDTO t) {
        boolean isUpdate = false;
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
            ps.setInt(1, t.getId_usuario());
            ps.setInt(2, t.getId_cliente());
            ps.setDouble(3, t.getTotal());
            ps.setDouble(4, t.getImpuesto());
            ps.setInt(5, t.getEstado());
            ps.setInt(6, t.getId_venta());
            isUpdate = (ps.executeUpdate() == 1) ? !isUpdate : isUpdate;
        } catch (Exception e) {
            System.out.println("Error VentaDAO: " + e);
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
            System.out.println("Error VentaDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isDeleted;
   }

}
