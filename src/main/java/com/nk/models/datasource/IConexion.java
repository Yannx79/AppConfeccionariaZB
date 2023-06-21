package com.nk.models.datasource;

import java.sql.Connection;

public interface IConexion {

    public final String USER = "root";
    public final String PASSWORD = "";
    public final String URL = "jdbc:mysql://localhost:3306/db_veterinaria";
    public final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public abstract Connection getConnection();

    public abstract void closeConexion();

}
