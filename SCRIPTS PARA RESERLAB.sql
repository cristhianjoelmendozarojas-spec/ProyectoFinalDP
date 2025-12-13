create database ReserLab;
use ReserLab;

/*TABLAS*/

#USUARIOS
CREATE TABLE usuarios (
    id_usuario CHAR(8) PRIMARY KEY NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    clave VARCHAR(50) NOT NULL,
    tipo ENUM('Docente', 'Estudiante','admin') NOT NULL,
    email VARCHAR(100)
);

#LABORATORIOS
CREATE TABLE laboratorios (
    id_laboratorio INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    capacidad INT NOT NULL,
    estado BOOLEAN DEFAULT TRUE
);

#RESERVAS
CREATE TABLE reservas (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario char(8) NOT NULL,
    id_laboratorio INT NOT NULL,
    fecha DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    estado ENUM('Pendiente', 'Confirmada', 'Cancelada') DEFAULT 'Pendiente',
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_laboratorio) REFERENCES laboratorios(id_laboratorio)
);


#INSERTANDO REGISTROS
#USUARIOS
INSERT INTO usuarios (id_usuario,nombre, clave, tipo, email) VALUES
('72263061','Cristhian Mendoza','1234', 'Docente', 'cristhian@universidad.edu'),
('12345678','Ana Torres','1234', 'Estudiante', 'ana@gmail.com'),
('88888888','admin','1234', 'admin', 'ana@gmail.com')
;

#LABORATORIOS
INSERT INTO laboratorios (nombre, capacidad, estado) VALUES
('Lab 101', 25, 1),
('Lab 102', 20, 1),
('Lab 103', 30, 1);

#RESERVAS

INSERT INTO reservas (id_usuario, id_laboratorio, fecha, hora_inicio, hora_fin, estado)
VALUES ('72263061', 1, '2025-11-29', '21:30:00', '22:30:00', 'Confirmada');

#CONSULTA
select * from laboratorios;
select * from reservas;
select * from usuarios;


#VISTA RESERVA COMPLETA
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
 
#CONSULTA VISTA COMPLETA 
select * from vista_reservas_completa;

#VISTA PARA LISTAR LABORATORIOS
CREATE OR REPLACE VIEW vista_listar_laboratorios AS
SELECT 
    l.id_laboratorio,
    l.nombre,
    l.capacidad, 
    CASE 
        WHEN EXISTS (
            SELECT 1 FROM reservas r 
            WHERE r.id_laboratorio = l.id_laboratorio 
            AND r.estado = 'Confirmada'
            AND CURDATE() = r.fecha  -- Solo reservas de hoy
        ) THEN 'Ocupado'
        ELSE 'Disponible'
    END AS estado
FROM laboratorios l
ORDER BY l.id_laboratorio;


#CONSULTA DE VISTA PARA LISTAR LABORATORIOS
select * from vista_listar_laboratorios;


#ELIMINAR REGISTROS DE TABLA RESERVAS
TRUNCATE TABLE reservas;

#ELIMINAR REGISTROS POR FECHA
DELETE FROM reservas WHERE fecha = '2025-12-12';