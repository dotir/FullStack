var nombre = "Irving";
var edad = 27;
var profesion = "Desarrollador Web";
var ubicacion = "Peru";
var hobby = "Jugar videojuegos";
var isOnline = false;
//template string
var perfil = `Hola, mi nombre es ${nombre},
 tengo ${edad} años, soy ${profesion},
 vivo en ${ubicacion} y me gusta ${hobby}.`;

// console.log(perfil);

const userResponse = prompt("¿Estás conectado? Responde 'SI' o 'NO'");

if (userResponse.toUpperCase() === "SI" && !isOnline) {
  isOnline = true;
  console.log("El usuario está conectado");
  console.log(perfil);
}else{
    console.log("El usuario no está conectado");
}

function printTemplate(id = "template3") {
  const element = document.getElementById(id);
  if (element) {
    // Aquí deberías imprimir el template string con los datos personales
    element.textContent = perfil;
  } else {
    console.error(`El elemento con id "${id}" no existe.`);
  }
}

printTemplate("template1");
printTemplate("template2");
printTemplate();
printTemplate("template4");