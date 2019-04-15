package com.db.ex.models;


public class Asignatura {
    private Long idAsignatura;
    private String name; 
    private Long teacher;

    public Asignatura(Long idAsignatura, String name, Long teacher) {
        this.idAsignatura = idAsignatura;
        this.name = name;
        this.teacher = teacher;
    }

    public Long getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTeacher() {
        return teacher;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idAsignatura == null) ? 0 : idAsignatura.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
            
        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Asignatura other = (Asignatura) obj;

        if (idAsignatura == null) {
            if (other.idAsignatura != null)
                return false;
        } else if (!idAsignatura.equals(other.idAsignatura))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (teacher == null) {
            if (other.teacher != null)
                return false;
        } else if (!teacher.equals(other.teacher))
            return false;
        
        return true;
    }

    
}