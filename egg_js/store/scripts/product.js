class Product{
    constructor(id, title,detail, description, price,discount, stock,tax, images, onsale,supplier,colors){
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.description= description;
        this.price = price;
        this.discount= discount;
        this.stock = stock;
        this.tax = tax;
        this.images = images;
        this.onsale = onsale;
        this.supplier = supplier;
        this.colors=colors;
    }
    getSupplier(){
        return this.supplier;
    }

    setSupplier(supplier){
        this.supplier = supplier;
    } 

    sellUnits(units){
        this.stock = this.stock - units;
    }
}
const description= `Experience the power of creativity with the MacBook Pro 13'4.
Featuring 8GB of RAM and 512GB of storage, this laptop provides
the performance and storage capacity needed for demanding tasks.
The sleek design in silver and space gray adds a touch of
sophistication. The high-resolution Retina display brings your
visuals to life, whether you're editing photos, creating videos,
or simply browsing the web. With the latest technology and a
lightweight build, the MacBook Pro 13'4 is the perfect companion
for professionals and creative individuals alike.0`;

const prod1 = new Product(1, "iPad Pro 12.9","Silver",description, 9000,"50% Off", 10,"Incluye impuesto País y percepción AFIP", ["./assets/mock1.jpg", "./assets/mock2.jpg"], true, "Apple", ["Silver", "Space Gray"]);
const prod2 = new Product(2, "iPad Pro 12.9","Silver",description, 9000,"50% Off", 10,"Incluye impuesto País y percepción AFIP", ["./assets/mock1.jpg", "./assets/mock2.jpg"], true, "Apple", ["Silver", "Space Gray"]);
const prod3 = new Product(3, "iPad Pro 12.9","Silver",description, 9000,"50% Off", 10,"Incluye impuesto País y percepción AFIP", ["./assets/mock1.jpg", "./assets/mock2.jpg"], true, "Apple", ["Silver", "Space Gray"]);
const prod4 = new Product(4, "iPad Pro 12.9","Silver",description, 9000,"50% Off", 10,"Incluye impuesto País y percepción AFIP", ["./assets/mock1.jpg", "./assets/mock2.jpg"], true, "Apple", ["Silver", "Space Gray"]);
const prod5 = new Product(5, "iPad Pro 12.9","Silver",description, 9000,"50% Off", 10,"Incluye impuesto País y percepción AFIP", ["./assets/mock1.jpg", "./assets/mock2.jpg"], true, "Apple", ["Silver", "Space Gray"]);
const prod6 = new Product(6, "iPad Pro 12.9","Silver",description, 9000,"50% Off", 10,"Incluye impuesto País y percepción AFIP", ["./assets/mock1.jpg", "./assets/mock2.jpg"], true, "Apple", ["Silver", "Space Gray"]);
const products = [prod1, prod2, prod3, prod4, prod5, prod6]