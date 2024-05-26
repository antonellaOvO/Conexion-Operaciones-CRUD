-- Autora: Antonella Alares

USE Ejercicio3;

-- INSERTAR DATOS TABLA PERSONAS (10 registros): -- Estos valores se han inyectado desde Java, y no desde SQL!
INSERT INTO Personas (nombre_persona, apellido_persona, tipo, DNI, correo_persona, telefono_persona, contrasena_persona, fechaNacimiento_persona, direccion_persona) 
VALUES 
('Juan', 'Pérez', "Usuario", '12345678A', 'juan@example.com', 123456789, 'contrasena123', '1990-05-15', 'Calle Principal 123'),
('María', 'Gómez', "Usuario", '98765432B', 'maria@example.com', 987654321, 'password456', '1995-10-20', 'Avenida Central 456'),
('Luis', 'Martínez', "Usuario", '56789012C', 'luis@example.com', 567890123, 'pass123word', '1988-03-25', 'Plaza Mayor 789'),
('Ana', 'Sánchez', "Usuario", '34567890D', 'ana@example.com', 345678901, 'securepass', '1992-12-10', 'Callejón Secreto 321'),
('Pedro', 'Rodríguez', "Usuario", '90123456E', 'pedro@example.com', 901234567, 'mysecretpass', '1985-07-08', 'Ronda de los Olivos 654'),
('Laura', 'López', "Usuario", '23456789F', 'laura@example.com', 234567890, 'password123', '1987-09-30', 'Avenida del Parque 987'),
('Carlos', 'García', "Usuario", '78901234G', 'carlos@example.com', 789012345, 'pass1234', '1993-02-18', 'Calle de las Flores 123'),
('Sofía', 'Fernández', "Usuario", '67890123H', 'sofia@example.com', 678901234, 'mysecurepassword', '1998-06-05', 'Paseo del Río 456'),
('David', 'Hernández', "Usuario", '45678901I', 'david@example.com', 456789012, 'securepassword123', '1994-11-12', 'Calle Mayor 456'),
('Elena', 'Pérez',  "Usuario",'89012345J', 'elena@example.com', 890123456, 'mysecretpassword123', '1991-04-28', 'Avenida de la Estación 789');

INSERT INTO Personas (nombre_persona, apellido_persona, tipo, DNI, correo_persona, telefono_persona, contrasena_persona, fechaNacimiento_persona, direccion_persona) 
VALUES 
('Antonella', 'Alares', "Administrador", '89015647J', 'antonella@example.com', 876123456, 'mysecretpassword123', '1991-04-30', 'Avenida de la Estación 739');
INSERT INTO Personas (nombre_persona, apellido_persona, tipo, DNI, correo_persona, telefono_persona, contrasena_persona, fechaNacimiento_persona, direccion_persona) 
VALUES 
('Victor', 'Martínez', "Administrador", '89018647J', 'victor@example.com', 876122156, 'mysecretpassword123', '1991-04-12', 'Avenida de la Estación 29');

SELECT * FROM Personas;

-- INSERTAR DATOS TABLA PRODUCTOS (10 registros):
INSERT INTO Productos (nombre_producto, categoria_producto, precio_producto, cantidad_producto, fechaCreacion_producto, fechaCaducidad_producto) 
VALUES 
('Crema facial antiarrugas', 'Cuidado facial', 25.99, 50, NOW(), '2024-05-10 10:00:00');

INSERT INTO Productos (nombre_producto, categoria_producto, precio_producto, cantidad_producto, fechaCreacion_producto, fechaCaducidad_producto) 
VALUES 
('Aceite de argán para el cabello', 'Cuidado del cabello', 18.50, 30, NOW(), '2025-07-15 12:00:00');

INSERT INTO Productos (nombre_producto, categoria_producto, precio_producto, cantidad_producto, fechaCreacion_producto, fechaCaducidad_producto) 
VALUES 
('Labial mate color rojo pasión', 'Maquillaje labios', 12.99, 40, NOW(), '2024-06-20 15:00:00');

INSERT INTO Productos (nombre_producto, categoria_producto, precio_producto, cantidad_producto, fechaCreacion_producto, fechaCaducidad_producto) 
VALUES 
('Crema corporal hidratante de aloe vera', 'Cuidado corporal', 30.75, 60, NOW(), '2024-08-10 09:00:00');

