package com.nk.models.idao;

import com.nk.models.datasource.Conexion;

public interface IDetalleVentaDAO{

    public static final String SQL_CREATE = "INSERT INTO `detalle_venta` (`id_producto`,"
            + "`id_venta`,`subtotal`,`cantidad`) VALUES (?,?,?,?)";
    public static final String SQL_READ = "SELECT * FROM `detalle_venta` "
            + "WHERE `id_producto` = ? AND `id_venta` = ?";
    public static final String SQL_READ_ALL = "SELECT * FROM `detalle_venta`";
    public static final String SQL_UPDATE = "UPDATE `detalle_venta` SET `subtotal`=?,"
            + "`cantidad`=?,`estado`=? WHERE id_producto = ? AND id_venta = ?";
    public static final String SQL_DELETE = "UPDATE `detalle_venta` SET `estado` = 0 "
            + "WHERE id_producto = ? AND id_venta = ?";
    public static final Conexion CONEXION = Conexion.getConexion();
}
