package com.db.ex;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
public class App 
{
    static final Logger LOGGER = Logger.getLogger(App.class.getName());
    Connection connection; 
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        new App();   
        System.exit(0);
    }

    public App() throws SQLException {
        try {
            conectar();
            consulta();
        } finally {
            cerrar();
        }
    }

    public void conectar() throws SQLException{
        String jdbc = "jdbc:mysql://localhost:3306/StudentSys";
        connection = DriverManager.getConnection(jdbc, "root", "admin");
    }

    public void consulta() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("describe profesores");
        while(rs.next()) {
            System.out.println(rs.getString("field"));
        }
        rs.close();
        stmt.close();
    }

    public void cerrar() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    

    
}
