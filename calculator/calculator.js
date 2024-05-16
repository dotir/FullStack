//solicitar dos numeros y guardarlos en variables
const num1 = parseFloat(prompt('Ingrese el primer número: '));
const num2 = parseFloat(prompt('Ingrese el segundo número: '));

//funcion para calcular el cociente
function dividir(a,b,callback){
    if(isNaN(a) || isNaN(b)){
        callback('Error: Ingrese un número válido');
    }else if(b === 0){
        callback('Error: No se puede dividir por 0');
    }else{
        const resultado = a / b;
        callback(`El resultado de la división es: ${resultado}`);
    }
}

//llamar a la funcion dividir
dividir(num1,num2,function(resultado){
    const resultadoElement = document.getElementById('resultado');
    resultadoElement.textContent = resultado;
});