INSERT INTO Productos (nombre_producto, categoria_producto, precio_producto, cantidad_producto, fechaCreacion_producto, fechaCaducidad_producto) 
VALUES 
('Protector solar facial SPF 30', 'Protector solar', 15.99, 70, NOW(), '2024-09-25 14:00:00');

INSERT INTO Productos (nombre_producto, categoria_producto, precio_producto, cantidad_producto, fechaCreacion_producto, fechaCaducidad_producto) 
VALUES 
('Delineador de ojos líquido', 'Maquillaje ojos', 10.25, 50, NOW(), '2024-10-30 16:00:00');

INSERT INTO Productos (nombre_producto, categoria_producto, precio_producto, cantidad_producto, fechaCreacion_producto, fechaCaducidad_producto) 
VALUES 
('Loción bronceadora sin sol', 'Cuidado corporal', 22.50, 20, NOW(), '2024-11-05 11:00:00');

INSERT INTO Productos (nombre_producto, categoria_producto, precio_producto, cantidad_producto, fechaCreacion_producto, fechaCaducidad_producto) 
VALUES 
('Perfume floral fresco', 'Fragancias', 40.00, 25, NOW(), '2025-12-01 10:30:00');

INSERT INTO Productos (nombre_producto, categoria_producto, precio_producto, cantidad_producto, fechaCreacion_producto, fechaCaducidad_producto) 
VALUES 
('Mascarilla facial de arcilla purificante', 'Cuidado facial', 17.75, 35, NOW(), '2025-01-15 08:00:00');

INSERT INTO Productos (nombre_producto, categoria_producto, precio_producto, cantidad_producto, fechaCreacion_producto, fechaCaducidad_producto) 
VALUES 
('Esmalte de uñas color nude', 'Maquillaje uñas', 8.50, 45, NOW(), '2025-02-20 13:00:00');

SELECT * FROM Productos;

-- INSERTAR DATOS TABLA USUARIOS (10 registros): -- Estos valores ya no son válidos (ya no existen)- se inyectan desde Java!
INSERT INTO Usuarios (id_usuario) VALUES (1);
INSERT INTO Usuarios (id_usuario) VALUES (2);
INSERT INTO Usuarios (id_usuario) VALUES (3);
INSERT INTO Usuarios (id_usuario) VALUES (4);
INSERT INTO Usuarios (id_usuario) VALUES (5);
INSERT INTO Usuarios (id_usuario) VALUES (6);
INSERT INTO Usuarios (id_usuario) VALUES (7);
INSERT INTO Usuarios (id_usuario) VALUES (8);
INSERT INTO Usuarios (id_usuario) VALUES (9);
INSERT INTO Usuarios (id_usuario) VALUES (10);

SELECT * FROM Usuarios;

-- INSERTAR DATOS TABLA  Administradores (10 registros): -- Estos valores ya no son válidos (ya no existen)- se inyectan desde Java!
INSERT INTO Administradores (id_administrador) VALUES (11);
INSERT INTO Administradores (id_administrador) VALUES (12);

SELECT * FROM Administradores;


set foreign_key_checks = 0;
-- INSERTAR DATOS TABLA  Promociones (10 registros) 

-- Promoción 0 : 
INSERT INTO Promociones (id_promocion, id_administrador, texto_promocion, precioDescuento_promocion, fechaInicio_promocion, fechaFinal_promocion) 
VALUES (1, 3, 'Sin oferta', 0, '1900-01-01', '2999-12-31');

-- Promoción 1: "¡Descuento del 20% en productos para el cuidado facial!"
INSERT INTO Promociones (id_promocion, id_administrador, texto_promocion, precioDescuento_promocion, fechaInicio_promocion, fechaFinal_promocion) 
VALUES (2, 12, '¡Descuento del 20% en productos para el cuidado facial!', 0.20, '2024-05-15', '2024-05-31');

-- Promoción 2: "Oferta especial: ¡compra 1 y lleva 2 en productos capilares!"
INSERT INTO Promociones (id_administrador, texto_promocion, precioDescuento_promocion, fechaInicio_promocion, fechaFinal_promocion) 
VALUES (3, 'Oferta especial: ¡compra 1 y lleva 2 en productos capilares!', 0.50, '2024-06-01', '2024-06-30');

