package com.nk.models.dao;

import com.nk.models.dto.DetalleCompraDTO;
import com.nk.models.idao.IDetalleCompraDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class DetalleCompraDAO implements IDetalleCompraDAO{
        
        public boolean create(DetalleCompraDTO t) {
        boolean isCreated = false;
        try {
            Connection connection = CONEXION.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_CREATE);
            ps.setInt(1, t.getId_insumo());
            ps.setInt(2, t.getId_compra());
            ps.setDouble(3, t.getSubtotal());
            ps.setDouble(4, t.getCantidad());
            isCreated = (ps.executeUpdate() == 1) ? !isCreated : isCreated;
        } catch (Exception e) {
            System.out.println("Error DetalleCompraDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isCreated;
    }
        
         public DetalleCompraDTO read(int key, int key2) {
        DetalleCompraDTO compraDTO = new DetalleCompraDTO();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ);
            ps.setInt(1, key);
            ps.setInt(2, key2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                compraDTO.setId_insumo(rs.getInt(1));
                compraDTO.setId_compra(rs.getInt(2));
                compraDTO.setSubtotal(rs.getDouble(3));
                compraDTO.setCantidad(rs.getInt(4));
                compraDTO.setEstado(rs.getInt(5));
            }
        } catch (Exception e) {
            System.out.println("Error DetalleCompraDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return compraDTO;
    }
         
           public List<DetalleCompraDTO> readAll() {
        List<DetalleCompraDTO> list = new LinkedList<>();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                DetalleCompraDTO compraDTO = new DetalleCompraDTO();
                compraDTO.setId_insumo(rs.getInt(1));
                compraDTO.setId_compra(rs.getInt(2));
                compraDTO.setSubtotal(rs.getDouble(3));
                compraDTO.setCantidad(rs.getInt(4));
                compraDTO.setEstado(rs.getInt(5));
                list.add(compraDTO);
            }
        } catch (Exception e) {
            System.out.println("Error DetalleCompraDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return list;
    }
         public boolean update(DetalleCompraDTO t) {
        boolean isUpdate = false;
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
            ps.setDouble(1, t.getSubtotal());
            ps.setInt(2, t.getCantidad());
            ps.setInt(3, t.getEstado());
            ps.setInt(4, t.getId_insumo());
            ps.setInt(5, t.getId_compra());
            isUpdate = (ps.executeUpdate() == 1) ? !isUpdate : isUpdate;
        } catch (Exception e) {
            System.out.println("Error DetalleCompraDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isUpdate;
    }
        public boolean delete(int key, int key2) {
        boolean isDeleted = false;
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE);
            ps.setInt(1, key);
            ps.setInt(2, key2);
            isDeleted = (ps.executeUpdate() == 1) ? !isDeleted : isDeleted;
        } catch (Exception e) {
            System.out.println("Error DetalleCompraDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isDeleted;
    }
    
}
