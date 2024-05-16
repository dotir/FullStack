
const cantidad= Number(prompt("¿Cuantos numeros desea sumar?"));

let sumatoria=0;

for (let i=0; i<cantidad; i++){
    const numeroAsumar = Number(prompt("Ingrese un número a sumar"));
    sumatoria = sumatoria + numeroAsumar;
}

const numero1 = Number(prompt("Ingrese primer número"));
const numero2 = Number(prompt("Ingrese segundo número"));
const suma =numero1 +numero2;
const mensajeSuma = "El resultado de la suma es "+suma;
console.log(mensajeSuma);
const promedio = suma / 2;
const triple = promedio * 3;
const resultadoMenosDiez = triple - 10;
const mensajeResultado = "El resultado es "+resultadoMenosDiez;