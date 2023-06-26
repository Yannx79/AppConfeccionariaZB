package com.nk.models.idao;

import com.nk.models.datasource.Conexion;

public interface IDetalleVentaDAO <T, K> extends IObjectDAO<T, K>  {

    public static final String SQL_CREATE = "INSERT INTO `venta`(`id_usuario`, "
            + "`id_cliente`, `total`,`impuesto`) VALUES "
            + "(?, ?, ?, ?)";
    public static final String SQL_READ = "SELECT `id_venta`,`id_usuario`,`id_cliente`,"
            + "`total`,DATE_FORMAT(`fecha`, '%d/%m/%Y')as `fecha`,"
            + "`impuesto`,`estado` FROM `venta` WHERE `id_venta` = ?";
    public static final String SQL_READ_ALL = "SELECT `id_venta`,`id_usuario`,`id_cliente`,"
            + "`total`,DATE_FORMAT(`fecha`, '%d/%m/%Y')as `fecha`,"
            + "`impuesto`,`estado` FROM `venta`";
    public static final String SQL_UPDATE = "UPDATE `venta` SET `id_usuario`=?,"
            + "`id_cliente`=?,`total`=?,`fecha`=now(),"
            + "`impuesto`=?,`estado`=? WHERE `id_venta`=?";
    public static final String SQL_DELETE = "UPDATE `venta` SET `estado` = 0 "
            + "WHERE `id_venta`=?";
    public static final Conexion CONEXION = Conexion.getConexion();
}
