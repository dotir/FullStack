function printFilter(evento) {
  const text = evento.target.value;
  const found = products.filter((each) => each.title.toLowerCase().includes(text.toLowerCase()));
  printProductCards(found, "products");
}
//funcion en donde evaluo el filteer para ordenar de a y z utilizando sort
function sortProductsAZ() {
  // Copia los productos para no modificar el array original
  const sortedProducts = [...products];
  // Ordena los productos por título de A a Z
  sortedProducts.sort((a, b) => {
    const titleA = a.title.toLowerCase();
    const titleB = b.title.toLowerCase();
    if (titleA < titleB) return -1;
    if (titleA > titleB) return 1;
    return 0;
  });

  // Llama a la función para imprimir las tarjetas de productos ordenados
  printProductCards(sortedProducts, "products");
}
//funcion en donde evaluo el filteer para ordenar de z a a utilizando sort
function sortProductsZA() {
  // Copia los productos para no modificar el array original
  const sortedProducts = [...products];
  // Ordena los productos por título de A a Z
  sortedProducts.sort((a, b) => {
    const titleA = a.title.toLowerCase();
    const titleB = b.title.toLowerCase();
    if (titleA > titleB) return -1;
    if (titleA < titleB) return 1;
    return 0;
  });

  // Llama a la función para imprimir las tarjetas de productos ordenados
  printProductCards(sortedProducts, "products");
}
//funcion en donde evaluo el filteer para ordenar de menor a mayor utilizando sort
function sortProductsByPriceLowToHigh() {
  // Copia los productos para no modificar el array original
  const sortedProducts = [...products];

  // Ordena los productos por precio de mayor a menor
  sortedProducts.sort((a, b) => {
    return b.price - a.price;
  });

  // Llama a la función para imprimir las tarjetas de productos ordenados
  printProductCards(sortedProducts, "products");
}
//funcion en donde evaluo el filteer para ordenar de mayor a menor utilizando sort
function sortProductsByPriceHighToLow() {
  // Copia los productos para no modificar el array original
  const sortedProducts = [...products];

  // Ordena los productos por precio de menor a mayor
  sortedProducts.sort((a, b) => {
    return a.price - b.price;
  });

  // Llama a la función para imprimir las tarjetas de productos ordenados
  printProductCards(sortedProducts, "products");
}