-- Promoción 3: "¡Regalo exclusivo! Por la compra de 3 productos de maquillaje, llévate un labial gratis."
INSERT INTO Promociones (id_administrador, texto_promocion, precioDescuento_promocion, fechaInicio_promocion, fechaFinal_promocion) 
VALUES (3, '¡Regalo exclusivo! Por la compra de 3 productos de maquillaje, llévate un labial gratis.', 0.00, '2024-09-15', '2024-09-30');

-- Promoción 4: "Liquidación de temporada: ¡hasta un 50% de descuento en productos de fragancias!"
INSERT INTO Promociones (id_administrador, texto_promocion, precioDescuento_promocion, fechaInicio_promocion, fechaFinal_promocion) 
VALUES (12, 'Liquidación de temporada: ¡hasta un 50% de descuento en productos de fragancias!', 0.50, '2024-07-01', '2024-07-15');

-- Promoción 5: "¡Oferta exclusiva! Descuento adicional del 10% para miembros VIP en toda la tienda."
INSERT INTO Promociones (id_administrador, texto_promocion, precioDescuento_promocion, fechaInicio_promocion, fechaFinal_promocion) 
VALUES (3, '¡Oferta exclusiva! Descuento adicional del 10% para miembros VIP en toda la tienda.', 0.10, '2024-12-01', '2024-12-25');

-- Promoción 6: "¡Promoción de San Valentín! Regala belleza a tus seres queridos."
INSERT INTO Promociones (id_administrador, texto_promocion, precioDescuento_promocion, fechaInicio_promocion, fechaFinal_promocion) 
VALUES (12, '¡Promoción de San Valentín! Regala belleza a tus seres queridos.', 0.00, '2024-02-01', '2024-02-14');

-- Promoción 7: "Descubre nuestros nuevos productos y obtén un 15% de descuento en tu primera compra."
INSERT INTO Promociones (id_administrador, texto_promocion, precioDescuento_promocion, fechaInicio_promocion, fechaFinal_promocion) 
VALUES (3, 'Descubre nuestros nuevos productos y obtén un 15% de descuento en tu primera compra.', 0.15, '2024-03-01', '2024-03-31');

-- Promoción 8: "¡Semana de la belleza! Descuentos en tratamientos faciales y corporales."
INSERT INTO Promociones (id_administrador, texto_promocion, precioDescuento_promocion, fechaInicio_promocion, fechaFinal_promocion) 
VALUES (12, '¡Semana de la belleza! Descuentos en tratamientos faciales y corporales.', 0.20, '2024-04-01', '2024-04-07');

-- Promoción 9: "Compra productos seleccionados y recibe una bolsa de regalo de edición limitada."
INSERT INTO Promociones (id_administrador, texto_promocion, precioDescuento_promocion, fechaInicio_promocion, fechaFinal_promocion) 
VALUES (3, 'Compra productos seleccionados y recibe una bolsa de regalo de edición limitada.', 0.00, '2024-05-01', '2024-05-15');

-- Promoción 10: "¡Gran liquidación de verano! Descuentos en protector solar y productos para el cabello."
INSERT INTO Promociones (id_administrador, texto_promocion, precioDescuento_promocion, fechaInicio_promocion, fechaFinal_promocion) 
VALUES (12, '¡Gran liquidación de verano! Descuentos en protector solar y productos para el cabello.', 0.30, '2024-06-15', '2024-07-31');

-- Promoción 11: "¡Semana de la primavera! Descuentos en maquillaje y fragancias florales." ADMINISTRADOR REPETIDO!
INSERT INTO Promociones (id_administrador, texto_promocion, precioDescuento_promocion, fechaInicio_promocion, fechaFinal_promocion) 
VALUES (3, '¡Semana de la primavera! Descuentos en maquillaje y fragancias florales.', 0.25, '2024-03-20', '2024-03-27');


SELECT * FROM Promociones;



-- INSERTAR DATOS TABLA  Tarjetas (10 registros):

-- Tarjeta 1: Asociada al usuario 1
INSERT INTO Tarjetas (id_usuarioTarjeta, numero_tarjeta, clave_tarjeta, fechaCaducidad_tarjeta) 
VALUES (1, '1234567890123456', 1234, '2025-12-01');

