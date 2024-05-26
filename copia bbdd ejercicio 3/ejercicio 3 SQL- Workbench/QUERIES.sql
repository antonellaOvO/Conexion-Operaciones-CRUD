-- Autora: Antonella Alares

USE Ejercicio3;

-- PREGUNTA 1: ¿qué promociones están actualmente activas? - formulada por Martín
SELECT * FROM Promociones
WHERE fechaFinal_promocion >= NOW() AND fechaInicio_promocion <= NOW();

-- PREGUNTA 2: ¿qué productos hay en total en este e-commerce? - formulada por Martín
SELECT COUNT(*) AS total_productos FROM Productos;

-- PREGUNTA 3: Muéstra todos los pedidos realizados por un usuario en concreto - formulada por Martín

-- OTRA OPCIÓN MÁS SIMPLE: 
/*SELECT id_usuario, id_persona FROM Pedidos
INNER JOIN Personas
on pedidos.id_usuario = personas.id_persona;*/

SELECT pedidos.id_usuario, usuarios.id_usuario, id_persona FROM Pedidos
INNER JOIN USUARIOS
on pedidos.id_usuario = usuarios.id_usuario
INNER JOIN Personas
on usuarios.id_usuario = personas.id_persona;

/*NO SE HACE ASÍ, MAL!!! EL ON DEBERÍA HACERSE EN 2 SENTENCIAS sino no lo coge correctamente!!!!!
SELECT pedidos.id_usuario, usuarios.id_usuario, id_persona FROM Pedidos
INNER JOIN Personas
INNER JOIN USUARIOS
ON Pedidos.id_usuario = Usuarios.id_usuario = Personas.id_persona;*/

-- PREGUNTA 4: ¿Cuál es el promedio de todas las compras hechas hasta ahora y agruparlas en 2 categorías: "GASTO ALTO" y "GASTO BAJO" - formulada por Martín
SELECT * FROM Pedidos;

/* Si de aquí sacamos el Average de precio_Total_pedido: SELECT (SELECT AVG(precioTotal_pedido) FROM Pedidos) as precioMedio 
-- Lo podemos utilizar como corte para establecer las 2 categorías (Gasto alto/bajo)*/

SELECT id_pedido, id_usuario, cantidad_pedido, precioTotal_pedido, fecha_pedido, fechaEntrega_pedido, AVG(precioTotal_pedido) AS precioMedio_Por_Pedido, 
CASE WHEN precioTotal_pedido > (SELECT (SELECT AVG(precioTotal_pedido) FROM Pedidos) as precioMedio) THEN 'Gasto Alto' ELSE 'Gasto Bajo' 
END AS Nivel_Gasto FROM Pedidos
GROUP BY id_pedido
ORDER BY Nivel_Gasto ASC;

-- PREGUNTA 5: Sumar todos los pedidos de cada usuario y agrupalos por id, y ordenalos de mayor menor del coste total de sus pedidos- formulada por Martín
SELECT id_pedido, id_usuario, cantidad_pedido, precioTotal_pedido, fecha_pedido, fechaEntrega_pedido, SUM(precioTotal_pedido) AS Suma_Por_Pedido
FROM Pedidos
GROUP BY id_pedido
ORDER BY Suma_Por_Pedido DESC;

-- PREGUNTA 6: ¿Qué productos se compraron con una determinada promoción? -  formulada por Josebeth
SELECT producto_promocion_pedido.id_promocion, texto_promocion, producto_promocion_pedido.id_producto, nombre_producto, categoria_producto FROM producto_promocion_pedido
INNER JOIN Productos
ON producto_promocion_pedido.id_producto = Productos.id_producto
INNER JOIN Promociones
ON producto_promocion_pedido.id_promocion = Promociones.id_promocion
WHERE producto_promocion_pedido.id_promocion = 3;

-- PREGUNTA 7: Mostrar todos los usuario que contenga "-ez-" (o cualquier otra partícula) en su nombre o apellido - formulada por Martín
SELECT id_persona, nombre_persona, apellido_persona FROM Personas
INNER JOIN Usuarios
ON id_persona =id_usuario
WHERE nombre_persona LIKE '%EZ%' OR  apellido_persona LIKE '%EZ%'; 

-- PREGUNTA 8: Mostrar las notificaciones ordenadas de más reciente a menos - formulada por Josebeth
SELECT * FROM Notificaciones
ORDER BY fecha_notificacion DESC;

-- PREGUNTA 9: ¿Cuál es el producto más vendido de una promoción? No olvides mostrar el precio de ese producto - formulada por Josebeth
SELECT producto_promocion_pedido.id_pedido, producto_promocion_pedido.id_producto, Pedidos.cantidad_pedido, CAST((SUBSTRING(Pedidos.cantidad_pedido, 1, 1)) AS SIGNED) 
AS cantidad_int_pedido, Productos.nombre_producto, Productos.categoria_producto,  Promociones.id_promocion, Promociones.texto_promocion 
FROM producto_promocion_pedido
INNER JOIN Productos
ON producto_promocion_pedido.id_producto = Productos.id_producto
INNER JOIN Promociones
ON producto_promocion_pedido.id_promocion = Promociones.id_promocion
INNER JOIN Pedidos
ON producto_promocion_pedido.id_pedido = Pedidos.id_pedido
ORDER BY cantidad_int_pedido DESC
LIMIT 3; -- Seleccionamos 3 productos para ver los 3 más vendidos, pero si queremos el más vendido, pondríamos LIMIT 1 - aunque aquí hay empate entre 2 productos!

