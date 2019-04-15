package com.db.ex.models;

import java.util.Objects;
import java.util.Date;

public class Matricula {   
    private Long alumno;
    private Long asignatura;
    private Date bornDate;
    private int grade;

    public Matricula(Long alumno, Long asignatura, Date bornDate, int grade) {
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.bornDate = bornDate;
        this.grade = grade;
    }

    public Long getAlumno() {
        return alumno;
    }

    public void setAlumno(Long alumno) {
        this.alumno = alumno;
    }

    public Long getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Long asignatura) {
        this.asignatura = asignatura;
    }
    
    public Date getDate() {
        return bornDate;
    }

    public void setDate(Date date) {
        bornDate = date;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append("{ alumno: ".concat(alumno.toString()))
            .append(", asignatura: ".concat(asignatura.toString()))
            .append(", fecha_nac: ".concat(bornDate.toString()).concat("}"))
            .toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 12 * hash * Objects.hashCode(alumno);
        hash = 12 * hash * Objects.hashCode(asignatura);
        hash = 12 * hash * Objects.hashCode(bornDate); 
        hash = 12 * hash * Objects.hashCode(grade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null) 
            return false;
        if (getClass() != obj.getClass())
            return false;
        
        Matricula matricula = (Matricula) obj;
        if (!alumno.equals(matricula.getAlumno()))
            return false;
        if (!asignatura.equals(matricula.getAsignatura()))
            return false;
        if (!bornDate.equals(matricula.getDate()))
            return false;
        if (grade != matricula.getGrade())
            return false;

        return true;
    }
}