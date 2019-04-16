package com.db.ex;

import com.db.ex.dao.DAO;
import com.db.ex.dao.mysqldao.AlumnoMySQL;
import com.db.ex.dao.mysqldao.MySQLConnection;

import java.util.Date;
import java.util.logging.Logger;
import com.db.ex.models.Alumno;
public class App 
{
    private final static Logger LOGGER = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        AlumnoMySQL alumnoDao = new AlumnoMySQL();
        alumnoDao.add(new Alumno(new Long(1222222), "Julio", "Marin Perez", new Date()));
        System.exit(0);
    }    

    public void add (AlumnoDAO dao) {
        
    }
    
}
