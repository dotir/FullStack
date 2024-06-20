import { useState, useEffect } from "react";
import Footer from "../components/Fotter";
import NavBar from "../components/NavBar";
import Hero from "../components/Hero";
import CartCard from "../components/CartCard";
import CartResume from "../components/CartResume";
import Product from "../interfaces/Product";
import { useDispatch } from "react-redux";
import productsActions from "../store/actions/products";
const { calculateTotal } = productsActions;

function Cart() {
  const [productsOnCart, setProductsOnCart] = useState<Product[]>([]);
  // const [totalPrice, setTotalPrice] = useState(0);
  const dispatch = useDispatch();
  useEffect(() => {
    const products = localStorage.getItem("cart");
    if (products) {
      setProductsOnCart(JSON.parse(products));
      dispatch(calculateTotal({ products: JSON.parse(products) }));
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
        <CartResume />
      </main>
      <Footer />
    </>
  );
}

export default Cart;
