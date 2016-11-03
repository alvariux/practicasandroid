package com.example.tecnologico.listasqlite;

import java.io.Serializable;

/**
 * Created by tecnologico on 17/10/2016.
 */
public class Persona implements Serializable {

    private String nombre;
    private String email;
    private String telefono;
    private int id;

    public Persona()
    {
        this.id = 0;
        this.nombre = "";
        this.email = "";
        this.telefono = "";
    }
    public Persona(int id,String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
