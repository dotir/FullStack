class Product {
    constructor(id, title, price, stock, images, onsale) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.images = images;
        this.onsale = onsale;
    }
}
//seis instacias con todas las propiedades
const prod1 = new Product();
const prod2 = new Product(2, "Celular2", 100000);
const prod3 = new Product(3, "Celular3", 100000, 10, ["img1.jpg", "img2.jpg"], true);
const prod4 = new Product(4, "Celular4", 100000, 10, ["img1.jpg", "img2.jpg"], true);
const prod5 = new Product(5, "Celular5", 100000, 10, ["img1.jpg", "img2.jpg"], true);
const prod6 = new Product(6, "Celular6", 100000, 10, ["img1.jpg", "img2.jpg"], true);

//array productos
const products = [prod1, prod2, prod3, prod4, prod5, prod6];



// const prod1 =  new Product();
// const prod2 =  new Product(2,"Celular2",100000);
// const prod3 =  new Product(3,"Celular3",100000,10,["img1.jpg","img2.jpg"],true);

// console.log(prod1);
// console.log(prod2);
// console.log(prod3);

// console.log(prod2.title);
// console.log(prod3.onsale);