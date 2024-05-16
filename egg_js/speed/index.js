function calcularVelocidad( distacia, tiempo) {
    const velocidad = distacia / tiempo;
    console.log("La velocidad es: " + velocidad);
    return velocidad;
}

const velocidad1= calcularVelocidad(10,2);
console.log("La velocidad de Juana es: " + velocidad1);
const velocidad2= calcularVelocidad(100,1);
console.log("La velocidad de Pedro es: " + velocidad2);
const velocidad3= calcularVelocidad(75,3);
console.log("La velocidad de Maria es: " + velocidad3);