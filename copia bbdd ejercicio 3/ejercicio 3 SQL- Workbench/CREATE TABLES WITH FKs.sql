-- Autora: Antonella Alares

USE Ejercicio3;

CREATE TABLE Usuarios (
id_usuario INT,
PRIMARY KEY (id_usuario),
FOREIGN KEY (id_usuario) REFERENCES Personas(id_persona)
);

SELECT * FROM Usuarios;

CREATE TABLE Administradores (
id_administrador INT,
PRIMARY KEY (id_administrador),
FOREIGN KEY (id_administrador) REFERENCES Personas(id_persona)
);

SELECT * FROM Administradores;

CREATE TABLE Promociones (
id_promocion INT AUTO_INCREMENT,
id_administrador INT NOT NULL,
texto_promocion VARCHAR(255) NOT NULL,
precioDescuento_promocion FLOAT NOT NULL,
fechaInicio_promocion DATE NOT NULL, 
fechaFinal_promocion DATE NOT NULL,
PRIMARY KEY (id_promocion),
FOREIGN KEY (id_administrador) REFERENCES Administradores(id_administrador)
);

SELECT * FROM Promociones;

CREATE TABLE Tarjetas (
id_tarjeta INT AUTO_INCREMENT,
id_usuarioTarjeta INT NOT NULL,
numero_tarjeta VARCHAR(16) NOT NULL,
clave_tarjeta INT NOT NULL,
fechaCaducidad_tarjeta DATE, 
PRIMARY KEY (id_tarjeta),
FOREIGN KEY (id_usuarioTarjeta) REFERENCES Usuarios(id_usuario)
);

SELECT * FROM Tarjetas;

CREATE TABLE Pedidos (
id_pedido INT AUTO_INCREMENT,
id_usuario INT NOT NULL,
id_tarjeta INT NOT NULL,
cantidad_pedido INT,
precioTotal_pedido FLOAT,
estadoProcesando_pedido DATETIME,
estadoEnviado_pedido DATETIME,
estadoRecibido_pedido DATETIME,
estadoCancelado_pedido DATETIME,
fecha_pedido DATE, 
fechaEntrega_pedido DATE,
PRIMARY KEY (id_pedido),
FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario),
FOREIGN KEY (id_tarjeta) REFERENCES Tarjetas(id_tarjeta)
);

SELECT * FROM pedidos;

-- para poder eliminar tablas sin que nos entorpezca lo de las FKs: set foreign_key_checks = 0;


commit;


