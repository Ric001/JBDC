package com.db.ex;

import com.db.ex.dao.mysqldao.MySQLConnection;
import java.util.logging.Logger;
public class App 
{
    private final static Logger LOGGER = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        LOGGER.info("Trying to Stablish Connection");
        if (MySQLConnection.connect() != null) {
            LOGGER.info("Connection Gotten");
        }
        System.exit(0);
    }    
    
}
