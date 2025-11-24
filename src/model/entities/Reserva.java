package model.entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {


private int idUsuario;
private int idLaboratorio;
private LocalDate fecha;
private LocalTime horaInicio;
private LocalTime horaFin;

public Reserva(int idUsuario, int idLaboratorio, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
    this.idUsuario = idUsuario;
    this.idLaboratorio = idLaboratorio;
    this.fecha = fecha;
    this.horaInicio = horaInicio;
    this.horaFin = horaFin;
}

public int getIdUsuario() {
    return idUsuario;
}

public int getIdLaboratorio() {
    return idLaboratorio;
}

public LocalDate getFecha() {
    return fecha;
}

public LocalTime getHoraInicio() {
    return horaInicio;
}

public LocalTime getHoraFin() {
    return horaFin;
}

}
