import { useState } from "react";
import styles from "./Thumbs.module.css";

export default function Thumbs({ product }) {
  const [thumb, setThumb] = useState(product.images[0] || "/mock1.jpg");

  return (
    <section className={styles["product-images-block"]}>
      <div className={styles["product-images"]}>
        {product.images.map((each) => (
          <img
            className={styles["mini-img"]}
            key={each}
            src={each}
            alt={product.title}
            onClick={() => setThumb(each)}
          />
        ))}
      </div>
      <img
        className={styles["big-img"]}
        id="big-img"
        src={thumb}
        alt={product.title}
      />
    </section>
  );
}
