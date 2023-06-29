
package com.nk.models.idao;
import com.nk.models.datasource.Conexion;
public interface IUsuarioDAO <T, K> extends IObjectDAO<T, K>{
public static final String SQL_CREATE = "INSERT INTO `usuario`(`nombres `, "
            + "`ap_paterno`, `ap_materno`, `usuario`, `pass`) VALUES "
            + "(?, ?, ?, ?, ?)";
 public static final String SQL_READ = "SELECT * FROM `usuario` WHERE `id_usuario` = ?";
    public static final String SQL_READ_ALL = "SELECT * FROM `usuario` WHERE 1";
    public static final String SQL_UPDATE = "UPDATE `usuario` SET `nombres`=?,"
    + "`ap_paterno`=?,`ap_materno`=?,`usuario`=?,"
            + "`estado`=?,`f_insercion`=?,"
            + "`pass`=?"
            + "`WHERE `id_usuario`=?";
    public static final String SQL_DELETE = "UPDATE `usuario` SET `estado` = 0 "
            + "WHERE `id_usuario`=?";
    public static final Conexion CONEXION = Conexion.getConexion();

}    
