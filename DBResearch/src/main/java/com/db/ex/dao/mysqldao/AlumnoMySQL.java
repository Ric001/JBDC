package com.db.ex.dao.mysqldao;

import java.util.List;

import com.db.ex.dao.AlumnoDAO;
import com.db.ex.models.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlumnoMySQL implements AlumnoDAO {

    @Override
    public void add(Alumno t) {

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