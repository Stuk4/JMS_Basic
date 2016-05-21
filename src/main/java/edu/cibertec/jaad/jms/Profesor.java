package edu.cibertec.jaad.jms;

import java.io.Serializable;

/**
 * Created by Java-VS on 21/05/2016.
 */
public class Profesor implements Serializable{


    private String nombre;
    private String dni;

    /**
     * ctor
     * @param nombre
     * @param dni
     */
    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    /**
     * get nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * get dni
     * @return
     */
    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
