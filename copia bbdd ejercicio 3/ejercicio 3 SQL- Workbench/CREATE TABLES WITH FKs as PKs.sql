-- Autora: Antonella Alares

USE Ejercicio3;

CREATE TABLE Reportes (
id_reporte INT AUTO_INCREMENT,
id_administrador INT NOT NULL,
nombre_reporte VARCHAR(45),
tipo_reporte VARCHAR(45),
texto_reporte VARCHAR(255),
PRIMARY KEY (id_reporte, id_administrador),
FOREIGN KEY (id_administrador) REFERENCES Administradores(id_administrador)
);

SELECT * FROM Reportes;

CREATE TABLE Notificaciones (
id_notificacion INT AUTO_INCREMENT,
id_promocion INT NOT NULL,
texto_notificacion VARCHAR(255) NOT NULL,
fecha_notificacion DATE NOT NULL, 
PRIMARY KEY (id_notificacion, id_promocion),
FOREIGN KEY (id_promocion) REFERENCES Promociones(id_promocion)
);

SELECT * FROM Notificaciones;


CREATE TABLE Promocion_producto (
id_producto INT, 
id_promocion INT,
precioFinal_producto FLOAT NOT NULL,
PRIMARY KEY (id_producto, id_promocion),
FOREIGN KEY (id_producto) REFERENCES Productos (id_producto),
FOREIGN KEY (id_promocion) REFERENCES Promociones (id_promocion)
);

SELECT * FROM Promocion_producto;

CREATE TABLE pedido_reporte (
id_reporte INT UNIQUE AUTO_INCREMENT, 
id_pedido INT,
id_administrador INT,
PRIMARY KEY (id_reporte, id_pedido, id_administrador),
FOREIGN KEY (id_reporte, id_administrador) REFERENCES Reportes (id_reporte, id_administrador),
FOREIGN KEY (id_pedido) REFERENCES Pedidos (id_pedido)
);


SELECT * FROM pedido_reporte;


CREATE TABLE producto_promocion_pedido (
id_producto INT,
id_promocion INT, 
id_pedido INT,
cantidad INT,
PRIMARY KEY (id_producto, id_promocion, id_pedido),
FOREIGN KEY (id_producto) REFERENCES Productos(id_producto), -- cuidado porque al crear la FK de unas que ya son PK en otra tabla, debes respetar el orden en el que están esos atributos en esa PK
FOREIGN KEY (id_promocion) REFERENCES Promociones(id_promocion),
FOREIGN KEY (id_pedido) REFERENCES Pedidos (id_pedido)
);

SELECT * FROM producto_promocion_pedido;

commit;