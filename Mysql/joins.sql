use mi_bd;


--JOINS Parte 1
--Encuentra el nombre y apellido de los empleados junto con la cantidad total de ventas que han realizado.
SELECT
e.nombre as nombre_empleado,
e.apellido as apellido_empleado,
SUM(v.cantidad) as cantidad_venta
FROM empleados e
INNER JOIN ventas v
ON e.id = v.empleado_id
GROUP BY e.id;

-- Encuentra el nombre y apellido de los empleados junto con la cantidad total de ventas que han realizado.
SELECT
c.nombre as nombre_cliente,
SUM(v.monto_total) as total_comprado
FROM clientes c
INNER JOIN ventas v
ON c.id = v.cliente_id
GROUP BY c.id;

-- Encuentra los productos vendidos por cada empleado en el departamento de "Ventas" y muestra el nombre del empleado junto con el nombre de los productos que han vendido.
SELECT
e.nombre as nombre_empleado,
p.nombre as nombre_producto
FROM empleados e
INNER JOIN ventas v
ON e.id = v.empleado_id
INNER JOIN productos p
ON v.producto_id = p.id
WHERE e.departamento_id = 1;

--
SELECT
c.nombre as nombre_cliente,
p.nombre as nombre_producto,
v.cantidad as cantidad_comprada
FROM clientes c
INNER JOIN ventas v
ON c.id = v.cliente_id
INNER JOIN productos p
ON v.producto_id = p.id
WHERE p.precio>500
ORDER BY c.nombre;

--Joins parte 2
--Calcula la cantidad de ventas por departamento, incluso si el departamento no tiene ventas.
SELECT
d.nombre as nombre_departamento,
COUNT(v.id) as cantidad_ventas
FROM departamentos d
LEFT JOIN empleados e
ON d.id = e.departamento_id
LEFT JOIN ventas v
ON e.id = v.empleado_id
GROUP BY d.id;

--Encuentra el nombre y la dirección de los clientes que han comprado más de 3 productos y muestra la cantidad de productos comprados.
SELECT
c.nombre as nombre_cliente,
c.direccion as direccion_cliente,
COUNT(v.id) as cantidad_comprada
FROM clientes c
INNER JOIN ventas v
ON c.id = v.cliente_id
GROUP BY c.id
HAVING COUNT(v.id) > 3;

--Calcula el monto total de ventas realizadas por cada departamento y muestra el nombre del departamento junto con el monto total de ventas.
SELECT
d.nombre as nombre_departamento,
SUM(v.monto_total) as MontoTotal
FROM departamentos d
LEFT JOIN empleados e
ON d.id = e.departamento_id
LEFT JOIN ventas v
ON e.id = v.empleado_id
GROUP BY d.id;

--Ejercicios Complementarios

--Muestra el nombre y apellido de los empleados que pertenecen al departamento de "Recursos Humanos" y han realizado más de 5 ventas.
SELECT
e.nombre as nombre_empleado,
e.apellido as apellido_empleado,
COUNT(v.id) as cantidad_ventas
FROM empleados e
INNER JOIN ventas v
ON e.id = v.empleado_id
WHERE e.departamento_id = 2
GROUP BY e.id
HAVING COUNT(v.id) > 5;

--Muestra el nombre y apellido de todos los empleados junto con la cantidad total de ventas que han realizado, incluso si no han realizado ventas.
SELECT
e.nombre as nombre_empleado,
e.apellido as apellido_empleado,
COUNT(v.id) as cantidad_ventas
FROM empleados e
LEFT JOIN ventas v
ON e.id = v.empleado_id
GROUP BY e.id;

--Encuentra el empleado más joven de cada departamento y muestra el nombre del departamento junto con el nombre y la edad del empleado más joven.
SELECT
d.nombre as nombre_departamento,
e.nombre as nombre_empleado,
e.apellido as apellido_empleado,
e.edad as edad_empleado
FROM departamentos d
INNER JOIN empleados e
ON d.id = e.departamento_id
WHERE e.edad = (SELECT MIN(edad) FROM empleados WHERE departamento_id = e.departamento_id);

--Calcula el volumen de productos vendidos por cada producto (por ejemplo, menos de 5 como "bajo", entre 5 y 10 como "medio", y más de 10 como "alto") y muestra la categoría de volumen junto con la cantidad y el nombre del producto.
SELECT
p.nombre as nombre_producto,
CASE
    WHEN SUM(v.cantidad) < 5 THEN 'Bajo'
    WHEN SUM(v.cantidad) BETWEEN 5 AND 10 THEN 'Medio'
    ELSE 'Alto'
END as volumen,
SUM(v.cantidad) as cantidad_vendida
FROM productos p
LEFT JOIN ventas v
ON p.id = v.producto_id
GROUP BY p.id;
