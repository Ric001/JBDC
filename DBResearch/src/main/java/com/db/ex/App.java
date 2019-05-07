package com.db.ex;

import com.db.ex.dao.AlumnoDAO;
import com.db.ex.dao.DAO;
import com.db.ex.dao.mysqldao.AlumnoMySQL;
import com.db.ex.dao.mysqldao.MySQLConnection;

import java.util.Date;
import java.util.UUID;
import java.util.logging.Logger;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import com.db.ex.models.Alumno;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import static java.lang.System.out;

public class App {
    private final static Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws SQLException {

        LOGGER.info("Initing Execution");
        String url = "jdbc:mysql://localhost:3306/BookSellerDB";
        String user = "root";
        String pass = "admin";
        Connection connection = DriverManager.getConnection(url, user, pass);
        Statement stm = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String query = "SELECT * FROM Books WHERE Price > 100";
        ResultSet rs = stm.executeQuery(query);
        final int TYPE = ResultSet.TYPE_SCROLL_INSENSITIVE;
        DatabaseMetaData dbmd = connection.getMetaData();
        
        final String INSERT_NEW_EMPLOYEE = "INSERT INTO Employees(FirstName, LastName, Phone, Salary, Designation) VALUES (? , ? , ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(INSERT_NEW_EMPLOYEE);

        int counter = 0; 
            String[] firsts = {"Rick", "Ursula"};
            String[] lasts = {"Sanchez", "Mercury"};
            String[] designation = {"Scientific", "CEO"};
            for (int i = 0; i < designation.length; i++) {
                String employeeId = UUID.randomUUID().toString();
                System.out.println(employeeId);
                ps.setString(1, firsts[i]);
                ps.setString(2, lasts[i]);
                ps.setString(3, "99900");
                ps.setDouble(4, 999.99);
                ps.setString(5, designation[i]);
                ps.addBatch();
            }      
            counter++;
         
        ps.executeBatch();
        System.exit(0);
    }

    

    private static void dbMetaData(Connection conn) throws SQLException{
        if (conn != null) {
            DatabaseMetaData dbmd = conn.getMetaData();
            if (dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                out.print("Supports TYPE_FORWARD_ONLY");
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    out.println(" and supports CONCUR_UPDATEBLE");
                }
            }

            if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                out.println("Supports TYPE_SCROLL_INSENSITIVE");
            
                if (dbmd.supportsResultSetConcurrency( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    out.println("Supports CONCUR_UPDATABLE");
                    
                }
            }

            if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                out.print("Supports TYPE_SCROLL_SENSITIVE");

                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    out.print("Supports CONCUR_UPDATABLE TOO");
                }
            }
        }
    }

    
}
