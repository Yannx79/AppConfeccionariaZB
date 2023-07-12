package com.nk.models.dao;

import com.nk.models.dto.CompraDTO;
import com.nk.models.idao.ICompraDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class CompraDAO implements ICompraDAO<CompraDTO, Integer> {
        @Override
    public boolean create(CompraDTO t) {
        boolean isCreated = false;
        try {
            Connection connection = CONEXION.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_CREATE);
            ps.setInt(1, t.getId_proveedor());
            ps.setInt(2, t.getId_usuario());
            ps.setDouble(3, t.getTotal());
            ps.setString(4, t.getFecha());
            ps.setDouble(5, t.getImpuesto());
            ps.setInt(6, t.getEstado());
            isCreated = (ps.executeUpdate() == 1) ? !isCreated : isCreated;
        } catch (Exception e) {
            System.out.println("Error CompraDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isCreated;
    }
    
    @Override
    public CompraDTO read(Integer key) {
        CompraDTO compraDTO = new CompraDTO();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                compraDTO.setId_compra(rs.getInt(1));
                compraDTO.setId_proveedor(rs.getInt(2));
                compraDTO.setId_usuario(rs.getInt(3));
                compraDTO.setTotal(rs.getDouble(4));
                compraDTO.setFecha(rs.getString(5));
                compraDTO.setImpuesto(rs.getDouble(6));
                compraDTO.setEstado(rs.getInt(7));
            }
        } catch (Exception e) {
            System.out.println("Error CompraDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return compraDTO;
    }
    
        @Override
    public List<CompraDTO> readAll() {
        List<CompraDTO> list = new LinkedList<>();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                CompraDTO compraDTO = new CompraDTO();
                compraDTO.setId_compra(rs.getInt(1));
                compraDTO.setId_proveedor(rs.getInt(2));
                compraDTO.setId_usuario(rs.getInt(3));
                compraDTO.setTotal(rs.getDouble(4));
                compraDTO.setFecha(rs.getString(5));
                compraDTO.setImpuesto(rs.getDouble(6));
                compraDTO.setEstado(rs.getInt(7));
                list.add(compraDTO);
            }
        } catch (Exception e) {
            System.out.println("Error CompraDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return list;
    }
    
    @Override
    public boolean update(CompraDTO t) {
        boolean isUpdate = false;
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
            ps.setInt(1, t.getEstado());
            ps.setInt(2, t.getId_compra());
            isUpdate = (ps.executeUpdate() == 1) ? !isUpdate : isUpdate;
        } catch (Exception e) {
            System.out.println("Error CompraDAO: " + e);
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
            System.out.println("Error CompraDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isDeleted;
    }
    
}
