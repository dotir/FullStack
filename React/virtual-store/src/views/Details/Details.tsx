import { useParams } from "react-router-dom";
import Footer from "../../components/Fotter";
import NavBar from "../../components/NavBar";
import products from "../../../public/products.json";
import Hero from "../../components/Hero";
import ProductCard from "../../components/ProductCard";
import Thumbs from "../../components/Thumbs";
import Description from "../../components/Description";
import Checkout from "../../components/Checkout";
import Product from "../../interfaces/Product";


function Details() {
  const { id } = useParams();
  const product:Product  = products.find((each) => each.id === id);
  const onsale: Product[] = products.filter((each) => each.onsale);
  return (
    <>
      <NavBar />
      {!product && <Hero first="NOT" second="found" />}
<main>
  <div className="w-[1080px] flex flex-wrap justify-between">
    {product && (
      <div id="details" className="flex justify-center">
        <Thumbs product={product} />
        <Description product={product} />
        <Checkout product={product} />
      </div>
    )}
    <div className="w-[1080px] flex flex-wrap justify-between my-5">
      <h2 className="text-center text-4xl">Week Sale</h2>
      <div id="product-container" className="w-[1080px] flex flex-wrap justify-between">
        {onsale.map((each:Product) => (
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
    </div>
  </div>
</main>
      <Footer />
    </>
  );
}


export default Details;
