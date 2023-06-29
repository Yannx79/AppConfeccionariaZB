package com.nk.models.idao;

import com.nk.models.datasource.Conexion;

public interface IDetalleCompraDAO {
    
    public static final String SQL_CREATE = "INSERT INTO `detalle_compra` (`id_insumo`,"
            + "`id_compra`,`subtotal`,`cantidad`) VALUES (?,?,?,?)";
    public static final String SQL_READ = "SELECT * FROM `detalle_compra` "
            + "WHERE `id_insumo` = ? AND `id_compra` = ?";
    public static final String SQL_READ_ALL = "SELECT * FROM `detalle_compra`";
    public static final String SQL_UPDATE = "UPDATE `detalle_compra` SET `subtotal`=?,"
            + "`cantidad`=?,`estado`=? WHERE id_insumo = ? AND id_compra = ?";
    public static final String SQL_DELETE = "UPDATE `detalle_compra` SET `estado` = 0 "
            + "WHERE id_insumo = ? AND id_compra = ?";
    public static final Conexion CONEXION = Conexion.getConexion();
    
}
    

    

