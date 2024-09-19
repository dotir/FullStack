use mi_bd;
SELECT * FROM clientes;
SELECT * FROM ventas;
SELECT * FROM empleados;
SELECT * FROM productos;
-- Parte 1
SELECT
empleados.nombre AS nombre_empleado,
empleados.apellido AS apellido_empleado,
empleados.edad AS edad_empleado,
empleados.salario AS salario_empleado,
departamentos.nombre AS nombre_departamento
FROM empleados,departamentos
WHERE empleados.departamento_id = departamentos.id;

SELECT
ventas.id,
ventas.producto_id,
ventas.cliente_id,
ventas.cantidad,
ventas.precio_unitario,
ventas.monto_total,
empleados.nombre AS nombre_empleado,
empleados.apellido AS apellido_empleado
FROM ventas, empleados
WHERE ventas.empleado_id = empleados.id;

SELECT
ventas.id,
productos.nombre AS nombre_producto,
ventas.cliente_id,
ventas.cantidad,
ventas.precio_unitario,
ventas.monto_total,
ventas.empleado_id
FROM ventas, productos
WHERE ventas.producto_id = productos.id;

SELECT
ventas.id,
ventas.producto_id,
clientes.nombre AS nombre_cliente,
ventas.cantidad,
ventas.precio_unitario,
ventas.monto_total,
ventas.empleado_id
FROM ventas, clientes
WHERE ventas.cliente_id = clientes.id;

SELECT
ventas.id,
ventas.producto_id,
ventas.cliente_id,
ventas.cantidad,
ventas.precio_unitario,
ventas.monto_total,
empleados.nombre AS nombre_empleado,
empleados.apellido AS apellido_empleado,
departamentos.nombre AS nombre_departamento
FROM ventas,empleados,departamentos
WHERE ventas.empleado_id = empleados.id
AND empleados.departamento_id = departamentos.id;

SELECT
ventas.id,
productos.nombre,
clientes.nombre,
ventas.cantidad,
ventas.precio_unitario,
ventas.monto_total,
empleados.nombre
FROM ventas,empleados,productos,clientes
WHERE ventas.empleado_id = empleados.id
AND ventas.producto_id = productos.id
AND ventas.cliente_id = clientes.id;

SELECT
departamentos.nombre AS nombre_departamento,
MAX(empleados.salario) AS salario_maximo
FROM empleados,departamentos
WHERE empleados.departamento_id = departamentos.id
GROUP BY departamentos.nombre;

-- Parte 2
SELECT * FROM ventas;
SELECT * FROM departamentos;

SELECT
ventas.monto_total,
departamentos.nombre AS nombre_departamento
FROM ventas, departamentos
WHERE ventas.empleado_id = departamentos.id
GROUP BY ventas.monto_total;