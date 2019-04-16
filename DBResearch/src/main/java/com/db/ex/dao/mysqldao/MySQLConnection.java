package com.db.ex.dao.mysqldao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
public class MySQLConnection {
    public Connection connect() {
        Connection connection = null;
        try {
            String user = "root";
            String password = "admin";
            String link = "jdbc:mysql://localhost/studentsys";
            Class.forName("com.jdbc.mysql.Driver");
            connection =  DriverManager.getConnection(link, user, password);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

}