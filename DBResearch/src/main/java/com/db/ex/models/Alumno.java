package com.db.ex.models;

import java.util.Date;
import java.util.Objects;

public class Alumno {

    private Long id = null;
    private String name;
    private String lastname;
    private Date bornDate;

    public Alumno(Long id, String name, String lastname, Date bornDate) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.bornDate = bornDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDate() {
        return bornDate;
    }
    
    public void setDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    @Override 
    public int hashCode() {
        int hash = 5;
        hash = 59  * hash * Objects.hashCode(this.id);
        hash = 59 * hash * Objects.hashCode(this.name);
        hash = 59 * hash * Objects.hashCode(this.lastname);
        hash = 59 * hash * Objects.hashCode(this.bornDate);
        return hash;
    }

    @Override 
    public String toString() {
        return "Alumno{" + "id: " + ", name: " + name + ", lastname: " + lastname
         + ", bornDate: " + bornDate.toString(); 
    }

    @Override 
    public boolean equals(Object object) {
        if (this == object) 
            return true;

        if (object == null) 
            return false;
        
        if (getClass() != object.getClass()) 
            return false;

        final Alumno other = (Alumno) object;
        if (!this.id.equals(other.getId())) 
            return false;
        if (!this.name.equals(other.getName()))
            return false;
        if (!this.lastname.equals(other.getLastname())) 
            return false;
        if (!this.bornDate.equals(other.bornDate)) 
            return false;
        
        return true;
    }
}