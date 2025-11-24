package model.entities;

public class Laboratorio {
    private int IdLaboratorio;
    private String nombre;
    private int capacidad;
    private String estado;

    public Laboratorio(int IdLaboratorio, String nombre, int capacidad, String estado) {
        this.IdLaboratorio = IdLaboratorio;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    // getters
    public int getId() { return IdLaboratorio; }
    public String getNombre() { return nombre; }
    public int getCapacidad() { return capacidad; }
    public String getEstado() { return estado; }
}