-- Tarjeta 2: Asociada al usuario 2
INSERT INTO Tarjetas (id_usuarioTarjeta, numero_tarjeta, clave_tarjeta, fechaCaducidad_tarjeta) 
VALUES (2, '2345678901234567', 2345, '2026-06-01');

-- Tarjeta 3: Asociada al usuario 4
INSERT INTO Tarjetas (id_usuarioTarjeta, numero_tarjeta, clave_tarjeta, fechaCaducidad_tarjeta) 
VALUES (4, '4567890123456789', 4567, '2026-03-01');

-- Tarjeta 4: Asociada al usuario 5
INSERT INTO Tarjetas (id_usuarioTarjeta, numero_tarjeta, clave_tarjeta, fechaCaducidad_tarjeta) 
VALUES (5, '5678901234567890', 5678, '2025-10-01');

-- Tarjeta 5: Asociada al usuario 6
INSERT INTO Tarjetas (id_usuarioTarjeta, numero_tarjeta, clave_tarjeta, fechaCaducidad_tarjeta) 
VALUES (6, '6789012345678901', 6789, '2026-01-01');

-- Tarjeta 6: Asociada al usuario 7
INSERT INTO Tarjetas (id_usuarioTarjeta, numero_tarjeta, clave_tarjeta, fechaCaducidad_tarjeta) 
VALUES (7, '7890123456789012', 7890, '2025-08-01');

-- Tarjeta 7: Asociada al usuario 8
INSERT INTO Tarjetas (id_usuarioTarjeta, numero_tarjeta, clave_tarjeta, fechaCaducidad_tarjeta) 
VALUES (8, '8901234567890123', 8901, '2026-04-01');

-- Tarjeta 8: Asociada al usuario 9
INSERT INTO Tarjetas (id_usuarioTarjeta, numero_tarjeta, clave_tarjeta, fechaCaducidad_tarjeta) 
VALUES (9, '9012345678901234', 9012, '2025-11-01');

-- Tarjeta 9: Asociada al usuario 10
INSERT INTO Tarjetas (id_usuarioTarjeta, numero_tarjeta, clave_tarjeta, fechaCaducidad_tarjeta) 
VALUES (10, '0123456789012345', 1230, '2026-02-01');

SELECT * FROM Tarjetas;


-- INSERTAR DATOS TABLA  Pedidos(10 registros) -- estos datos de Pedidos ya no son válidos, se han borrado y vuelto a insertar solamente id_usuario, id_tarjeta desde Java, los demás son nulls!:

-- Pedido 1 de Usuario 1 con su tarjeta correspondiente (en este caso también 1)
INSERT INTO Pedidos (id_usuario, id_tarjeta, cantidad_pedido, precioTotal_pedido, estadoProcesando_pedido, fecha_pedido, fechaEntrega_pedido) 
VALUES (1, 1, '2 unidades de Crema facial hidratante', 39.98, '2024-05-10 10:00:00', '2024-05-10', '2024-05-15');

-- Pedido 2 de Usuario 2 con su tarjeta correspondiente (en este caso también 2)
INSERT INTO Pedidos (id_usuario, id_tarjeta, cantidad_pedido, precioTotal_pedido, estadoProcesando_pedido, fecha_pedido, fechaEntrega_pedido) 
VALUES (2, 2, '3 botellas de Champú revitalizante', 37.50, '2024-05-10 10:30:00', '2024-05-10', '2024-05-20');

-- Pedido 3 de Usuario 3 con su tarjeta correspondiente (en este caso también 3)
INSERT INTO Pedidos (id_usuario, id_tarjeta, cantidad_pedido, precioTotal_pedido, estadoProcesando_pedido, fecha_pedido, fechaEntrega_pedido) 
VALUES (3, 3, '1 Crema facial hidratante y 1 Champú revitalizante', 32.49, '2024-05-10 11:00:00', '2024-05-10', '2024-05-25');

-- Pedido 4 de Usuario 4 con su tarjeta correspondiente (en este caso también 4)
INSERT INTO Pedidos (id_usuario, id_tarjeta, cantidad_pedido, precioTotal_pedido, estadoProcesando_pedido, fecha_pedido, fechaEntrega_pedido) 
VALUES (4, 4, '2 unidades de Crema facial hidratante', 39.98, '2024-05-10 11:30:00', '2024-05-10', '2024-06-01');

