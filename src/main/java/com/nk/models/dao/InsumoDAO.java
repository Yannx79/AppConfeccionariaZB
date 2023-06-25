package com.nk.models.dao;

import com.nk.models.dto.InsumoDTO;
import com.nk.models.idao.IInsumoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class InsumoDAO implements IInsumoDAO<InsumoDTO, Integer> {

    @Override
    public boolean create(InsumoDTO t) {
        boolean isCreated = false;
        try {
            Connection connection = CONEXION.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_CREATE);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getDescripcion());
            ps.setDouble(3, t.getPrecio());
            ps.setInt(4, t.getStock());
            ps.setInt(5, t.getEstado());
            ps.setString(6, t.getFechaInserccion());
            ps.setString(7, t.getFechaActualizacion());
            ps.setString(8, t.getFechaEliminacion());
            ps.setDouble(9, t.getDescuento());
            isCreated = (ps.executeUpdate() == 1) ? !isCreated : isCreated;
        } catch (Exception e) {
            System.out.println("Error InsumoDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isCreated;
    }

    @Override
    public InsumoDTO read(Integer key) {
        InsumoDTO insumoDTO = new InsumoDTO();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                insumoDTO.setIdInsumo(rs.getInt(1));
                insumoDTO.setNombre(rs.getString(2));
                insumoDTO.setDescripcion(rs.getString(3));
                insumoDTO.setPrecio(rs.getDouble(4));
                insumoDTO.setStock(rs.getInt(5));
                insumoDTO.setEstado(rs.getInt(6));
                insumoDTO.setFechaInserccion(rs.getString(7));
                insumoDTO.setFechaActualizacion(rs.getString(8));
                insumoDTO.setFechaEliminacion(rs.getString(9));
                insumoDTO.setDescuento(rs.getDouble(10));
            }
        } catch (Exception e) {
            System.out.println("Error InsumoDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return insumoDTO;
    }

    @Override
    public List<InsumoDTO> readAll() {
        List<InsumoDTO> list = new LinkedList<>();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                InsumoDTO insumoDTO = new InsumoDTO();
                insumoDTO.setIdInsumo(rs.getInt(1));
                insumoDTO.setNombre(rs.getString(2));
                insumoDTO.setDescripcion(rs.getString(3));
                insumoDTO.setPrecio(rs.getDouble(4));
                insumoDTO.setStock(rs.getInt(5));
                insumoDTO.setEstado(rs.getInt(6));
                insumoDTO.setFechaInserccion(rs.getString(7));
                insumoDTO.setFechaActualizacion(rs.getString(8));
                insumoDTO.setFechaEliminacion(rs.getString(9));
                insumoDTO.setDescuento(rs.getDouble(10));
                list.add(insumoDTO);
            }
        } catch (Exception e) {
            System.out.println("Error InsumoDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return list;
    }

    @Override
    public boolean update(InsumoDTO t) {
        boolean isUpdate = false;
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getDescripcion());
            ps.setDouble(3, t.getPrecio());
            ps.setInt(4, t.getStock());
            ps.setInt(5, t.getEstado());
            ps.setString(6, t.getFechaInserccion());
            ps.setString(7, t.getFechaActualizacion());
            ps.setString(8, t.getFechaEliminacion());
            ps.setDouble(9, t.getDescuento());
            ps.setInt(10, t.getIdInsumo());
            isUpdate = (ps.executeUpdate() == 1) ? !isUpdate : isUpdate;
        } catch (Exception e) {
            System.out.println("Error InsumoDAO: " + e);
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
            System.out.println("Error InsumoDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isDeleted;
    }

}
