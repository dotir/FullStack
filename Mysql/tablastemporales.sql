use mi_bd;

-- Utiliza TABLE para consultar la tabla productos de manera simple, ordenando los productos de forma descendente por precio y solo 10 filas.
table productos order by precio DEsc limit 10;

CREATE temporary TABLE empleados_temporal
select concat(nombre, ' ', apellido) as nombre_completo from empleados;

table empleados_temporal;

CREATE temporary TABLE clientes_temporal
select nombre from clientes;

table clientes_temporal;

table empleados_temporal union table clientes_temporal;

CREATE temporary TABLE escuela_primaria_temporal (
    id INT,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    edad INT,
    grado INT
);

INSERT INTO escuela_primaria_temporal (id, nombre, apellido, edad, grado) VALUES
(1, 'Alejandro', 'González', 11, 5),
(2, 'Isabella', 'López', 10, 4),
(3, 'Lucas', 'Martínez', 11, 5),
(4, 'Sofía', 'Rodríguez', 10, 4),
(5, 'Mateo', 'Pérez', 12, 6),
(6, 'Valentina', 'Fernández', 12, 6),
(7, 'Diego', 'Torres', 10, 4),
(8, 'Martina', 'Gómez', 11, 5),
(9, 'Joaquín', 'Hernández', 10, 4),
(10, 'Valeria', 'Díaz', 11, 5);


table escuela_primaria_temporal;

table clientes;
INSERT INTO clientes VALUES (10,'Ana Rodríguez','San Martín 2515, Mar del Plat0a');

--eliminar tabla clientes_temporal
DROP TABLE clientes_temporal;

--Realiza la excepción entre la tabla temporal de clientes y la de empleados.
table clientes_temporal except table empleados_temporal;

CREATE temporary TABLE escuela_secundaria_temporal (
    id INT,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    edad INT,
    grado INT
);

INSERT INTO escuela_secundaria_temporal (id, nombre, apellido, edad, grado) VALUES
(1, 'Eduardo', 'Sánchez', 16, 10),
(2, 'Camila', 'Martín', 17, 11),
(3, 'Manuel', 'Gutiérrez', 15, 9),
(4, 'Laura', 'García', 16, 10),
(11, 'Pablo', 'Ortega', 17, 11),
(12, 'Carmen', 'Ramírez', 15, 9),
(13, 'Carlos', 'Molina', 16, 10),
(14, 'Ana', 'Ruiz', 17, 11),
(15, 'Luis', 'Fernández', 15, 9),
(16, 'María', 'López', 16, 10);

table escuela_secundaria_temporal;

--Realiza la intersección de la escuela primaria y escuela secundaria con el nombre y apellido de los alumnos para saber quienes fueron a ambas escuelas.
table escuela_primaria_temporal intersect table escuela_secundaria_temporal;

--Realiza la excepción de la escuela primaria con la secundaria para saber quienes no siguieron cursando en dicha escuela secundaria.
table escuela_primaria_temporal except table escuela_secundaria_temporal;

-- Realiza la excepción de la escuela secundaria con la primaria para saber quienes no siguieron cursando en dicha escuela secundaria.
table escuela_secundaria_temporal except table escuela_primaria_temporal;

-- Realiza la unión de la escuela primaria y secundaria con la columna grado para saber cuáles son los grados que abarcan ambas escuelas, y ordénalos de forma descendente.
table escuela_primaria_temporal union table escuela_secundaria_temporal order by grado desc;