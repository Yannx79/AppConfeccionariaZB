package com.nk.models.idao;

import com.nk.models.datasource.Conexion;

public interface ICompraDAO<T, K> extends IObjectDAO<T, K> {

    public static final String SQL_CREATE = "INSERT INTO `compra`(`id_proveedor`, "
            + "`id_usuario`,`total`,`fecha`,`impuesto`,`estado`) VALUES "
            + "(?, ?, ?, ?, ?, ?)";
    public static final String SQL_READ = "SELECT `id_compra`,`id_proveedor`,"
            + "`id_usuario`,`total`,DATE_FORMAT(`fecha`, '%d/%m/%Y') as `fecha`,"
            + "`impuesto`,`estado` FROM `compra` WHERE `id_compra` = ?";
    public static final String SQL_READ_ALL = "SELECT `id_compra`,`id_proveedor`,"
            + "`id_usuario`,`total`,DATE_FORMAT(`fecha`, '%d/%m/%Y') as `fecha`,"
            + "`impuesto`,`estado` FROM `compra`";
    public static final String SQL_UPDATE = "UPDATE `compra` SET `estado`=? "
            + "WHERE `id_compra`=?";
    public static final String SQL_DELETE = "UPDATE `compra` SET `estado` = 0 "
            + "WHERE `id_compra`=?";
    public static final Conexion CONEXION = Conexion.getConexion();
}
