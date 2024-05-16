const buySelector = document.getElementById('buy');

buySelector.addEventListener('click', () => {
    localStorage.removeItem('cart');

    // Actualizar la impresión de las tarjetas de productos del carrito (sin productos)
    // Aquí debes tener una función que se encargue de actualizar la visualización de las tarjetas del carrito
    actualizarCarrito();

    // Actualizar la impresión del cuadro de detalle del total (sumando cero)
    // Aquí debes tener una función que se encargue de actualizar la visualización del total del carrito
    actualizarTotal();
});

function actualizarCarrito() {
    const cartSelector = document.getElementById('cartproducts');
    cartSelector.innerHTML = '';
}

function actualizarTotal() {
    const totalSelector = document.getElementById('total');
    totalSelector.innerHTML = `
        <div class="cart-data">
            <h2 class="cart-title"> Resumen del pedido </h2>
            <p class="cart-total">Total ${Intl.NumberFormat('es-PE', { style: 'currency', currency: 'PEN' }).format(0)}</p>
            <p class="cart-tax">Incluye impuesto PAIS y percepción AFIP</p>
            <button id="buy" class="cart-btn" type="button">COMPRAR</button>
        </div>
    `;
}