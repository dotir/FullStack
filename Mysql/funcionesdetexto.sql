use mi_bd;

-- Length
SELECT LENGTH('Hola Mundo');
SELECT LENGTH(nombre)
FROM empleados
WHERE id = 1;

-- Concat
SELECT CONCAT('Hola', ' ', 'Mundo');

--Substring
SELECT SUBSTRING('Hola Mundo', 2, 4);

--lower y upper
SELECT LOWER('Hola Mundo');
SELECT UPPER('Hola Mundo');

-- TRIM
SELECT TRIM('  Hola Mundo  ');

-- REPLACE
SELECT REPLACE('Hola Mundo', 'Mundo', 'MySQL');

-- REVERSE
SELECT REVERSE('Hola Mundo');

--Parte 1
--crear tabla estudiantes
CREATE TABLE estudiantes(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    edad INT,
    promedio FLOAT
);


--insertar datos
INSERT INTO estudiantes(nombre, apellido, edad, promedio)
VALUES('Juan', 'Pérez', 22, 85.5),
('María', 'Gómez', 21, 90.0),
('Luis', 'Rodríguez', 20, 88.5),
('Ana', 'Martínez', 23, 92.0),
('Carlos', 'López', 22, 86.5);


SELECT * FROM estudiantes;
--longitud del nombre y apellido con el nombre "Luis" y apellido "Rodríguez".
SELECT nombre, apellido, LENGTH(nombre) AS longitud_nombre, LENGTH(apellido) AS longitud_apellido
FROM estudiantes
WHERE nombre = 'Luis' AND apellido = 'Rodríguez';

--concatenar nombre y apellido con el nombre "María" y apellido "Gómez".
SELECT CONCAT(nombre, ' ', apellido) AS nombre_completo
FROM estudiantes
WHERE nombre='María' AND apellido='Gómez';

--Encuentra la posición de la primera 'e' en el apellido del estudiante con el nombre "Juan" y apellido "Pérez".
SELECT nombre, apellido, LOCATE('e', apellido) AS posicion_e
FROM estudiantes
WHERE nombre='Juan' AND apellido='Pérez';

--Inserta la cadena ' García' en la posición 3 del nombre del estudiante con el nombre "Ana" y apellido "Martínez".
SELECT REPLACE(nombre, 'a', ' García')
FROM estudiantes
WHERE nombre='Ana' AND apellido='Martínez';

--Convierte el nombre del estudiante con el nombre "Luis" y apellido "Rodríguez" a minúsculas. (LOWER)
SELECT nombre, LOWER(nombre) AS nombre_minusculas
FROM estudiantes
WHERE nombre='Luis' AND apellido='Rodríguez';

--Convierte el apellido del estudiante con el nombre "Juan" y apellido "Pérez" a mayúsculas. (UPPER)
SELECT apellido, UPPER(apellido) AS apellido_mayusculas
FROM estudiantes
WHERE nombre='Juan' AND apellido='Pérez';

--Obtiene los primeros 4 caracteres del apellido del estudiante con el nombre "María" y apellido "Gómez". (LEFT)
SELECT apellido, LEFT(apellido, 4) AS primeros_4_caracteres
FROM estudiantes
WHERE nombre='María' AND apellido='Gómez';

--Obtiene los últimos 3 caracteres del apellido del estudiante con el nombre "Ana" y apellido "Martínez". (RIGHT)
SELECT apellido, RIGHT(apellido, 3) AS ultimos_3_caracteres
FROM estudiantes
WHERE nombre='Ana' AND apellido='Martínez';

--Encuentra la posición de la primera 'o' en el nombre del estudiante con el nombre "Carlos" y apellido "López". (LOCATE)
SELECT nombre, LOCATE('o', nombre) AS posicion_o
FROM estudiantes
WHERE nombre='Carlos' AND apellido='López';

--Encuentra la posición de la primera aparición de la letra 'a' en el nombre de la estudiante con el nombre "María" y apellido "Gómez".
SELECT nombre, LOCATE('a', nombre) AS posicion_a
FROM estudiantes
WHERE nombre='María' AND apellido='Gómez';

