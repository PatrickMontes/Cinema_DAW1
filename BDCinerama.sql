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
    imagen VARCHAR(300) NOT NULL
);

CREATE TABLE Sede (
    sede_id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    ubicacion VARCHAR(255) NOT NULL
);

INSERT INTO Sede (nombre, ubicacion) VALUES 
('Cinerama Pacifico', 'AV JOSE PARDO 121 MIRAFLORES - LIMA - LIMA'),
('Cinerama Minka', 'AV ARGENTINA 3093 CC MINKA 2DO NIVEL CALLAO - CALLAO - CALLAO'),
('Cinerama Quinde', 'AV LOS MAESTROS S/N CC EL QUINDE'),
('Cinerama Tarapoto', 'AV ALFONSO UGARTE 1360 SAN MARTIN - SAN MARTIN - TARAPOTO'),
('Cinerama Cajamarca', 'JR SOR MANUELA GIL 151 CC EL QUINDE CAJAMARCA- CAJAMARCA - CAJAAMRCA'),
('Cinerama Sol', 'AV SAN MARTIN 727 CC PLAZA DEL SOL ICA - ICA - ICA'),
('Cinerama Huacho', 'COLON 601 CC PLAZA DEL SOL 2DO NIVEL'),
('Cinerama Moyobamba', 'JR MANUEL DEL AGUILA 542 MOYOBAMBA'),
('Cinerama Cusco', 'CALLE CRUZ VERDE 347 CC IMPERIAL Â´PLAZA CUSCO - CUSCO - CUSCO'),
('Cinerama Chimbote', 'AV. V. RAUL H. DE LA TORRE MZA. B LOTE. 1A SECTOR CAMPO FERIAL SAN P ANCASH SANTA CHIMBOTE');


select * from Sede;


CREATE TABLE Salas (
      sala_id INT PRIMARY KEY AUTO_INCREMENT,
      nombre VARCHAR(30) NOT NULL,
      sede_id INT,
      FOREIGN KEY (sede_id) REFERENCES Sede(sede_id)
);

INSERT INTO Salas (nombre, sede_id) VALUES ('Sala 1', 1);
INSERT INTO Salas (nombre, sede_id) VALUES ('Sala 2', 2);
INSERT INTO Salas (nombre, sede_id) VALUES ('Sala 3', 3);
INSERT INTO Salas (nombre, sede_id) VALUES ('Sala 4', 4);
INSERT INTO Salas (nombre, sede_id) VALUES ('Sala 5', 5);
INSERT INTO Salas (nombre, sede_id) VALUES ('Sala 6', 6);
INSERT INTO Salas (nombre, sede_id) VALUES ('Sala 7', 7);
INSERT INTO Salas (nombre, sede_id) VALUES ('Sala 8', 8);
INSERT INTO Salas (nombre, sede_id) VALUES ('Sala 9', 9);
INSERT INTO Salas (nombre, sede_id) VALUES ('Sala 10', 10);


select * from Salas;

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
    asiento_id  INT,
    estado_reserva ENUM('Confirmada', 'Cancelada') DEFAULT 'Confirmada',
    fecha_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id),
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