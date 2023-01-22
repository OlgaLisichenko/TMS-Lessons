package org.tms.decorator.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
            getConnection().createStatement().execute("DROP TABLE IF EXISTS cars");
            getConnection().createStatement().execute("" +
                                                     "create table cars (" +
                                                      "id varchar primary key, " +
                                                      "model varchar, " +
                                                      "carNumber varchar, " +
                                                      "owner varchar)" );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/cars", "postgres", "admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}