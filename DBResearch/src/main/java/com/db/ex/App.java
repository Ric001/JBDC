package com.db.ex;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;
public class App 
{
    private final static Logger LOGGER = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/BookSellerDB";
        String user = "root";
        String password = "admin";
        
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            if (!connection.isClosed()) {
                LOGGER.info("Connections Stablished Succesfully");
            }
            System.exit(0);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }    

    
}
