package com.db.ex.dao.mysqldao;

import java.util.List;

import com.db.ex.dao.AlumnoDAO;
import com.db.ex.models.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import java.util.logging.Logger;

public class AlumnoMySQL implements AlumnoDAO {

    public final String INSERT = "INSERT INTO ALUMNOS(NOMBRE, APELLIDOS, FECHA_NAC) VALUES (?,?,?)";
    public final String UPDATE = "UPDATE ALUMNOS SET NOMBRE = ?, SET APELLIDOS = ?, SET FECHA_NAC = ?";
    public final String DELETE = "DELETE FROM ALUMNOS WHERE ID_ALUMNO = ?";
    public final String GOTALL = "SELECT * FROM ALUMNOS";
    public final String GOTONE = "SELECT FROM ALUMNOS WHERE ID_ALUMNO = ?";


    private Connection connection;
    private PreparedStatement pStatement;
    private ResultSet resultSet;

    public final Logger LOGGER = Logger.getLogger(AlumnoMySQL.class.getName());

    @Override
    public void add(Alumno t) {
        try {
            connection = new MySQLConnection().connect();
            pStatement.setString(1, t.getName());
            pStatement.setString(2, t.getLastname());
            pStatement.setDate(3, new Date( t.getDate().getTime() ));
            
            if (pStatement.executeUpdate() == 0 ) {
                throw new SQLException();
            }
            
            LOGGER.info("Alumno Agregado en la Base de datos");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Alumno getById(Long k) {
        return null;
    }

    @Override
    public List<Alumno> toList() {
        return null;
    }

    @Override
    public void modify(Alumno t) {

    }

    @Override
    public void delete(Alumno t) {

    }
    
}