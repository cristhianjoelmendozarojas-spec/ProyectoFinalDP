package model.entities;

public class Usuario {

    private String idUsuario;
    private String nombre;
    private String email;
    private String tipo;

    public Usuario() {
    }

    public Usuario(String idUsuario, String nombre, String email, String tipo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.tipo = tipo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTipo() {
        return tipo;
    }
}
