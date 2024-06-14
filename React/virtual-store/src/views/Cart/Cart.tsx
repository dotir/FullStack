import { useState, useEffect } from "react";
import Footer from "../../components/Fotter";
import NavBar from "../../components/NavBar";
import Hero from "../../components/Hero";
import CartCard from "../../components/CartCard";
import CartResume from "../../components/CartResume";
import Product from "../../interfaces/Product";
function Cart() {
  const [productsOnCart, setProductsOnCart] = useState<Product[]>([]);
  const [totalPrice, setTotalPrice] = useState(0);
  useEffect(() => {
    if (localStorage.getItem("cart")) {
      const products = JSON.parse(localStorage.getItem("cart"));
      setProductsOnCart(products);

      // Calcular el precio total
      const totalPrice = products.reduce((acc, curr) => acc + curr.price * curr.units, 0);
      setTotalPrice(totalPrice);
    }
  }, []);
  return (
    <>
      <NavBar />
      <Hero first="mi" second="carrito" />
      <main className="w-full flex flex-col md:flex-row justify-center items-center md:items-start p-[20px]">
        <section className="flex flex-col">
          {productsOnCart.map((each: Product) => (
            <CartCard key={each.id} product={each} />
          ))}
        </section>
        <CartResume price={totalPrice} />
      </main>
      <Footer />
    </>
  );
}

export default Cart;
