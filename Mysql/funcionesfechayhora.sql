USE mi_bd;

-- Ejercicios funciones de  fecha y hora

--TABLA "envios" (id, fecha_envio, fecha_entrega)
CREATE TABLE envios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha_envio DATETIME,
    fecha_entrega DATETIME,
    codigo_producto VARCHAR(10)
);


--insertar datos
INSERT INTO envios VALUES (NULL, '2022-01-15 08:00:00', '2022-01-20 12:30:00', 'ABC123');
INSERT INTO envios VALUES (NULL, '2022-02-10 10:15:00', '2022-02-15 14:45:00', 'XYZ789');
INSERT INTO envios VALUES (NULL, '2022-03-05 09:30:00', '2022-03-10 13:20:00', 'PQR456');
INSERT INTO envios VALUES (NULL, '2022-04-20 11:45:00', '2022-04-25 15:10:00', 'LMN001');
INSERT INTO envios VALUES (NULL, '2022-05-12 07:55:00', '2022-05-17 10:25:00', 'DEF777');
INSERT INTO envios VALUES (NULL, '2022-06-08 08:20:00', '2022-06-13 12:40:00', 'GHI888');
INSERT INTO envios VALUES (NULL, '2022-07-03 10:05:00', '2022-07-08 14:15:00', 'JKL999');

SELECT * FROM envios;

--Utilizando la función DATE_ADD, calcula la fecha de entrega programada para un envío con código de producto 'ABC123' cuando se le añaden 5 días a la fecha de envío.
SELECT 
    codigo_producto, 
    fecha_envio, 
    DATE_ADD(fecha_envio, INTERVAL 5 DAY) AS fecha_entrega_programada
FROM 
    envios
WHERE 
    codigo_producto = 'ABC123';

--Utilizando la función ADDTIME, encuentra la hora estimada de entrega para un envío con código de producto 'XYZ789' si se suma 4 horas y 30 minutos a la hora de entrega. 
SELECT 
    codigo_producto, 
    fecha_entrega, 
    ADDTIME(fecha_entrega, '4:30:00') AS hora_estimada_entrega
FROM
    envios
WHERE 
    codigo_producto = 'XYZ789';

--Utilizando la función CONVERT_TZ, convierte la fecha de envío de un envío con código de producto 'PQR456' de la zona horaria 'UTC' (+00:00) a la zona horaria de Argentina GMT-3 (-03:00).
SELECT 
    codigo_producto, 
    fecha_envio, 
    CONVERT_TZ(fecha_envio, '+00:00', '-03:00') AS fecha_envio_argentina
FROM
    envios
WHERE 
    codigo_producto = 'PQR456';

--Calcula la diferencia en días entre la fecha de entrega y la fecha de envío para el envío con código de producto 'LMN001' utilizando la función DATEDIFF.
SELECT 
    codigo_producto, 
    fecha_envio, 
    fecha_entrega, 
    DATEDIFF(fecha_entrega, fecha_envio) AS dias_entrega
FROM
    envios
WHERE 
    codigo_producto = 'LMN001';

--Utiliza la función CURDATE para obtener la fecha actual y, a continuación, obtener la diferencia en días entre la fecha de entrega con código de producto 'DEF777' y la fecha actual.
SELECT 
    codigo_producto, 
    fecha_entrega, 
    CURDATE() AS fecha_actual, 
    DATEDIFF(CURDATE(), fecha_entrega) AS dias_hasta_entrega
FROM
    envios
WHERE 
    codigo_producto = 'DEF777';

-- Utilizando la función CURTIME, obtén la hora actual del sistema.
SELECT CURTIME() AS hora_actual;

-- Utiliza la función DATE para extraer la fecha de envío del envío con ID 3.
SELECT 
    id, 
    DATE(fecha_envio) AS fecha_envio
FROM
    envios
WHERE 
    id = 3;

--Utiliza la función DATE_ADD para calcular la fecha de entrega programada para el envío con código de producto 'XYZ789' si se le agregan 3 días a la fecha de envío.
SELECT 
    codigo_producto, 
    fecha_envio, 
    DATE_ADD(fecha_envio, INTERVAL 3 DAY) AS fecha_entrega_programada
FROM
    envios
WHERE 
    codigo_producto = 'XYZ789';

--Utiliza la función DATE_FORMAT para mostrar la fecha de envío del envío con ID 6 en el formato 'DD-MM-YYYY'.
SELECT 
    id, 
    DATE_FORMAT(fecha_envio, '%d-%m-%Y') AS fecha_envio_formato
FROM
    envios
WHERE 
    id = 6;

--Utiliza la función DATE_SUB para calcular la fecha de envío del envío con ID 4 si se le restan 2 días.
SELECT 
    id, 
    fecha_envio, 
    DATE_SUB(fecha_envio, INTERVAL 2 DAY) AS fecha_envio_restante
FROM
    envios
WHERE 
    id = 4;

--Utiliza la función DATEDIFF para calcular la diferencia en días entre la fecha de envío y la fecha de entrega programada para el envío con código de producto 'PQR456'.
SELECT 
    codigo_producto, 
    fecha_envio, 
    fecha_entrega, 
    DATEDIFF(fecha_entrega, fecha_envio) AS dias_entrega
FROM
    envios
WHERE 
    codigo_producto = 'PQR456';

