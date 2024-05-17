class Product {
  constructor(id, title, description, price, stock, images, colors, onsale) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.price = price;
    this.stock = stock;
    this.images = images;
    this.colors = colors;
    this.onsale = onsale;
  }
}
let products = [];

async function getProducts() {
  fetch('db/products.json')
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(data => {
      products = data;
      localStorage.setItem('products', JSON.stringify(data));
      printProductCards(data, "products")
    })
    .catch(error => console.error('Error fetching products:', error));
}

