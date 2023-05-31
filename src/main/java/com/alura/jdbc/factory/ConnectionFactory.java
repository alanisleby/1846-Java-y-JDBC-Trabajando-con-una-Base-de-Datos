package com.alura.jdbc.factory;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;
public class ConnectionFactory {
    private final  DataSource datasource;
    public ConnectionFactory(){
        var comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("alanis123");
        comboPooledDataSource.setMaxPoolSize(10);

        this.datasource = comboPooledDataSource;
    }
    // asi estaba:
    // public Connection recuperaConexion() throws SQLException {
    // pero faltaba eliminar el "throws SQLException"
    public Connection recuperaConexion() {
        try{
            return this.datasource.getConnection();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}

