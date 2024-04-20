CREATE DATABASE CINEMA;
USE CINEMA;

CREATE TABLE Roles (
    rol_id INT PRIMARY KEY AUTO_INCREMENT,
    nombre ENUM('Administrador', 'Usuario') DEFAULT 'Usuario'
);

CREATE TABLE Usuarios (
    usuario_id INT PRIMARY KEY AUTO_INCREMENT,
    nombreusuario VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    nombres varchar(100) NOT NULL,
    apellidos varchar(100) NOT NULL,
    activo BOOL NULL
);

CREATE TABLE  UsuarioRol(
    usuario_id INT,
    rol_id INT,
    CONSTRAINT user_role_pk PRIMARY KEY (usuario_id, rol_id),
    CONSTRAINT user_role_FK FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id),
    CONSTRAINT user_role_FK_1 FOREIGN KEY (rol_id) REFERENCES Roles(rol_id)
);

CREATE TABLE Peliculas (
    pelicula_id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    genero VARCHAR(100) NOT NULL,
    duracion INT NOT NULL,
    imagen VARCHAR(300) NOT NULL,
    disponible BOOLEAN DEFAULT TRUE
);

CREATE TABLE Cines (
    cine_id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    ubicacion VARCHAR(255) NOT NULL
);

CREATE TABLE Salas (
      sala_id INT PRIMARY KEY AUTO_INCREMENT,
      nombre VARCHAR(30) NOT NULL,
      cine_id INT,
      FOREIGN KEY (cine_id) REFERENCES Cines(cine_id)
);

CREATE TABLE Horarios (
    horario_id INT PRIMARY KEY AUTO_INCREMENT,
    pelicula_id INT,
    sala_id INT,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    FOREIGN KEY (pelicula_id) REFERENCES Peliculas(pelicula_id),
    FOREIGN KEY (sala_id) REFERENCES Salas (sala_id)
); 
CREATE TABLE Asientos (
    asiento_id INT PRIMARY KEY AUTO_INCREMENT,
    sala_id INT,
    fila VARCHAR(10) NOT NULL,
    numero INT NOT NULL,
    disponible BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (sala_id) REFERENCES Salas(sala_id)
);

CREATE TABLE Reservas (
    reserva_id INT PRIMARY KEY AUTO_INCREMENT,
    usuario_id INT,
    horario_id INT,
    estado_reserva ENUM('Confirmada', 'Cancelada') DEFAULT 'Confirmada',
    fecha_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id),
    FOREIGN KEY (horario_id) REFERENCES Horarios(horario_id)
);

CREATE TABLE Pago (
    pago_id INT PRIMARY KEY AUTO_INCREMENT,
    reserva_id INT,
    monto DECIMAL(10, 2) NOT NULL,
    fecha_pago TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (reserva_id) REFERENCES Reservas(reserva_id)
);

CREATE TABLE Asientos_Reservados (
    asiento_reservado_id INT PRIMARY KEY AUTO_INCREMENT,
    reserva_id INT,
    asiento_id INT,
    FOREIGN KEY (reserva_id) REFERENCES Reservas(reserva_id),
    FOREIGN KEY (asiento_id) REFERENCES Asientos(asiento_id)
);
