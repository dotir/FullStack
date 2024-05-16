let menu_responsive = document.querySelector(".checkbtn");

menu_responsive.onclick = function () {
    navBar = document.querySelector(".navbar");
    navBar.classList.toggle("active");
};



// alert("Hola este es mi Javascript")
// let nombre = "Irving";
// var nombre1 = "Irving";
// const nombre2 = "Irving";

// console.log("nombre: "+nombre);
// console.log("nombre1: "+nombre1);
// console.log("nombre2: "+nombre2);

//seleccionar elementos

// let contenidoTitulo= "Jose";
// titulo.innerHTML = contenidoTitulo;

// //Condicionales
// let texToTitulo = titulo.innerText;
// console.log(texToTitulo);

// if(texToTitulo === "Nombre"){
//     titulo.innerHTML = "Hola Mundo";
// }else{
//     console.log("El titulo no es Nombre");
// }

//Funciones

// let nombre= "Irving";
// let ciudad="Pe";
// let gusto="el futbol";

// let parrafo = document.querySelector(".parrafo");

// function cambiarTexto(nombre,ciudad,gusto){
//     let contenido = `Mi nombre es ${nombre}, soy de ${ciudad} y me gusta ${gusto}`;

//     return contenido;
// }

// parrafo.innerText = cambiarTexto(nombre,ciudad,gusto);