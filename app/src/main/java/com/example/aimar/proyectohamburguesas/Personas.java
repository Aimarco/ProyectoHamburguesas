package com.example.aimar.proyectohamburguesas;

import java.io.Serializable;

/**
 * Created by adminportatil on 04/02/2016.
 */
public class Personas implements Serializable {
    private String nombre,direccion;
    private int telefono;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
