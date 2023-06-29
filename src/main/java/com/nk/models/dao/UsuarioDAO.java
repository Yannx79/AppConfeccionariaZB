package com.nk.models.dao;

import com.nk.models.dto.UsuarioDTO;
import com.nk.models.idao.IUsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO<UsuarioDTO, Integer> {

    @Override
    public boolean create(UsuarioDTO t) {
        boolean isCreated = false;
        try {
            Connection connection = CONEXION.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_CREATE);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApPaterno());
            ps.setString(3, t.getApMaterno());
            ps.setString(4, t.getUsuario());
            ps.setString(5, t.getPass());

            isCreated = (ps.executeUpdate() == 1) ? !isCreated : isCreated;
        } catch (Exception e) {
            System.out.println("Error UsuarioDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isCreated;
    }

    @Override
    public UsuarioDTO read(Integer key) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuarioDTO.setIdUsuario(rs.getInt(1));
                usuarioDTO.setNombres(rs.getString(2));
                usuarioDTO.setApPaterno(rs.getString(3));
                usuarioDTO.setApMaterno(rs.getString(4));
                usuarioDTO.setUsuario(rs.getString(5));
                usuarioDTO.setPass(rs.getString(6));

            }
        } catch (Exception e) {
            System.out.println("Error UsuarioDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return usuarioDTO;
    }

    @Override
    public List<UsuarioDTO> readAll() {
        List<UsuarioDTO> list = new LinkedList<>();
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setIdUsuario(rs.getInt(1));
                usuarioDTO.setNombres(rs.getString(2));
                usuarioDTO.setApPaterno(rs.getString(3));
                usuarioDTO.setApMaterno(rs.getString(4));
                usuarioDTO.setUsuario(rs.getString(5));
                usuarioDTO.setPass(rs.getString(6));

                list.add(usuarioDTO);
            }
        } catch (Exception e) {
            System.out.println("Error InsumoDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return list;
    }

    @Override
    public boolean update(UsuarioDTO t) {
        boolean isUpdate = false;
        Connection connection = CONEXION.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApPaterno());
            ps.setString(3, t.getApMaterno());
            ps.setString(4, t.getUsuario());
            ps.setString(5, t.getPass());
            ps.setInt(6, t.getIdUsuario());
            isUpdate = (ps.executeUpdate() == 1) ? !isUpdate : isUpdate;
        } catch (Exception e) {
            System.out.println("Error UsuarioDAO: " + e);
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
            System.out.println("Error UsuarioDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return isDeleted;
    }
}
