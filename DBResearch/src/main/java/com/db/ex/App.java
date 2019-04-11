package com.db.ex;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.sql.Connection;
import java.util.Calendar;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.PreparedStatement;
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
        connection.setAutoCommit(false);
        
    }

    public void consulta() throws SQLException {
        String query = "SELECT * FROM PROFESORES WHERE PROFESORES.ID_PROFESOR = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, 1);
        ResultSet rs = stmt.executeQuery();
        System.out.println("Id Profesor - Nombre - Apellidos");
        while(rs.next()) {
            System.out.print(rs.getString("Id_Profesor").concat("\t"));
            
            System.out.print(rs.getString("Nombre").concat("\t"));
            
            System.out.print(rs.getString("Apellidos").concat("\t"));
        }
        rs.close();
        stmt.close();
    }

    public void transaccion() throws SQLException{
        final String ASIGNATURA = "INSERT INTO ALUMNOS(NOMBRE, APELLIDOS, FECHA_NAC) VALUES (?,?,?)";
        final String PROFESOR  = "INSERT INTO PROFESOR(NOMBRE, APELLIDOS) VALUES (?,?,?)";
        int ANSWER = 0;
        PreparedStatement profesor = null, asignatura = null;

        try {
            profesor = connection.prepareStatement(PROFESOR);
            profesor.setString(1, "Marcio");
            profesor.setString(2, "Perez");
            profesor.setDate(3, new Date(System.currentTimeMillis()));
            ANSWER = profesor.executeUpdate();

            if (ANSWER != PreparedStatement.EXECUTE_FAILED) {
                System.out.println("DATA INSERTED SUCCESFULLY");
            }
            
            asignatura = connection.prepareStatement(ASIGNATURA);
            asignatura.setString(1, "Fundamentos de Bases de Datos.");
            asignatura.setInt(2, 50);
            asignatura.executeUpdate();

            
        } catch (SQLException ex) {
            connection.rollback();
            ex.printStackTrace();
        } finally {
            if (profesor != null) {
                profesor.close();
            }

            if (asignatura != null) {
                asignatura.close();
            }
        }

    }
    public void cerrar() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    

    
}
