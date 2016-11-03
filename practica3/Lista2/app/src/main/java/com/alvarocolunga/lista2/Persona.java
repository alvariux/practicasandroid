package com.alvarocolunga.lista2;

import java.io.Serializable;

public class Persona implements Serializable{
    private String nombre;
    private String email;
    private String telefono;
    private int foto;
    private static final long serialVersionUID = -1756210548913714481L;

    public Persona(String nombre, String email, String telefono,int foto) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.foto = foto;
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

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}

