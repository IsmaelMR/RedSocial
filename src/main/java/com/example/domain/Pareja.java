package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity // Entidad PAREJA
public class Pareja {

    @Id
    @GeneratedValue
    private  Long id;
    @OneToOne
    private Persona persona1;
    @OneToOne
    private Persona persona2;

    public Pareja() {
    }

    public Pareja(Persona persona1, Persona persona2) {
        this.persona1 = persona1;
        this.persona2 = persona2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona1() {
        return persona1;
    }

    public void setPersona1(Persona persona1) {
        this.persona1 = persona1;
    }

    public Persona getPersona2() {
        return persona2;
    }

    public void setPersona2(Persona persona2) {
        this.persona2 = persona2;
    }

    @Override
    public String toString() {
        return "Pareja{" +
                "id=" + id +
                ", persona1=" + persona1 +
                ", persona2=" + persona2 +
                '}' + System.lineSeparator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pareja pareja = (Pareja) o;

        if (!getPersona1().equals(pareja.getPersona1())) return false;
        return getPersona2().equals(pareja.getPersona2());

    }

    @Override
    public int hashCode() {
        int result = getPersona1().hashCode();
        result = 31 * result + getPersona2().hashCode();
        return result;
    }
}
