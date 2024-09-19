-- clausula IN
SELECT * from empleados 
WHERE id in (1,3,5);

SELECT * from productos
WHERE id in (2,4,6);

SELECT * FROM ventas
WHERE cliente_id in (1,3,5);

-- clausula LIKE
SELECT * from empleados
WHERE nombre LIKE 'L%';

SELECT * from productos
WHERE nombre LIKE '%Telefono%';

SELECT * from clientes
WHERE direccion LIKE '%Calle%';


-- clausula ORDER BY
SELECT * from productos
ORDER BY precio DESC LIMIT 5;

SELECT * from empleados
ORDER BY apellido LIMIT 10;

SELECT * from ventas
ORDER BY monto_total DESC LIMIT 3;

-- clausula AS
SELECT nombre,salario,(salario*1.10) AS 'Aumento del 10%' FROM empleados;

SELECT cliente_id, SUM(monto_total) AS 'Monto total gastado' from ventas
GROUP BY cliente_id;

SELECT CONCAT(nombre,' ',apellido) AS 'Nombre y apellido' FROM empleados;

--clausula CASE
SELECT nombre,precio,
    CASE
        WHEN precio >= 500 THEN 'Caro'
        WHEN precio >= 200 AND precio < 500 THEN 'Medio'
        ELSE 'Barato'
    END AS 'Precio'
from productos;

SELECT nombre,edad,
    CASE
        WHEN edad <30 THEN 'Joven'
        WHEN edad > 30 AND edad < 40 THEN 'Adulto'
        ELSE 'Mayor'
    END AS 'Edad'
FROM empleados;

SELECT id,
    CASE
        WHEN cantidad <3 THEN 'Poca cantidad'
        WHEN cantidad >=3 AND cantidad < 6 THEN 'Cantidad moderada'
        ELSE 'Mucha cantidad'
    END AS 'Cantidad'
from ventas;

SELECT nombre,
    CASE
        WHEN nombre LIKE 'A%' THEN 'Comienza con A'
        WHEN nombre LIKE 'M%' THEN 'Comienza con M'
        ELSE 'Otros'
    END AS 'Letra'
FROM clientes;

SELECT nombre,salario,
    CASE
        WHEN salario >= 3500 THEN 'Salario alto'
        WHEN salario >= 3000 THEN 'Salario medio'
        ELSE 'Salario bajo'
    END AS 'Salario'
from empleados;

-- Funcion MAX()
SELECT MAX(salario) AS 'Salario maximo' 
FROM empleados;

SELECT MAX(cantidad) AS 'Cantidad maxima'
FROM ventas;

SELECT MAX(edad) AS 'Edad maxima'
FROM empleados;

-- Funcion MIN()
SELECT MIN(salario) AS 'Salario minimo'
FROM empleados;

SELECT MIN(cantidad) AS 'Cantidad maxima'
FROM ventas;

SELECT MIN(edad) AS 'Edad maxima'
FROM empleados;

-- Funcion COUNT()
SELECT COUNT(*) AS 'Cantidad de empleados'
FROM empleados;

SELECT COUNT(*) AS 'Cantidad de ventas realizadas'
FROM ventas;

SELECT COUNT(*) AS 'Cantidad de productos superior a 500'
FROM productos
WHERE precio > 500;

-- Funcion SUM()
SELECT SUM(salario) AS 'Total de salarios'
FROM empleados;

SELECT SUM(monto_total) AS 'Total de ventas'
FROM ventas;

SELECT SUM(precio) AS 'Total de precios ID par'
FROM productos
WHERE id % 2 = 0;

-- Funcion AVG()
SELECT AVG(salario) AS 'Promedio de salarios'
FROM empleados;

SELECT AVG(precio) AS 'Promedio de precios'
FROM productos;

SELECT AVG(edad) AS 'Promedio de edades'
FROM empleados;

