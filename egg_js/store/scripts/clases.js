class Persona {
    constructor(nombre, edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    saludar() {
        console.log(`Hola, soy ${this.nombre}`);
    }
    entrenar( cantidad){
        console.log(`Entrenando ${cantidad} horas`);
    }
}

const juan = new Persona("Juan", 30);
const maria = new Persona("Maria", 25);

juan.saludar();
maria.saludar();
juan.entrenar(5);