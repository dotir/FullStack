import axios from "axios";
import { useEffect, useState } from "react";
import Footer from "../components/Fotter";
import Hero from "../components/Hero";
import NavBar from "../components/NavBar";
import ProductCard from "../components/ProductCard";
// import products from "../../../public/products.json";
import Product from "../interfaces/ProductCard";
import { useSelector } from "react-redux";

function Home() {
  const [products, setProducts] = useState<Product[]>([]);
  const text = useSelector((store) => store.products.text);
  useEffect(() => {
    axios.get("/products.json")
      .then((res) => {
        const filterData = res.data.filter((each) =>
          each.title.toLowerCase().includes(text.toLowerCase())
        );
        setProducts(filterData);
      })
      .catch((err) => console.log(err));
  }, [text]);
  
  return (
    <>
      <NavBar />
      <Hero first="tecnologia" second="renovada" />
      <main className="flex justify-center items-center p-5">
        <div className="w-auto lg:w-[1080px] flex flex-wrap justify-between" id="products">
          {products.map((each: Product) => (
            <ProductCard
              key={each.id}
              id={each.id}
              title={each.title}
              price={each.price}
              color={each.colors[0]}
              image={each.images[0]}
            />
          ))}
        </div>
      </main>
      <Footer />
    </>
  );
}

export default Home;
