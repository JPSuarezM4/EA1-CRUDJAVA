USE funcionariosdb;

INSERT INTO Funcionario (tipoid, numeroid, nombres, apellidos, estadocivil, sexo, direccion, telefono, fechanacimiento)
VALUES ('Cédula', '123456789', 'John', 'Doe', 'Soltero', 'M', 'Calle 123', '1234567890', '1990-01-01'),
('Cédula', '900000', 'maick', 'dan', 'Casado', 'M', 'Calle 12', '3333333', '1995-05-05');

INSERT INTO GrupoFamiliar (funcionarioid, nombres, apellidos, parentesco)
VALUES (1, 'Jane', 'Doe', 'Esposa');

INSERT INTO InformacionAcademica (funcionarioid, universidad, nivelestudio, tituloestudio)
VALUES (1, 'Universidad XYZ', 'Licenciatura', 'Licenciado en Informática');

select * from funcionario