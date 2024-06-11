import { useParams } from "react-router-dom";
import Footer from "../../components/Footer/Fotter";
import NavBar from "../../components/NavBar/NavBar";
import products from "../../../public/products.json";
import Hero from "../../components/Hero/Hero";
import ProductCard from "../../components/ProductCard/ProductCard";
import Thumbs from "../../components/Thumbs/Thumbs";
import Description from "../../components/Description/Description";
import Checkout from "../../components/Checkout/Checkout";


function Details() {
  const { id } = useParams();
  const product = products.find((each) => each.id === id);
  const onsale = products.filter((each) => each.onsale);
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
        {onsale.map((each) => (
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
