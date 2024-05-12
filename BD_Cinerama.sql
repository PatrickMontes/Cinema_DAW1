CREATE DATABASE CINEMA;
USE CINEMA;

CREATE TABLE usuario (
    idusuario INT PRIMARY KEY AUTO_INCREMENT,
    nomusuario VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    nombres VARCHAR(25) NOT NULL,
    apellidos VARCHAR(30) NOT NULL,
    activo BOOLEAN NULL
);
select * from usuario

/**
 * CREDENCIALES : 
 * 			nomusuario:luisFelipe
 * 
 * 			password:admin123
 * **/


CREATE TABLE rol (
    idrol INT AUTO_INCREMENT NOT NULL,
    nomrol ENUM('Administrador','Usuario') DEFAULT 'Usuario',
    PRIMARY KEY (idrol)
);

INSERT INTO rol (nomrol) VALUES ('Administrador'), ('Usuario');

CREATE TABLE usuario_rol (
    idusuario INT NOT NULL,
    idrol INT NOT NULL,
    PRIMARY KEY (idusuario, idrol),
    FOREIGN KEY (idusuario) REFERENCES usuario(idusuario),
    FOREIGN KEY (idrol) REFERENCES rol(idrol)
);

/INSERT*/
INSERT INTO usuario (nomusuario, email, password, nombres, apellidos, activo)
VALUES ('admin', 'admin@gmail.com', '$2y$10$enedP1EYWRBzf0tnN1Cs3.jBlDSWuQmOBJgPFvee/zJXbLNAMLstO', 'John Jose', 'Doe Llontop', true);

INSERT INTO rol (nomrol) VALUES ('Administrador'), ('Usuario');

INSERT INTO usuario_rol (idusuario, idrol)
VALUES (1, 1);

CREATE TABLE Peliculas (
    pelicula_id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    genero VARCHAR(100) NOT NULL,
    duracion INT NOT NULL,
    imagen VARCHAR(300) NOT NULL
);

CREATE TABLE Sede (
    sede_id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    ubicacion VARCHAR(255) NOT NULL
);

INSERT INTO Sede (nombre, ubicacion) VALUES 
('Cinerama Pacifico', 'AV JOSE PARDO 121 MIRAFLORES - LIMA - LIMA');


select * from Sede;


CREATE TABLE Salas (
      sala_id INT PRIMARY KEY AUTO_INCREMENT,
      nombre VARCHAR(30) NOT NULL,
      sede_id INT,
      FOREIGN KEY (sede_id) REFERENCES Sede(sede_id)
);

INSERT INTO Salas (nombre, sede_id) VALUES ('Sala 1', 1);


select * from Salas;

CREATE TABLE Horarios (
    horario_id INT PRIMARY KEY AUTO_INCREMENT,
    sede_id INT,
    pelicula_id INT,
    sala_id INT,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    FOREIGN KEY (sede_id) REFERENCES Sede(sede_id),
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

INSERT INTO Asientos (sala_id, fila, numero, disponible)
VALUES (1, 'A', 1, true);
       

    select * from Asientos;


CREATE TABLE Reservas (
    reserva_id INT PRIMARY KEY AUTO_INCREMENT,
    idusuario INT,
    horario_id INT,
    asiento_id  INT,
    estado_reserva ENUM('Confirmada', 'Cancelada') DEFAULT 'Confirmada',
    fecha_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (idusuario) REFERENCES usuario(idusuario),
    FOREIGN KEY (asiento_id) REFERENCES Asientos(asiento_id),
    FOREIGN KEY (horario_id) REFERENCES Horarios(horario_id)
);

CREATE TABLE Pago (
    pago_id INT PRIMARY KEY AUTO_INCREMENT,
    reserva_id INT,
    monto DECIMAL(10, 2) NOT NULL,
    fecha_pago TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (reserva_id) REFERENCES Reservas(reserva_id)
);

 