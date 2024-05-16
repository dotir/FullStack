/* seleccionar una etiqueta del HTML */
const selector = document.getElementById("mensaje");
/* escribir dentro de esa etiqueta con JS */
selector.innerHTML = "CONEXIÓN EXITOSA ENTRE HTML Y JS";
prompt("Preguntar algo");
console.log("Imprimir algo");

const entrada = prompt("¿Qué producto desea comprar?");
console.log(entrada);
alert(entrada);

const mensaje = "Bienvenido " + nombre;