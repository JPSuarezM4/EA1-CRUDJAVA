CREATE DATABASE funcionariosdb;

USE funcionariosdb;

CREATE TABLE Funcionario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipoid VARCHAR(20),
    numeroid VARCHAR(20),
    nombres VARCHAR(50),
    apellidos VARCHAR(50),
    estadocivil VARCHAR(20),
    sexo VARCHAR(10),
    direccion VARCHAR(100),
    telefono VARCHAR(20),
    fechanacimiento DATE
);

CREATE TABLE GrupoFamiliar (
    id INT PRIMARY KEY AUTO_INCREMENT,
    funcionarioid INT,
    nombres VARCHAR(50),
    apellidos VARCHAR(50),
    parentesco VARCHAR(20),
    FOREIGN KEY (funcionarioid) REFERENCES Funcionario(id)
);

CREATE TABLE InformacionAcademica (
    id INT PRIMARY KEY AUTO_INCREMENT,
    funcionarioid INT,
    universidad VARCHAR(100),
    nivelestudio VARCHAR(20),
    tituloestudio VARCHAR(100),
    FOREIGN KEY (funcionarioid) REFERENCES Funcionario(id)
);
