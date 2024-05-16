// Datos de ejemplo para los productos del carrito
const cartItems = [
    { id: 1, name: 'Producto 1' },
    { id: 2, name: 'Producto 2' },
    { id: 3, name: 'Producto 3' }
];

// Inicializar los favoritos desde localStorage
let favorites = JSON.parse(localStorage.getItem('favorites')) || [];

// Función para renderizar los productos del carrito
function renderCartItems() {
    const cartItemsList = document.getElementById('cart-items');
    cartItemsList.innerHTML = '';

    cartItems.forEach(item => {
        const listItem = document.createElement('li');
        const itemText = document.createTextNode(item.name);
        listItem.appendChild(itemText);

        const favoriteButton = document.createElement('button');
        favoriteButton.textContent = 'Agregar a Favoritos';
        favoriteButton.addEventListener('click', () => addToFavorites(item));
        listItem.appendChild(favoriteButton);
        cartItemsList.appendChild(listItem);
    });
}

// Función para renderizar los productos favoritos
function renderFavoriteItems() {
    const favoriteItemsList = document.getElementById('favorite-items');
    favoriteItemsList.innerHTML = '';
  
    favorites.forEach(item => {
      const listItem = document.createElement('li');
      const itemText = document.createTextNode(item.name);
      listItem.appendChild(itemText);
  
      const removeButton = document.createElement('button');
      removeButton.textContent = 'Eliminar';
      removeButton.addEventListener('click', () => removeFromFavorites(item.id));
      listItem.appendChild(removeButton);
  
      favoriteItemsList.appendChild(listItem);
    });
  }

// Función para agregar un producto a los favoritos
function addToFavorites(item) {
    if (!favorites.some(favorite => favorite.id === item.id)) {
        favorites.push(item);
        localStorage.setItem('favorites', JSON.stringify(favorites));
        renderFavoriteItems();
    }
}
// Función para eliminar un producto de los favoritos
function removeFromFavorites(itemId) {
    favorites = favorites.filter(item => item.id !== itemId);
    localStorage.setItem('favorites', JSON.stringify(favorites));
    renderFavoriteItems();
  }

// Renderizar los productos del carrito y los favoritos al cargar la página
renderCartItems();
renderFavoriteItems();