--Utiliza la función DAY para obtener el día del mes en que se realizó el envío con ID 2.
SELECT 
    id, 
    DAY(fecha_envio) AS dia_envio
FROM
    envios
WHERE 
    id = 2;

--Utiliza la función DAYNAME para obtener el nombre del día de la semana en que se entregará el envío con código de producto 'DEF777'.
SELECT 
    codigo_producto, 
    fecha_entrega, 
    DAYNAME(fecha_entrega) AS dia_semana_entrega
FROM
    envios
WHERE 
    codigo_producto = 'DEF777';

--Utiliza la función DAYOFMONTH para obtener el día del mes en que se entregará el envío con código de producto 'GHI888'.
SELECT 
    codigo_producto, 
    fecha_entrega, 
    DAYOFMONTH(fecha_entrega) AS dia_mes_entrega
FROM
    envios
WHERE 
    codigo_producto = 'GHI888';

--Utiliza la función PERIOD_ADD para agregar un período de 3 meses al año-mes '2022-07'.
SELECT 
    PERIOD_ADD('202207', 3) AS periodo_agregado;

--Utiliza la función PERIOD_DIFF para calcular el número de meses entre los períodos '2022-03' y '2022-12'.
SELECT 
    PERIOD_DIFF('202212', '202203') AS meses_diferencia;

--Utiliza la función QUARTER para obtener el trimestre de la fecha de entrega del envío con código de producto 'PQR456'.
SELECT 
    codigo_producto, 
    fecha_entrega, 
    QUARTER(fecha_entrega) AS trimestre_entrega
FROM
    envios
WHERE 
    codigo_producto = 'PQR456';

--Utiliza la función SEC_TO_TIME para convertir 3665 segundos en formato 'hh:mm:ss'.
SELECT 
    SEC_TO_TIME(3665) AS tiempo_convertido;

--Utiliza la función SECOND para obtener los segundos de la hora de envío del envío con ID 2.
SELECT 
    id, 
    fecha_envio, 
    SECOND(fecha_envio) AS segundos_envio
FROM
    envios
WHERE 
    id = 2;

--Utiliza la función STR_TO_DATE para convertir la cadena '2022()08()15' en una fecha.
SELECT 
    STR_TO_DATE('2022()08()15', '%Y()%m()%d') AS fecha_convertida;

--Utiliza la función SUBDATE (o DATE_SUB) para restar 5 días a la fecha de entrega del envío con código de producto 'GHI888'.
SELECT 
    codigo_producto, 
    fecha_entrega, 
    SUBDATE(fecha_entrega, 5) AS fecha_entrega_actualizada
FROM
    envios
WHERE 
    codigo_producto = 'GHI888';

--Utiliza la función SUBTIME para restar 2 horas y 15 minutos a la hora de envío del envío con ID 7.
SELECT 
    id, 
    fecha_envio, 
    SUBTIME(fecha_envio, '02:15:00') AS fecha_envio_actualizada
FROM 
    envios
WHERE 
    id = 7;

-- Utiliza la función TIME para extraer la porción de tiempo de la fecha de envío del envío con ID 1.
SELECT 
    id, 
    TIME(fecha_envio) AS hora_envio
FROM 
    envios
WHERE 
    id = 1;

-- Utiliza la función TIME_FORMAT para formatear la hora de envío del envío con ID 2 en 'hh:mm:ss'.
SELECT 
    id, 
    TIME_FORMAT(fecha_envio, '%H:%i:%s') AS hora_formateada
FROM 
    envios
WHERE 
    id = 2;


-- Utiliza la función TIME_TO_SEC para convertir la hora de envío del envío con ID 3 en segundos.
SELECT 
    id, 
    TIME_TO_SEC(TIME(fecha_envio)) AS segundos_hora_envio
FROM 
    envios
WHERE 
    id = 3;

-- Utiliza la función TIMEDIFF para calcular la diferencia de horas entre las fechas de envío y entrega del envío con ID 4.
SELECT 
    id, 
    TIMEDIFF(fecha_entrega, fecha_envio) AS diferencia_horas
FROM 
    envios
WHERE 
    id = 4;

-- Utiliza la función SYSDATE para obtener la hora exacta en la que se ejecuta la función en la consulta. Para comprobar esto invoca SYSDATE, luego la función SLEEP durante 5 segundos y luego vuelve a invocar la función SYSDATE, y verifica la diferencia entre ambas invocaciones con TIMEDIFF.
SELECT SYSDATE() AS primera_invocacion;

-- Este comando espera 5 segundos
DO SLEEP(5);

SELECT 
    SYSDATE() AS segunda_invocacion,
    TIMEDIFF(SYSDATE(), (SELECT SYSDATE() AS primera_invocacion)) AS diferencia_tiempo;

-- Crea una consulta que utilice la función TIMESTAMP para obtener todos los valores de fecha_envio sumandole 12 horas.
SELECT 
    id, 
    fecha_envio, 
    TIMESTAMP(fecha_envio, '12:00:00') AS fecha_envio_mas_12_horas
FROM 
    envios;

-- Utiliza la función TIMESTAMPADD para agregar 3 horas a la fecha de entrega del envío con código de producto 'XYZ789'.
SELECT 
    codigo_producto, 
    fecha_entrega, 
    TIMESTAMPADD(HOUR, 3, fecha_entrega) AS fecha_entrega_actualizada
FROM 
    envios
WHERE 
    codigo_producto = 'XYZ789';