-- Pedido 5 de Usuario 5 con su tarjeta correspondiente (en este caso también 5)
INSERT INTO Pedidos (id_usuario, id_tarjeta, cantidad_pedido, precioTotal_pedido, estadoProcesando_pedido, fecha_pedido, fechaEntrega_pedido) 
VALUES (5, 5, '1 botella de Champú revitalizante', 12.50, '2024-05-10 12:00:00', '2024-05-10', '2024-06-05');

-- Pedido 6 de Usuario 6 con su tarjeta correspondiente (en este caso también 6)
INSERT INTO Pedidos (id_usuario, id_tarjeta, cantidad_pedido, precioTotal_pedido, estadoProcesando_pedido, fecha_pedido, fechaEntrega_pedido) 
VALUES (6, 6, '1 Crema facial hidratante y 2 botellas de Champú revitalizante', 44.99, '2024-05-10 12:30:00', '2024-05-10', '2024-06-10');

-- Pedido 7 de Usuario 7 con su tarjeta correspondiente (en este caso también 7)
INSERT INTO Pedidos (id_usuario, id_tarjeta, cantidad_pedido, precioTotal_pedido, estadoProcesando_pedido, fecha_pedido, fechaEntrega_pedido) 
VALUES (7, 7, '1 botella de Champú revitalizante', 12.50, '2024-05-10 13:00:00', '2024-05-10', '2024-06-15');

-- Pedido 8 de Usuario 8 con su tarjeta correspondiente (en este caso también 8)
INSERT INTO Pedidos (id_usuario, id_tarjeta, cantidad_pedido, precioTotal_pedido, estadoProcesando_pedido, fecha_pedido, fechaEntrega_pedido) 
VALUES (8, 8, '3 unidades de Crema facial hidratante', 59.97, '2024-05-10 13:30:00', '2024-05-10', '2024-06-20');

-- Pedido 9 de Usuario 9 con su tarjeta correspondiente (en este caso también 9)
INSERT INTO Pedidos (id_usuario, id_tarjeta, cantidad_pedido, precioTotal_pedido, estadoProcesando_pedido, fecha_pedido, fechaEntrega_pedido) 
VALUES (9, 9, '2 botellas de Champú revitalizante', 25.00, '2024-05-10 14:00:00', '2024-05-10', '2024-06-25');

-- Pedido 10 de Usuario 10 con su tarjeta correspondiente (en este caso también 10)
INSERT INTO Pedidos (id_usuario, id_tarjeta, cantidad_pedido, precioTotal_pedido, estadoProcesando_pedido, fecha_pedido, fechaEntrega_pedido) 
VALUES (10, 10, '1 Crema facial hidratante', 19.99, '2024-05-10 14:30:00', '2024-05-10', '2024-06-30');

-- Pedido 11 de Usuario 5 con su tarjeta correspondiente (en este caso también 5)
INSERT INTO Pedidos (id_usuario, id_tarjeta, cantidad_pedido, precioTotal_pedido, estadoProcesando_pedido, fecha_pedido, fechaEntrega_pedido) 
VALUES (5, 5, '2 botellas de Champú revitalizante',  25.00, '2024-05-12 12:00:00', '2024-05-13', '2024-06-05');

select * from reportes;
-- INSERTAR DATOS TABLA  Reportes(10 registros): -- estos datos de Reportes ya no son válidos (ya no existen), se han borrado y vuelto a insertar desde Java:
-- Reporte 1
INSERT INTO Reportes (id_reporte, id_administrador, nombre_reporte, tipo_reporte, texto_reporte)
VALUES (1, 11, 'Reporte de ventas mensuales', 'Ventas', 'Informe mensual de las ventas realizadas durante el mes de abril.');

-- Reporte 2
INSERT INTO Reportes (id_administrador, nombre_reporte, tipo_reporte, texto_reporte)
VALUES (12, 'Reporte de inventario', 'Inventario', 'Actualización del inventario de productos al final del trimestre.');

-- Reporte 3
INSERT INTO Reportes (id_administrador, nombre_reporte, tipo_reporte, texto_reporte)
VALUES (11, 'Reporte de incidencias', 'Operaciones', 'Registro de todas las incidencias reportadas por los clientes.');

