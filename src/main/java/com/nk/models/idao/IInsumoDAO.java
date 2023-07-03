package com.nk.models.idao;

import com.nk.models.datasource.Conexion;

public interface IInsumoDAO<T, K> extends IObjectDAO<T, K> {

    public static final String SQL_CREATE = "INSERT INTO `insumo`(`nombre`, "
            + "`descripcion`, `precio`, `stock`, `estado`, `f_insercion`, "
            + "`descuento`) VALUES (?, ?, ?, ?, ?, curdate(), ?)";
    public static final String SQL_READ = "SELECT * FROM `insumo` WHERE `id_insumo` = ?";
    public static final String SQL_READ_ALL = "SELECT * FROM `insumo` WHERE 1";
    public static final String SQL_UPDATE = "UPDATE `insumo` SET `nombre`=?,"
            + "`descripcion`=?,`precio`=?,`stock`=?,`estado`=?,`f_actualizacion`=curdate(),"
            + "`descuento`=? WHERE `id_insumo`=?";
    public static final String SQL_DELETE = "UPDATE `insumo` SET `estado` = 0 "
            + "WHERE `id_insumo`=?";
    public static final Conexion CONEXION = Conexion.getConexion();

}
