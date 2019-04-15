package com.db.ex.dao.mysqldao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
public class MySQLConnection {
    public static Connection connect() {

        try {
            String user = "root";
            String password = "admin";
            String link = "jdbc:mysql://localhost/studentsys";
            return DriverManager.getConnection(link, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return null;
    }
}