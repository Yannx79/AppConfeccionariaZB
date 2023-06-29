
package com.nk.models.idao;

import com.nk.models.datasource.Conexion;
public interface IClienteDAO <T, K> extends IObjectDAO<T, K>{
 public static final String SQL_CREATE = "INSERT INTO `cliente` (`nombres`, "
            + "`ap_paterno `, `ap_materno `, `dni`, `telefono`, `f_insercion `, "
            + "`f_actualizacion `, `f_eliminacion `, `estado `) VALUES "
            + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";

public static final String SQL_READ = "SELECT * FROM `cliente` WHERE `id_cliente ` = ?";
    public static final String SQL_READ_ALL = "SELECT * FROM `cliente` WHERE 1";
    public static final String SQL_UPDATE = "UPDATE `cliente` SET `nombres`=?,"
+ "`ap_paterno`=?,`ap_materno`=?,`dni`=?,"
            + "`telefono`=?,`f_insercion`=?,"
            + "`f_actualizacion`=?,`f_eliminacion`=?,"
            + "`estado`=? WHERE `id_cliente `=?";
    public static final String SQL_DELETE = "UPDATE `cliente` SET `estado` = 0 "
            + "WHERE `id_cliente `=?";
    public static final Conexion CONEXION = Conexion.getConexion();

}
