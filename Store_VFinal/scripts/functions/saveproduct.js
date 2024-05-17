function saveProd(id) {
  const found = products.find((each) => each.id === id);
  const product = {
    id: id,
    title: found.title,
    price: found.price,
    description: found.description,
    image: found.images[0],
    color: document.querySelector("#color-" + id).value,
    quantity: Number(document.querySelector("#quantity-" + id).value),
  };
  // const storage = localStorage.getItem("cart");
  // if (storage) {
  //   const parseStorage = JSON.parse(storage);
  //   parseStorage.push(product);
  //   const stringifyProducts = JSON.stringify(parseStorage);
  //   localStorage.setItem("cart", stringifyProducts);
  // } else {
  //   const stringifyProduct = JSON.stringify([product]);
  //   localStorage.setItem("cart", stringifyProduct);
  // }
  // Obtiene el carrito del localStorage, o inicializa un array vacío si no existe
  let cart = JSON.parse(localStorage.getItem('cart')) || [];

  // Verifica si el producto ya está en el carrito
  const existingProduct = cart.find(item => item.id === id);

  if (existingProduct) {
    // Muestra una alerta si el producto ya está en el carrito
    // alert(`El producto "${product.title}" ya se encuentra en el carrito.`);
    //usar swetalert2
    Swal.fire({
      icon: 'error',
      title: '¡El producto ya se encuentra en el carrito!'
    })
  } else {
    // Si el producto no está en el carrito, lo añade y guarda el carrito actualizado en el localStorage
    cart.push(product);
    localStorage.setItem('cart', JSON.stringify(cart));
    // alert(`El producto "${product.title}" ha sido añadido al carrito.`);
    Swal.fire({
      icon: 'success',
      title: '¡Producto añadido al carrito!'
    })
  }
}