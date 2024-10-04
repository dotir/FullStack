use mi_bd;

--Crea una tabla triangulos_rectangulos con dos columnas: longitud_lado_adyacente y longitud lado_opuesto, ambos de tipo INT.
CREATE TABLE triangulos_rectangulos (
    longitud_lado_adyacente INT,
    longitud_lado_opuesto INT
);

-- Rellena la tabla triangulos_rectangulos con 10 filas con enteros aleatorios entre 1 y 100
INSERT INTO triangulos_rectangulos (longitud_lado_adyacente, longitud_lado_opuesto)
values (FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1);


--Crea una vista donde agregues la columna “hipotenusa” calculándola a partir de los otros dos lados. Utiliza el teorema de Pitágoras para realizar el cálculo: Siendo el lado adyacente “A” y el opuesto “B” y la hipotenusa “C” la fórmula quedaría de la siguiente forma: C = A2 + B2​
CREATE VIEW triangulos_rectangulos_vista AS
SELECT longitud_lado_adyacente, longitud_lado_opuesto, SQRT(POW(longitud_lado_adyacente, 2) + POW(longitud_lado_opuesto, 2)) as hipotenusa
FROM triangulos_rectangulos;

SELECT * from triangulos_rectangulos
SELECT * from triangulos_rectangulos_vista

--Reemplaza la vista y ahora agrégale dos columnas para calcular el ángulo α en radianes y grados. Aquí tienes dos fórmulas: radianes: =arcsen(BC) =arccos(AC) = arctan(BA)  
CREATE OR REPLACE VIEW triangulos_rectangulos_vista AS
SELECT longitud_lado_adyacente, longitud_lado_opuesto, 
    SQRT(POW(longitud_lado_adyacente, 2) + POW(longitud_lado_opuesto, 2)) as hipotenusa,
    ASIN(longitud_lado_opuesto / SQRT(POW(longitud_lado_adyacente, 2) + POW(longitud_lado_opuesto, 2))) as angulo_radianes,
    ASIN(longitud_lado_opuesto / SQRT(POW(longitud_lado_adyacente, 2) + POW(longitud_lado_opuesto, 2))) * 180 / PI() as angulo_grados
FROM triangulos_rectangulos;

--ver vista triangulos_rectangulos_vista
SELECT * from triangulos_rectangulos_vista