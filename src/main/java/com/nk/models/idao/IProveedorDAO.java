package com.nk.models.idao;

import com.nk.models.datasource.Conexion;

public interface IProveedorDAO<T, K> extends IObjectDAO<T, K> {

    public static final String SQL_CREATE = "INSERT INTO `proveedor`(`nombres`, `ap_paterno`, "
            + "`ap_materno`, `ruc`, `dni`, `telefono`, `f_insercion`, "
            + "`estado`) VALUES (?, ?, ?, ?, ?, ?, curdate(), ?)";
    
    public static final String SQL_READ = "SELECT * FROM `proveedor` WHERE `id_proveedor` = ?";
    public static final String SQL_READ_ALL = "SELECT * FROM `proveedor` WHERE 1";
    public static final String SQL_UPDATE = "UPDATE `proveedor` SET `nombres`=?,"
            + "`ap_paterno`=?,`ap_materno`=?,`ruc`=?,"
            + "`dni`=?,`telefono`=?, `f_actualizacion`=curdate(),"
            + "`estado`=? WHERE `id_proveedor`=?";
    public static final String SQL_DELETE = "UPDATE `proveedor` SET `estado` = 0,`f_eliminacion` = curdate() "
            + "WHERE `id_proveedor`=?";
    public static final Conexion CONEXION = Conexion.getConexion();

}
