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

