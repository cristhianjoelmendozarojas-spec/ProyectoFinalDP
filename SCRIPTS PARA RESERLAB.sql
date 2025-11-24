create database ReserLab
;
use ReserLab;

CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    clave VARCHAR(50) NOT NULL,
    tipo_usuario ENUM('Docente', 'Estudiante','admin') NOT NULL,
    correo VARCHAR(100)
);

INSERT INTO usuarios (nombre, clave, tipo_usuario, correo) VALUES
('Cristhian Mendoza','1234', 'Docente', 'cristhian@universidad.edu'),
('Ana Torres','1234', 'Estudiante', 'ana@gmail.com'),
('admin','1234', 'admin', 'ana@gmail.com')
;

CREATE TABLE laboratorios (
    id_laboratorio INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    capacidad INT NOT NULL,
    disponible BOOLEAN DEFAULT TRUE
);

INSERT INTO laboratorios (nombre, capacidad, disponible) VALUES
('Lab 101', 25, TRUE),
('Lab 102', 20, FALSE),
('Lab 103', 30, TRUE);

INSERT INTO laboratorios (nombre, capacidad, disponible) VALUES
('Lab 109', 25, false);

CREATE TABLE reservas (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_laboratorio INT NOT NULL,
    fecha DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    estado ENUM('Pendiente', 'Confirmada', 'Cancelada') DEFAULT 'Pendiente',

    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_laboratorio) REFERENCES laboratorios(id_laboratorio)
);


INSERT INTO reservas (id_usuario, id_laboratorio, fecha, hora_inicio, hora_fin, estado)
VALUES (1, 1, '2025-10-19', '08:30:00', '15:30:00', 'Confirmada');


use reserlab;
select * from laboratorios;
select * from reservas;

CREATE VIEW vista_reservas_completa AS
SELECT 
    r.id_reserva,
    u.nombre AS usuario,
    l.nombre AS laboratorio,
    r.fecha,
    r.hora_inicio,
    r.hora_fin,
    r.estado
FROM reservas r
INNER JOIN usuarios u ON r.id_usuario = u.id_usuario
INNER JOIN laboratorios l ON r.id_laboratorio = l.id_laboratorio;
 
select * from vista_reservas_completa;

select * from laboratorios;

create or replace view vista_listar_laboratorios as
SELECT 
	id_laboratorio,
    nombre,
    capacidad,
    CASE 
        WHEN disponible = 1 THEN 'Ocupado'
        ELSE 'Disponible'
    END AS estado
FROM laboratorios;

select * from vista_listar_laboratorios;
select * from vista_reservas_completa;