-- Reporte 4
INSERT INTO Reportes (id_administrador, nombre_reporte, tipo_reporte, texto_reporte)
VALUES (12, 'Reporte de marketing', 'Marketing', 'Análisis de la efectividad de las campañas de marketing durante el último mes.');

-- Reporte 5
INSERT INTO Reportes (id_administrador, nombre_reporte, tipo_reporte, texto_reporte)
VALUES (11, 'Reporte de gastos', 'Finanzas', 'Resumen de los gastos operativos del trimestre.');

-- Reporte 6
INSERT INTO Reportes (id_administrador, nombre_reporte, tipo_reporte, texto_reporte)
VALUES (12, 'Reporte de satisfacción del cliente', 'Clientes', 'Encuesta de satisfacción del cliente y análisis de resultados.');

-- Reporte 7
INSERT INTO Reportes (id_administrador, nombre_reporte, tipo_reporte, texto_reporte)
VALUES (11, 'Reporte de calidad del producto', 'Calidad', 'Evaluación de la calidad de los productos recibidos de los proveedores.');

-- Reporte 8
INSERT INTO Reportes (id_administrador, nombre_reporte, tipo_reporte, texto_reporte)
VALUES (11, 'Reporte de logística', 'Operaciones', 'Seguimiento de la eficiencia en la cadena de suministro.');

-- Reporte 9
INSERT INTO Reportes (id_administrador, nombre_reporte, tipo_reporte, texto_reporte)
VALUES (12, 'Reporte de recursos humanos', 'Recursos Humanos', 'Resumen de la capacitación y evaluación del personal.');

-- Reporte 10
INSERT INTO Reportes (id_administrador, nombre_reporte, tipo_reporte, texto_reporte)
VALUES (11, 'Reporte de tendencias de mercado', 'Marketing', 'Análisis de las tendencias de mercado y proyecciones para el próximo año.');

SELECT * FROM Reportes;

-- INSERTAR DATOS TABLA  Notificaciones(10 registros):
-- Notificación 1
INSERT INTO Notificaciones (id_promocion, texto_notificacion, fecha_notificacion)
VALUES (1, '¡Aprovecha nuestro descuento del 20% en productos para el cuidado facial!', '2024-05-10');

-- Notificación 2
INSERT INTO Notificaciones (id_promocion, texto_notificacion, fecha_notificacion)
VALUES (2, '¡Oferta especial! Compra 1 y llévate 2 en productos capilares.', '2024-05-10');

-- Notificación 3
INSERT INTO Notificaciones (id_promocion, texto_notificacion, fecha_notificacion)
VALUES (3, '¡Regalo exclusivo! Por la compra de 3 productos de maquillaje, llévate un labial gratis.', '2024-05-10');

-- Notificación 4
INSERT INTO Notificaciones (id_promocion, texto_notificacion, fecha_notificacion)
VALUES (4, '¡Liquidación de temporada! Hasta un 50% de descuento en productos de fragancias.', '2024-05-10');

-- Notificación 5
INSERT INTO Notificaciones (id_promocion, texto_notificacion, fecha_notificacion)
VALUES (5, '¡Oferta exclusiva para miembros VIP! Descuento adicional del 10% en toda la tienda.', '2024-05-10');

-- Notificación 6
INSERT INTO Notificaciones (id_promocion, texto_notificacion, fecha_notificacion)
VALUES (6, '¡Promoción de San Valentín! Regala belleza a tus seres queridos.', '2024-05-10');

-- Notificación 7
INSERT INTO Notificaciones (id_promocion, texto_notificacion, fecha_notificacion)
VALUES (7, 'Descubre nuestros nuevos productos y obtén un 15% de descuento en tu primera compra.', '2024-05-10');

-- Notificación 8
INSERT INTO Notificaciones (id_promocion, texto_notificacion, fecha_notificacion)
VALUES (8, '¡Semana de la belleza! Descuentos en tratamientos faciales y corporales.', '2024-05-10');

-- Notificación 9
INSERT INTO Notificaciones (id_promocion, texto_notificacion, fecha_notificacion)
VALUES (9, 'Compra productos seleccionados y recibe una bolsa de regalo de edición limitada.', '2024-05-10');

