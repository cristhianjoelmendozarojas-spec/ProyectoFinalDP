package model.entities;

public class Laboratorio {

    private int id;
    private String nombre;
    private int capacidad;
    private String estado;

    // Constructores
    public Laboratorio() {
    }

    public Laboratorio(int id, String nombre, int capacidad, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
