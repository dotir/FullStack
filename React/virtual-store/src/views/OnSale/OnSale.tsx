import axios from "axios";
import { useEffect, useState } from "react";
import styles from "./OnSale.module.css";
import Footer from "../../components/Fotter";
import Hero from "../../components/Hero";
import NavBar from "../../components/NavBar";
import OnSaleCard from "../../components/OnSaleCard";
import Product from "../../interfaces/ProductCard";
// import products from "../../../public/products.json";

function OnSale() {
  const [products, setProducts] = useState<Product[]>([]);
  useEffect(() => {
    axios.get("/products.json")
       .then((res) => setProducts(res.data))
       .catch((err) => console.log(err));
  }, []);
  return (
    <>
      <NavBar />
      <Hero first="tecnologia" second="renovada" />
      <main>
        <div className={styles["product-container"]} id="products">
          {products.map((each) => (
            <OnSaleCard
              key={each.id}
              product={each}
            />
          ))}
        </div>
      </main>
      <Footer />
    </>
  );
}

export default OnSale;