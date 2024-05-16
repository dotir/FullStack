
let cartproducts = JSON.parse(localStorage.getItem('cart')) || [];

function createCartCard(product) {
    return `
    <img class="product-img" src="${product.image}" alt="${product.id}">
    <div class="product-details">
        <h4>${product.title}</h4>
        <p class="product-color">- ${product.color}</p>
        <p class="product-description">${product.description}</p>
        <input type="number" name="quantity" min="1" class="product-input" id="${product.id}" onchange="changeQuantity(event)" value="${product.quantity}">
    </div>
    <div>
    <span class="product-price">${Intl.NumberFormat('es-PE', { style: 'currency', currency: 'PEN' }).format(product.price)}</span>
    </div>
    </a>`;
}

function printCartCards(arrayOfProducts, idSelector) {
    let cartProductsTemplate = "";
    for (const element of arrayOfProducts) {
        cartProductsTemplate = cartProductsTemplate + createCartCard(element);
    }
    const cartSelector = document.getElementById(idSelector);
    cartSelector.innerHTML = cartProductsTemplate;
}

printCartCards(cartproducts, "cartproducts");

function changeQuantity(event) {
    let productId = event.target.id;
    let newQuantity = event.target.value;
    let producto = cartproducts.find((p) => p.id.toString() === productId);
    if (producto) {
        producto.quantity = newQuantity;
        localStorage.setItem('cart', JSON.stringify(cartproducts));
    }

}


// var subtotalcarro= document.querySelector('.product-input');
// subtotalcarro.addEventListener("click",cambiototal);
// function cambiototal(){
//     const cantidadcarrito = document.querySelector(".product-input").value;
//     const precio = cantidadcarrito*cartproducts[0].price;
//     const preciofinal = document.querySelector('.cart-total');
//     preciofinal.textContent=precio;
// }
