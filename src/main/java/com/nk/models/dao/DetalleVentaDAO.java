package com.nk.models.dao;

import com.nk.models.dto.DetalleVentaDTO;
import com.nk.models.idao.IDetalleVentaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class DetalleVentaDAO implements IDetalleVentaDAO<DetalleVentaDTO, Integer> {

    public boolean create(DetalleVentaDTO t) {
        boolean isCreated = false;
        try {
            Connection connection = CONEXION.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_CREATE);
            ps.setInt(1, t.getId_producto());
            ps.setInt(2, t.getId_venta());
            ps.setDouble(3, t.getSubtotal());
            ps.setInt(4, t.getCantidad());
            ps.setInt(5, t.getEstado());
            isCreated = (ps.executeUpdate() == 1) ? !isCreated : isCreated;
        } catch (Exception e) {
            System.out.println("Error DetalleVentaDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isCreated;
    }

    public DetalleVentaDTO read(Integer key, Integer key2) {
        DetalleVentaDTO ventaDTO = new DetalleVentaDTO();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ);
            ps.setInt(1, key);
            ps.setInt(2, key2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ventaDTO.setId_producto(rs.getInt(1));
                ventaDTO.setId_venta(rs.getInt(2));
                ventaDTO.setSubtotal(rs.getDouble(3));
                ventaDTO.setCantidad(rs.getInt(4));
                ventaDTO.setEstado(rs.getInt(5));
            }
        } catch (Exception e) {
            System.out.println("Error DetalleVentaDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return ventaDTO;
    }

    public List<DetalleVentaDTO> readAll() {
        List<DetalleVentaDTO> list = new LinkedList<>();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetalleVentaDTO ventaDTO = new DetalleVentaDTO();
                ventaDTO.setId_producto(rs.getInt(1));
                ventaDTO.setId_venta(rs.getInt(2));
                ventaDTO.setSubtotal(rs.getDouble(3));
                ventaDTO.setCantidad(rs.getInt(4));
                ventaDTO.setEstado(rs.getInt(5));
                list.add(ventaDTO);
            }
        } catch (Exception e) {
            System.out.println("Error DetalleVentaDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return list;
    }

    public boolean update(DetalleVentaDTO t) {
        boolean isUpdate = false;
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
            ps.setDouble(1, t.getSubtotal());
            ps.setInt(2, t.getCantidad());
            ps.setInt(3, t.getEstado());
            ps.setInt(4, t.getId_producto());
            ps.setInt(5, t.getId_venta());
            isUpdate = (ps.executeUpdate() == 1) ? !isUpdate : isUpdate;
        } catch (Exception e) {
            System.out.println("Error DetalleVentaDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isUpdate;
    }

    public boolean delete(Integer key, Integer key2) {
        boolean isDeleted = false;
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE);
            ps.setInt(1, key);
            ps.setInt(2, key2);
            isDeleted = (ps.executeUpdate() == 1) ? !isDeleted : isDeleted;
        } catch (Exception e) {
            System.out.println("Error DetalleVentaDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isDeleted;
    }

}