--Reemplaza 'a' con 'X' en el nombre del estudiante con el nombre "Ana" y apellido "Martínez". 
SELECT nombre, REPLACE(nombre, 'a', 'X') AS nombre_reemplazado
FROM estudiantes
WHERE nombre='Ana' AND apellido='Martínez';

--Encuentra la subcadena de 3 caracteres de longitud de la columna 'nombre' del estudiante con el nombre "María" y apellido "Gómez", comenzando en la posición 2.
SELECT nombre, SUBSTRING(nombre, 2, 3) AS subcadena
FROM estudiantes
WHERE nombre='María' AND apellido='Gómez';

--Combina los nombres de todos los estudiantes en una única cadena separada por guiones.
SELECT GROUP_CONCAT(nombre SEPARATOR '-')
FROM estudiantes;

--Combina los nombres y apellidos de todos los estudiantes en una única cadena separada por un guion vertical (|). 
SELECT GROUP_CONCAT(CONCAT(nombre, ' ', apellido) SEPARATOR '|')
FROM estudiantes;

--Elimina los espacios en blanco iniciales del texto "    … usé muchos espacios    " tabla estudiantes.
SELECT LTRIM(nombre) AS texto_sin_espacios
FROM estudiantes;

--Elimina los espacios en blanco finales del texto
SELECT RTRIM(nombre) AS texto_sin_espacios
FROM estudiantes;

--Cita el resultado de los dos ejercicios anteriores utilizando la función QUOTE.
SELECT QUOTE(LTRIM(nombre)) AS texto_citado
FROM estudiantes;

--parte 2
--Repite el nombre y apellido del estudiante con el nombre "Juan" y apellido "Pérez" tres veces. 
SELECT REPEAT(CONCAT(nombre, ' ', apellido, ' '), 3) AS nombre_apellido_repetido
FROM estudiantes
WHERE nombre='Juan' AND apellido='Pérez';

--Invierte el nombre del estudiante con el nombre "Ana" y apellido "Martínez". 
SELECT nombre, REVERSE(nombre) AS nombre_invertido
FROM estudiantes
WHERE nombre='Ana' AND apellido='Martínez';

--Devuelve una cadena que contenga 8 caracteres de espacio usando la función SPACE y muéstrala con la función QUOTE
SELECT QUOTE(SPACE(8)) AS espacio_citado
FROM estudiantes;

--Extrae una subcadena que contiene el nombre del estudiante con el nombre "María" y apellido "Gómez" antes de la segunda a utilizando SUBSTRING_INDEX.
SELECT nombre, SUBSTRING_INDEX(nombre, 'a', 1) AS subcadena
FROM estudiantes
WHERE nombre='María' AND apellido='Gómez';

--Combina las edades de todos los estudiantes en una única cadena separada por comas y orden descendente.
SELECT GROUP_CONCAT(edad ORDER BY edad DESC SEPARATOR ',') AS edades
FROM estudiantes;

--Elimina las ‘a’ del nombre' del estudiante con el nombre "Ana" y apellido "Martínez" usando la función REPLACE. 
SELECT nombre, REPLACE(nombre, 'a', '') AS nombre_sin_a
FROM estudiantes
WHERE nombre='Ana' AND apellido='Martínez';

--Rellena a la derecha el promedio del estudiante con el nombre "Luis" y apellido "Rodríguez" con asteriscos hasta una longitud total de 10 caracteres. 
SELECT promedio, RPAD(promedio, 10, '*') AS promedio_rellenado
FROM estudiantes
WHERE nombre='Luis' AND apellido='Rodríguez';

--Obtén el promedio del estudiante con nombre 'Carlos' y apellido 'López', formateado con dos decimales y utilizando la configuración regional 'es_AR'.
SELECT promedio, FORMAT(promedio, 2, 'es_AR') AS promedio_formateado
FROM estudiantes
WHERE nombre='Carlos' AND apellido='López';

