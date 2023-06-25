package com.nk.models.dao;

import com.nk.models.dto.ProductoDTO;
import com.nk.models.idao.IProductoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class ProductoDAO implements IProductoDAO<ProductoDTO, Integer> {

    @Override
    public boolean create(ProductoDTO t) {
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
            System.out.println("Error ProductoDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isCreated;
    }

    @Override
    public ProductoDTO read(Integer key) {
        ProductoDTO productoDTO = new ProductoDTO();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                productoDTO.setIdProducto(rs.getInt(1));
                productoDTO.setNombre(rs.getString(2));
                productoDTO.setDescripcion(rs.getString(3));
                productoDTO.setPrecio(rs.getDouble(4));
                productoDTO.setStock(rs.getInt(5));
                productoDTO.setEstado(rs.getInt(6));
                productoDTO.setFechaInserccion(rs.getString(7));
                productoDTO.setFechaActualizacion(rs.getString(8));
                productoDTO.setFechaEliminacion(rs.getString(9));
                productoDTO.setDescuento(rs.getDouble(10));
            }
        } catch (Exception e) {
            System.out.println("Error ProductoDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return productoDTO;
    }

    @Override
    public List<ProductoDTO> readAll() {
        List<ProductoDTO> list = new LinkedList<>();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductoDTO productoDTO = new ProductoDTO();
                productoDTO.setIdProducto(rs.getInt(1));
                productoDTO.setNombre(rs.getString(2));
                productoDTO.setDescripcion(rs.getString(3));
                productoDTO.setPrecio(rs.getDouble(4));
                productoDTO.setStock(rs.getInt(5));
                productoDTO.setEstado(rs.getInt(6));
                productoDTO.setFechaInserccion(rs.getString(7));
                productoDTO.setFechaActualizacion(rs.getString(8));
                productoDTO.setFechaEliminacion(rs.getString(9));
                productoDTO.setDescuento(rs.getDouble(10));
                list.add(productoDTO);
            }
        } catch (Exception e) {
            System.out.println("Error ProductoDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return list;
    }

    @Override
    public boolean update(ProductoDTO t) {
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
            ps.setInt(10, t.getIdProducto());
            isUpdate = (ps.executeUpdate() == 1) ? !isUpdate : isUpdate;
        } catch (Exception e) {
            System.out.println("Error ProductoDAO: " + e);
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
            System.out.println("Error ProductoDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isDeleted;
    }

}
