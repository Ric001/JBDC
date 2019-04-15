package com.db.ex.models;

import java.util.Objects;

public class Profesor {
    
    private Long idProfesor;
    private String name; 
    private String lastname; 

    public Profesor(Long idProfesor, String name, String lastname) {
        this.idProfesor = idProfesor;
        this.name = name;
        this.lastname = lastname;
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    @Override 
    public String toString() {
        return new StringBuilder()
        .append("{ id: " + this.idProfesor)
        .append(", name: " + this.name)
        .append(", lastnames: " + this.lastname)
        .toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash * Objects.hashCode(this.idProfesor);
        hash = 29 * hash * Objects.hashCode(this.name);
        hash = 29 * hash * Objects.hashCode(this.lastname);
        return hash;
    }

    @Override 
    public boolean equals(Object object) {
        if ( this == object ) 
            return true;
        if ( object == null ) 
            return false;
        
        if ( getClass() != object.getClass() )
            return false;
        
        Profesor profesor = (Profesor) object;
        if (!idProfesor.equals(profesor.getIdProfesor())) 
            return false; 
        if (!name.equals(profesor.getName()))
            return false;
        if (!lastname.equals(profesor.getLastname()))
            return false;
        
        return true;
    }
} 