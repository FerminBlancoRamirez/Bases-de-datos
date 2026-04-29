package com.example.basededatosconectada.models;

import org.bson.types.ObjectId;

public class alumno {
    private ObjectId id;
    private String nombre;
    private String apellidos;

    // Constructor vacío necesario para frameworks
    public alumno() {}

    public alumno(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    // Getters y Setters
    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    @Override
    public String toString() {
        return String.format("ID: %s | %s %s (%d años)", id, nombre, apellidos, edad);
    }
}
