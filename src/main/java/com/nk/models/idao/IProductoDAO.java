package com.nk.models.idao;

import com.nk.models.datasource.Conexion;

public interface IProductoDAO<T, K> extends IObjectDAO<T, K>  {

    public static final String SQL_CREATE = "INSERT INTO `producto`(`nombre`, "
            + "`descripcion`, `precio`, `stock`, `estado`, `f_insercion`, "
            + "`f_actualizacion`, `f_eliminacion`, `descuento`) VALUES "
            + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_READ = "SELECT * FROM `producto` WHERE `id_producto` = ?";
    public static final String SQL_READ_ALL = "SELECT * FROM `producto` WHERE 1";
    public static final String SQL_UPDATE = "UPDATE `producto` SET `nombre`='?',"
            + "`descripcion`='?',`precio`='?',`stock`='?',"
            + "`estado`='?',`f_insercion`='?',"
            + "`f_actualizacion`='?',`f_eliminacion`='?',"
            + "`descuento`='?' WHERE `id_producto`='?'";
    public static final String SQL_DELETE = "UPDATE `producto` SET `estado` = 0 "
            + "WHERE `id_producto`='?'";
    public static final Conexion CONEXION = Conexion.getConexion();

}
