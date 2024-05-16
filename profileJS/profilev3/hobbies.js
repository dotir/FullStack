const hobbies = {
    enPareja: ['Ver películas', 'Cocinar juntos', 'Salir a pasear', 'Hacer ejercicio', 'Viajar'],
    conAmigos: ['Jugar videojuegos', 'Ir al cine', 'Practicar deportes', 'Salir a comer', 'Ir a conciertos'],
    conFamilia: ['Hacer barbacoas', 'Jugar juegos de mesa', 'Ir de excursión', 'Ver series en familia', 'Celebrar cumpleaños']
};

// Ejemplo de cómo acceder a los hobbies de cada categoría:
// console.log(hobbies.enPareja); // ['Ver películas', 'Cocinar juntos', 'Salir a pasear', 'Hacer ejercicio', 'Viajar']
// console.log(hobbies.conAmigos); // ['Jugar videojuegos', 'Ir al cine', 'Practicar deportes', 'Salir a comer', 'Ir a conciertos']
// console.log(hobbies.conFamilia); // ['Hacer barbacoas', 'Jugar juegos de mesa', 'Ir de excursión', 'Ver series en familia', 'Celebrar cumpleaños']

//Extrae el tercer hobby de la lista "enPareja" y el cuarto de la lista "conFamilia".
const [ , ,tercerHobby] = hobbies.enPareja;
const [ , , , cuartoHobby] = hobbies.conFamilia;
console.log(tercerHobby);
console.log(cuartoHobby);

//template string
const mensaje = `Mi hobby con mi pareja es ${tercerHobby} y el hobby con mi familia es ${cuartoHobby}`;
console.log(mensaje);
//crear un div para mostrar el mensaje
const divmensaje = document.createElement("div");
divmensaje.id = "mensaje";
divmensaje.textContent = mensaje;
document.body.appendChild(divmensaje);
//mostrar todos los hobbies
// const divHobbies = document.createElement("div");
// divHobbies.id = "hobbies";
// divHobbies.innerHTML = `
//     <h2>Hobbies en pareja</h2>
//     <ul>
//         ${hobbies.enPareja.map(hobby => `<li>${hobby}</li>`).join('')}
//     </ul>
//     <h2>Hobbies con amigos</h2>
//     <ul>
//         ${hobbies.conAmigos.map(hobby => `<li>${hobby}</li>`).join('')}
//     </ul>
//     <h2>Hobbies con familia</h2>
//     <ul>
//         ${hobbies.conFamilia.map(hobby => `<li>${hobby}</li>`).join('')}
//     </ul>
// `;
// document.body.appendChild(divHobbies);

