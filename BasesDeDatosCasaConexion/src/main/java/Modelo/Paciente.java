package Modelo;

import org.bson.types.ObjectId;

public class Paciente {
    private ObjectId id;
    private String nombre;
    private int edad;
    private String raza;
    private String tipoEnfermedad;

    //constructor vacio el cual usara Mongo para reconstruir el objeto
    //sin el fallara
    public Paciente() {
    }

    //Constructor con parametros para poder crear nuevos pacientes
    //desde el codigo


    public Paciente(ObjectId id, String nombre, int edad,
                    String raza, String tipoEnfermedad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.tipoEnfermedad = tipoEnfermedad;
    }

    //getter y setters para poder modificar los atributos y acceder a ellos
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipoEnfermedad() {
        return tipoEnfermedad;
    }

    public void setTipoEnfermedad(String tipoEnfermedad) {
        this.tipoEnfermedad = tipoEnfermedad;
    }

    //toString
    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", raza='" + raza + '\'' +
                ", tipoEnfermedad='" + tipoEnfermedad + '\'' +
                '}';
    }
}
