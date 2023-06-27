package com.nk.models.dao;

import com.nk.models.dto.DetalleVentaDTO;
import com.nk.models.idao.IDetalleVentaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;


public class DetalleVentaDAO implements IDetalleVentaDAO<DetalleVentaDTO, Integer>{

    @Override
    public boolean create(DetalleVentaDTO t) {
        boolean isCreated = false;
        try {
            Connection connection = CONEXION.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_CREATE);
            ps.setInt(1, t.getId_producto());
            ps.setInt(2, t.getId_venta());
            ps.setDouble(3, t.getSubtotal());
            ps.setDouble(4, t.getCantidad());
            isCreated = (ps.executeUpdate() == 1) ? !isCreated : isCreated;
        } catch (Exception e) {
            System.out.println("Error DetalleVentaDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isCreated;
    }

    @Override
    public DetalleVentaDTO read(Integer key) {
        DetalleVentaDTO ventaDTO = new DetalleVentaDTO();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ);
            ps.setInt(1, key);
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

    @Override
    public List<DetalleVentaDTO> readAll() {
        List<DetalleVentaDTO> list = new LinkedList<>();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
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

    @Override
    public boolean update(DetalleVentaDTO t) {
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
            System.out.println("Error DetalleVentaDAO: " + e);
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
            System.out.println("Error DetalleVentaDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isDeleted;
    }

}
