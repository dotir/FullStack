const query = location.search;
const params = new URLSearchParams(query);
const id = params.get('id');
console.log(id);
var precio = 0;
for (var i = 0; i < products.length; i++) {
  if (products[i].id == id) {
  product_detail = products[i];
  precio = products[i].price;
  }
}

function printDetails(id) {
  const product = products.find(product => product.id == id);
  const detailsTemplate = `
    <section class="product-images-block">
      <div class="product-images">
        ${product.images.map(each => `<img class="mini-img" src="${each}" alt="mini" onClick="changeMini(event)" />`).join("")}
      </div>
      <img class="big-img" id="big-img" src="${product.images[0]}" alt="${product.title}" />
    </section>
    <div class="product-description-block">
      <h1 class="product-title">${product.title}</h1>
      <form class="product-selector">
        <fieldset class="product-fieldset">
          <label class="product-label" for="color">Color</label>
          <select class="product-select" type="text" placeholder="Selecciona un color" id="color">
            ${product.colors.map(each => `<option value=${each}>${each}</option>`).join("")}
          </select>
        </fieldset>
      </form>
      <div class="product-description">
        <span class="product-label">Descripción</span>
        <p>${product.description}</p>
      </div>
    </div>
    <div class="product-checkout-block">
      <div class="checkout-container">
        <span class="checkout-total-label">Total:</span>
        <h2 id="price" class="checkout-total-price">${Intl.NumberFormat('es-PE', { style: 'currency', currency: 'PEN' }).format(product.price)}</h2>
        <p class="checkout-description">Incluye impuesto PAIS y percepción AFIP. Podés recuperar AR$ 50711 haciendo la solicitud en AFIP.</p>
        <ul class="checkout-policy-list">
          <li>
            <span class="policy-icon"><img src="./assets/truck.png" alt="Truck" /></span>
            <span class="policy-desc">Agrega el producto al carrito para conocer los costos de envío</span>
          </li>
          <li>
            <span class="policy-icon"><img src="./assets/plane.png" alt="Plane" /></span>
            <span class="policy-desc">Recibí aproximadamente entre 10 y 15 días hábiles, seleccionando envío normal</span>
          </li>
        </ul>
        <div class="checkout-process">
          <div class="top">
            <input type="number" min="1" value="1" id="quantity" onchange="changeSubtotal(${product.price})"/>
            <button type="button" class="cart-btn" onclick="saveProduct(${product.id})" >Añadir al Carrito</button>
          </div>
        </div>
      </div>
    </div>
  `;
  const detailsSelector = document.querySelector("#details");
  detailsSelector.innerHTML = detailsTemplate;
}

function changeMini(event) {
  const selectedSrc = event.target.src;
  const bigSelector = document.querySelector("#big-img");
  bigSelector.src = selectedSrc;
}

function changeSubtotal(event) {
  // 1. Depende del evento de cambio
  const quantityInput = event.target;
  // 2. Guarda en una variable la cantidad de productos a comprar
  const quantity = document.querySelector("#quantity").value
  // 3. Busca el producto
  // const productId = quantityInput.dataset.productId;
  // const product = products.find(p => p.id === productId);
  // 4. Calcula el subtotal
  const subtotal =precio*quantity;
  // 5. Selecciona la etiqueta donde se renderizará el subtotal
  const priceElement = document.querySelector("#price");
  // 6. Actualiza la vista con el subtotal y la imagen agrandada seleccionada
  priceElement.textContent = Intl.NumberFormat('es-PE', { style: 'currency', currency: 'PEN' }).format(subtotal);
  const bigImageElement = document.querySelector("#big-img");
  bigImageElement.src = product.images[0];
}
function saveProduct(id) {
  const found = products.find((each) => each.id === id);
  const product = {
    id: id,
    title: found.title,
    price: found.price,
    image: found.images[0],
    description: found.description,
    color: document.querySelector("#color").value,
    quantity: document.querySelector("#quantity").value,
  };
  // const stringifyProduct = JSON.stringify(product);
  // localStorage.setItem("cart", stringifyProduct);
  let cart = JSON.parse(localStorage.getItem('cart')) || [];
  // Si la clave existe, agregar el nuevo producto al array de productos
  if (cart) {
    cart.push(product);
    localStorage.setItem('cart', JSON.stringify(cart));
  } else {
    // Si la clave no existe, crear un nuevo array con el producto
    cart = [product];
    localStorage.setItem('cart', JSON.stringify(cart));
  }
  //mostrar el contenido de cart en una alerta
  alert(`El producto ha sido añadido al carrito`);
  
}
printDetails(id)
