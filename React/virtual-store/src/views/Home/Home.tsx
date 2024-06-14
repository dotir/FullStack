import Footer from "../../components/Fotter";
import Hero from "../../components/Hero";
import NavBar from "../../components/NavBar";
import ProductCard from "../../components/ProductCard";
import products from "../../../public/products.json";
import Product from "../../interfaces/ProductCard";

function Home() {
  return (
    <>
      <NavBar />
      <Hero first="tecnologia" second="renovada" />
      <main>
        <div className="w-[1080px] flex flex-wrap justify-between" id="products">
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
