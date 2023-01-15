package org.example;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(value = "/init", loadOnStartup = 1)
public class StartupServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
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