-- Notificación 10
INSERT INTO Notificaciones (id_promocion, texto_notificacion, fecha_notificacion)
VALUES (10, '¡Gran liquidación de verano en protector solar y productos capilares!', '2024-05-19');

SELECT * FROM Notificaciones;

-- INSERTAR DATOS TABLA  Promocion_producto(10 registros):
-- Producto 1 en promoción 1
INSERT INTO Promocion_producto (id_producto, id_promocion, precioFinal_producto)
VALUES (1, 1, 15.99);

-- Producto 2 en promoción 2
INSERT INTO Promocion_producto (id_producto, id_promocion, precioFinal_producto)
VALUES (2, 2, 9.99);

-- Producto 3 en promoción 3
INSERT INTO Promocion_producto (id_producto, id_promocion, precioFinal_producto)
VALUES (3, 3, 14.99);

-- Producto 4 en promoción 4
INSERT INTO Promocion_producto (id_producto, id_promocion, precioFinal_producto)
VALUES (4, 4, 24.99);

-- Producto 5 en promoción 5
INSERT INTO Promocion_producto (id_producto, id_promocion, precioFinal_producto)
VALUES (5, 5, 8.99);

-- Producto 6 en promoción 6
INSERT INTO Promocion_producto (id_producto, id_promocion, precioFinal_producto)
VALUES (6, 6, 19.99);

-- Producto 7 en promoción 7
INSERT INTO Promocion_producto (id_producto, id_promocion, precioFinal_producto)
VALUES (7, 7, 11.99);

-- Producto 8 en promoción 8
INSERT INTO Promocion_producto (id_producto, id_promocion, precioFinal_producto)
VALUES (8, 8, 18.49);

-- Producto 9 en promoción 9
INSERT INTO Promocion_producto (id_producto, id_promocion, precioFinal_producto)
VALUES (9, 9, 7.50);

-- Producto 10 en promoción 10
INSERT INTO Promocion_producto (id_producto, id_promocion, precioFinal_producto)
VALUES (10, 10, 29.99);

SELECT * FROM Promocion_producto;

-- INSERTAR DATOS TABLA  pedido_reporte(10 registros): -- estos datos de pedido_reporte ya no son válidos (ya no existen), se han borrado y vuelto a insertar desde Java:
-- Asociación entre el reporte 1 y el pedido 1, administrador 1
INSERT INTO pedido_reporte (id_reporte, id_pedido, id_administrador)
VALUES (1, 1, 11);

-- Asociación entre el reporte 2 y el pedido 2, administrador 2
INSERT INTO pedido_reporte (id_reporte, id_pedido, id_administrador)
VALUES (2, 2, 12);

-- Asociación entre el reporte 3 y el pedido 3, administrador 3
INSERT INTO pedido_reporte (id_reporte, id_pedido, id_administrador)
VALUES (3, 3, 11);

-- Asociación entre el reporte 4 y el pedido 4, administrador 4
INSERT INTO pedido_reporte (id_reporte, id_pedido, id_administrador)
VALUES (4, 4, 12);

-- Asociación entre el reporte 5 y el pedido 5, administrador 5
INSERT INTO pedido_reporte (id_reporte, id_pedido, id_administrador)
VALUES (5, 5, 11);

-- Asociación entre el reporte 6 y el pedido 6, administrador 6
INSERT INTO pedido_reporte (id_reporte, id_pedido, id_administrador)
VALUES (6, 6, 12);

-- Asociación entre el reporte 7 y el pedido 7, administrador 7
INSERT INTO pedido_reporte (id_reporte, id_pedido, id_administrador)
VALUES (7, 7, 11);

-- Asociación entre el reporte 8 y el pedido 8, administrador 8
INSERT INTO pedido_reporte (id_reporte, id_pedido, id_administrador)
VALUES (8, 8, 12);

-- Asociación entre el reporte 9 y el pedido 9, administrador 9
INSERT INTO pedido_reporte (id_reporte, id_pedido, id_administrador)
VALUES (9, 9, 11);

-- Asociación entre el reporte 10 y el pedido 10, administrador 10
INSERT INTO pedido_reporte (id_reporte, id_pedido, id_administrador)
VALUES (10, 10, 12);

SELECT * FROM pedido_reporte;



commit;