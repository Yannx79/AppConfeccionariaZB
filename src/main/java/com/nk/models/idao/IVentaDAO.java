package com.nk.models.idao;

import com.nk.models.datasource.Conexion;

public interface IVentaDAO<T, K> extends IObjectDAO<T, K> {
    
    public static final String SQL_CREATE = "INSERT INTO `venta`(`id_usuario`, "
            + "`id_cliente`, `total`,`impuesto`) VALUES "
            + "(?, ?, ?, ?)";
    public static final String SQL_READ = "SELECT * FROM `venta` WHERE `id_venta` = ?";
    public static final String SQL_READ_ALL = "SELECT * FROM `venta` WHERE 1";
    public static final String SQL_UPDATE = "UPDATE `venta` SET `id_usuario`=?,"
            + "`id_cliente`=?,`total`=?,`fecha`=now(),"
            + "`impuesto`=?,`estado`=? WHERE `id_venta`=?";
    public static final String SQL_DELETE = "UPDATE `venta` SET `estado` = 0 "
            + "WHERE `id_venta`=?";
    public static final Conexion CONEXION = Conexion.getConexion();
}
