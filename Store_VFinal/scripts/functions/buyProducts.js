function clearCart() {
  //alerta para confirmar la compra exitosa o de cancelar y eliminacion de productos del carrito
  Swal.fire({
    title: "¿Estás seguro de realizar la compra?",
    text: "Una vez realizada la compra no se podrá deshacer",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#3085d6",
    cancelButtonColor: "#d33",
    confirmButtonText: "Sí, comprar",
    cancelButtonText: "Cancelar",
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire("¡Compra realizada!", "", "success");
      //limpia el carrito
      cartproducts = [];
      localStorage.setItem("cart", JSON.stringify(cartproducts));
      printCartCards(cartproducts, "productscart");
      printCartTotal(cartproducts, "total");
    }
  });
}
