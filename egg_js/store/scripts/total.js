
function createTotalTemplate(arrayOfProducts) {
    let total = 0;
    arrayOfProducts.forEach(
        (each) => (total = total + each.price * each.quantity)
    );
    return `
        <div class="cart-data">
            <h2 class="cart-title"> Resumen del pedido </h2>
            <p class="cart-total">Total ${Intl.NumberFormat('es-PE', { style: 'currency', currency: 'PEN' }).format(total)}</p>
            <p class="cart-tax">Incluye impuesto PAIS y percepción AFIP</p>
            <button id="buy" class="cart-btn" type="button">COMPRAR</button>
        </div>
    `;
}

function printTotal(arrayOfProducts, idSelector) {
    const totalTemplate = createTotalTemplate(arrayOfProducts);
    const totalSelector = document.getElementById(idSelector);
    totalSelector.innerHTML = totalTemplate;
}

printTotal(cartproducts, "total");