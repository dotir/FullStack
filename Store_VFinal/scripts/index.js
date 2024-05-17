
// Espera a que el DOM esté completamente cargado
document.addEventListener('DOMContentLoaded', () => {
    printIcons();
    getOptions();
    getProducts();

});

const searchSelector = document.querySelector("#search");
searchSelector.addEventListener("keyup", printFilter);

//captura el select de filter y llama a la funcion printFilter
const filterSelector = document.querySelector("#filter");
//un if para ver el valor si asc o desc
filterSelector.addEventListener("change", (evento) => {
  if (evento.target.value === "asc") {
    sortProductsAZ();
  } else if (evento.target.value === "desc") {
    sortProductsZA();
  } else if (evento.target.value === "price-asc") {
    sortProductsByPriceHighToLow(evento);
  } else if (evento.target.value === "price-desc") {
    sortProductsByPriceLowToHigh(evento);
  }
});