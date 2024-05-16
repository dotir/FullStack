//define un objeto llamado misDatosFisicos
const misDatosFisicos = {
    nombre:"",
    edad: 27,
    direccion: {
        calle: "Av. Los Olivos",
        numero: 123,
        ciudad: "Lima",
    },
    peso: 70,
    altura: 1.75,
    peso: 70,
    hobby: "Jugar videojuegos",
};
//hobbyes
const hobbies = {
    enPareja: ['Ver películas', 'Cocinar juntos', 'Salir a pasear', 'Hacer ejercicio', 'Viajar'],
    conAmigos: ['Jugar videojuegos', 'Ir al cine', 'Practicar deportes', 'Salir a comer', 'Ir a conciertos'],
    conFamilia: ['Hacer barbacoas', 'Jugar juegos de mesa', 'Ir de excursión', 'Ver series en familia', 'Celebrar cumpleaños']
};
const todo = [...hobbies.enPareja, ...hobbies.conAmigos, ...hobbies.conFamilia];
console.log(todo);

const [ ,segundoHobby ,tercerHobby,cuartoHobby] = hobbies.enPareja;
const [primerHobby] = hobbies.conAmigos;
const algunos = [segundoHobby,tercerHobby,cuartoHobby,primerHobby, ...hobbies.conFamilia];
console.log(algunos);


var contenidoPerfil =`
<h2>${misDatosFisicos.nombre ? misDatosFisicos.nombre : "Irving"}</h2>
<p>Edad: ${misDatosFisicos.edad}</p>
<p>Dirección: ${misDatosFisicos.direccion.calle} ${misDatosFisicos.direccion.numero}, ${misDatosFisicos.direccion.ciudad}</p>
<p>Altura: ${misDatosFisicos.altura}</p>
<p>Peso: ${misDatosFisicos.peso || 0}</p>
<p>Hobby: ${misDatosFisicos.hobby}</p>
`;

document.getElementById("perfil").innerHTML = contenidoPerfil;
