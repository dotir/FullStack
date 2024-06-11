import styles from "./OnSale.module.css";
import Footer from "../../components/Footer/Fotter";
import Hero from "../../components/Hero/Hero";
import NavBar from "../../components/NavBar/NavBar";
import OnSaleCard from "../../components/OnSaleCard/OnSaleCard";
import products from "../../../public/products.json";

function OnSale() {
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