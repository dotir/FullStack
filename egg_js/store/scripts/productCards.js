
const productsSelector = document.getElementById("products");

let productstemplate = "";
for (const element of products) {
    productstemplate = productstemplate + createCard(element)
}

function createCard(product) {
    return `
    <a class="product-card" href="./details.html?id=${product.id}">
    <img class="product-img" src="${product.images[0]}" alt="${product.id}">
    <div class="product-info">
        <span class="product-title">${product.title}</span>
        <span class="product-description">${product.detail}</span>
        <div class="product-price-block">
            <span class="product-price">${Intl.NumberFormat('es-PE', { style: 'currency', currency: 'PEN' }).format(product.price)}</span>
            <span class="product-discount">${product.discount}</span>
        </div>
        <div class="product-tax-policy">${product.tax} </div>
    </div>
    </a>`;
}
function printCards(arrayOfProducts, idSelector) {
    let productsTemplate = "";
    for (const element of arrayOfProducts) {
        productsTemplate = productsTemplate + createCard(element);
    }
    const productsSelector = document.getElementById(idSelector);
    productsSelector.innerHTML = productsTemplate;
}
printCards(products, "products");