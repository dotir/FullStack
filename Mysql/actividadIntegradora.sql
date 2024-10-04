use nba;

SELECT * FROM jugadores;

-- Mostrar el nombre y peso de los diez jugadores que sean pivots (‘C’) y que pesen más de 200 libras, ordenados por peso.
SELECT nombre, peso
FROM jugadores
WHERE posicion = 'C' AND peso > 200

-- Mostrar el nombre de los equipos del este (East).
SELECT Nombre
FROM equipos
WHERE Conferencia = 'East'


-- Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre
select *
from equipos
where Ciudad like 'c%'
order by Nombre

-- Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′.
select es.Puntos_por_partido
from jugadores j
inner join equipos e
on j.Nombre_equipo = e.Nombre
inner join estadisticas es
on j.codigo = es.Jugador
where j.Nombre = 'Pau Gasol' and es.Temporada = '04/05'

--Mostrar los diez jugadores con más puntos en toda su carrera con un redondeo de dos decimales.
select nombre, round(SUM(Puntos_por_partido),2) as puntos
from jugadores j
inner join estadisticas e
on j.codigo = e.Jugador
group by nombre
order by puntos desc
limit 10

--Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA.
select e.Nombre, e.Conferencia, e.Division
from jugadores j
inner join equipos e
on j.Nombre_equipo = e.Nombre
where Altura = (select max(Altura) from jugadores)

-- Mostrar los 10 partidos (equipo_local, equipo_visitante y diferencia) con mayor diferencia de puntos.
select equipo_local, equipo_visitante, 
	abs(puntos_local - equipo_visitante) as diferencia
from partidos
order by diferencia Desc
limit 10;
