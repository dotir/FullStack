const frase = prompt("Ingrese una palabra o frase");
const cantidad = frase.length;

console.log("La cantidad de caracteres es: " + cantidad);

const fraseMinusculas = frase.toLowerCase();
const fraseMayusculas = frase.toUpperCase();

const minMay = fraseMinusculas + " " + fraseMayusculas;
console.log(minMay);