import perimetro from './perimetro.js';
import area from './area.js';
import datosArray from './rectanguloDatos.js';

// const rectangulo1={
//     ancho: 10,
//     alto: 20
// }
// const rectangulo2={
//     ancho: 30,
//     alto: 40
// }
// const rectangulo3={
//     ancho: 50,
//     alto: 60
// }

const tablaRectangulos = document.getElementById('tabla');
let tableHTML = `
    <table>
        <tr>
            <th>Rectángulo</th>
            <th>Ancho</th>
            <th>Altura</th>
            <th>Perímetro</th>
            <th>Área</th>
        </tr>
`;
datosArray.forEach((rectangulo, index) => {
    tableHTML += `
        <tr>
            <td>Rectangulo ${index + 1}</td>
            <td>${rectangulo.ancho}</td>
            <td>${rectangulo.alto}</td>
            <td>${perimetro(rectangulo)}</td>
            <td>${area(rectangulo)}</td>
        </tr>
    `;
});
tableHTML += `</table>`;
tablaRectangulos.innerHTML = tableHTML;

// console.log(valores(rectangulo1));
// console.log(valores(rectangulo2));
// console.log(valores(rectangulo3));
// console.log(perimetro(rectangulo1));
// console.log(perimetro(rectangulo2));
// console.log(perimetro(rectangulo3));
// console.log(area(rectangulo1));
// console.log(area(rectangulo2));
// console.log(area(rectangulo3));
// console.log(arraydatos(valores(rectangulo1),valores(rectangulo2),valores(rectangulo3)));
