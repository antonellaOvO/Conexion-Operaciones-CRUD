-- Autora: Antonella Alares
CREATE DATABASE Ejercicio3;
USE Ejercicio3;

CREATE TABLE Personas (
id_persona INT NOT NULL AUTO_INCREMENT,
nombre_persona VARCHAR(45) NOT NULL,
apellido_persona VARCHAR(45) NOT NULL,
tipo  VARCHAR(45),
DNI VARCHAR(20) NOT NULL UNIQUE,
correo_persona VARCHAR(100) NOT NULL UNIQUE,
telefono_persona INT NOT NULL UNIQUE, 
contrasena_persona VARCHAR(50) NOT NULL,
fechaNacimiento_persona DATE NOT NULL,
direccion_persona VARCHAR(100) NOT NULL,
fechaCreacion_persona DATETIME DEFAULT NOW(),
PRIMARY KEY (id_persona)
);
 
SELECT * FROM Personas;


CREATE TABLE Productos (
id_producto INT  AUTO_INCREMENT, 
nombre_producto VARCHAR(250) NOT NULL,
categoria_producto VARCHAR (45) NOT NULL,
precio_producto FLOAT NOT NULL,
cantidad_producto INT NOT NULL, 
fechaCreacion_producto DATETIME NOT NULL,
fechaCaducidad_producto DATETIME NOT NULL,
PRIMARY KEY (id_producto)
);

SELECT * FROM Productos;

commit;