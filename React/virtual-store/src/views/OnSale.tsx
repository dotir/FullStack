import axios from "axios";
import { useEffect, useState } from "react";
import Footer from "../components/Fotter";
import Hero from "../components/Hero";
import NavBar from "../components/NavBar";
import OnSaleCard from "../components/OnSaleCard";
import Product from "../interfaces/ProductCard";
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
      <main className="flex justify-center items-center p-5">
        <div className="w-auto lg:w-[1080px] flex flex-wrap justify-between" id="products">
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