-- PREGUNTA 10: Mostrar los datos de un usuario al azar (con un fórmula) - formulada por Martín
SELECT id_usuario, nombre_persona, apellido_persona, DNI, correo_persona, telefono_persona, contrasena_persona, fechaNacimiento_persona, direccion_persona
FROM Usuarios
INNER JOIN Personas
ON id_usuario = id_persona
ORDER BY RAND()
LIMIT 1;

-- PREGUNTA 11: ¿Cuánto tiempo ha pasado entre las dos últimas compras? - formulada por Martín
/*Aquí hacemos la querie para seleccionar los 2 pedidos más recientes*/
SELECT id_pedido, id_usuario, id_tarjeta, cantidad_pedido, fecha_pedido 
FROM Pedidos
ORDER BY fecha_Pedido DESC
LIMIT 2;
/*Y aquí indicamos las 2 fechas de la anterior querie para poder calcular la diferencia entre ambas*/ 
SELECT DATEDIFF('2024-05-13', '2024-05-10') as Difference_dates;

-- PREGUNTA 12: Muestra el número de veces que aparece un reporte por su "tipo de reporte":
SELECT tipo_reporte, COUNT(*)
FROM Reportes
GROUP BY tipo_reporte;

-- PREGUNTA 13: Muestras todos los reportes de un pedido en concreto (el que desees), con el contenido del reporte incluido - formulada por Josebeth
SELECT pedido_reporte.id_pedido, reportes.id_reporte, reportes.id_administrador, nombre_reporte, tipo_reporte, texto_reporte  
FROM pedido_reporte
INNER JOIN Reportes
ON pedido_reporte.id_reporte = reportes.id_reporte
WHERE id_pedido = 4;

-- PREGUNTA 14: Muestra todas las notificaciones de una determinada promoción (la que desees), incluyendo los datos de esa promoción que escojas - formulada por Josebeth
SELECT notificaciones.id_notificacion, notificaciones.id_promocion, texto_promocion, precioDescuento_promocion, fechaInicio_promocion, fechaFinal_promocion 
FROM Notificaciones
INNER JOIN Promociones
on notificaciones.id_promocion = promociones.id_promocion
WHERE notificaciones.id_promocion = 4;

-- PREGUNTA 15: Encuentra el pedido más caro - formulada por Josebeth
SELECT * from Pedidos
ORDER BY precioTotal_pedido DESC
LIMIT 1; 


-- Queries para la lógica de Java:

-- PEDIDOS:

-- Query para sacar la cantidad total de los productos de un determinado pedido:
SELECT * FROM producto_promocion_pedido;
SELECT sum(cantidad) as cantidad from producto_promocion_pedido where id_pedido = 3 group by id_pedido;

-- Query para sacar el precio total de cada pedido:
SELECT sum(t1.precio_total) as precio_final, t1.id_pedido from( SELECT ((ta.cantidad*tb.precio_producto)-(ta.cantidad*tb.precio_producto*tc.precioDescuento_promocion)) as precio_total, ta.id_pedido from producto_promocion_pedido ta inner join productos tb on ta.id_producto = tb.id_producto inner join promociones tc on ta.id_promocion = tc.id_promocion where id_pedido = 3) as t1 group by id_pedido;


-- PEDIDOS Y REPORTES:
-- Query para ver los pedidos procesados por el momento:
SELECT * FROM Pedidos p
inner join producto_promocion_pedido pp
on p.id_pedido = pp.id_pedido;

-- Query para ver los pedidos (los cuales son solamente los pedidos ya entregados -finalizados-) que forman parte de los reportes 
SELECT * FROM Pedidos p
inner join pedido_reporte pr
on p.id_pedido = pr.id_pedido;

-- Query para ver los pedidos (los cuales son solamente los pedidos ya entregados -finalizados-) que forman parte de los reportes , y detalles de estos reportes!
SELECT pr.id_reporte, pr.id_administrador, r.nombre_reporte, r.tipo_reporte, r.texto_reporte, p.id_pedido, p.id_usuario, p.id_tarjeta, p.cantidad_pedido, p.precioTotal_pedido, p.estadoProcesando_pedido, p.estadoEnviado_pedido, p.estadoRecibido_pedido, p.estadoCancelado_pedido 
FROM Pedidos p
inner join pedido_reporte pr
on p.id_pedido = pr.id_pedido
inner join reportes r
on pr.id_reporte = r.id_reporte;

commit;
