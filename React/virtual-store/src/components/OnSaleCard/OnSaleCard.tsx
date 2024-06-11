import styles from "./OnSaleCard.module.css";
import { Link } from "react-router-dom";

export default function OnSaleCard({ product }) {
    return (
        <Link className={styles["product-card"]} to={"/details/" + product.id}>
            <img className={styles["product-img"]} src={product.images[0] || "/mock1.jpg"} alt={product.title} />
            <div className={styles["product-info"]}>
                <span className={styles["product-title"]}>{product.title}</span>
                <span className={styles["product-description"]}>{product.color}</span>
                <div className={styles["product-price-block"]}>
                    <span className={styles["product-price"]}>{product.price}</span>
                    <span className={styles["product-discount"]}>50% Off</span>
                </div>
                <div className={styles["product-tax-policy"]}>
                    Includes Country tax and AFIP collection
                </div>
            </div>
        </Link>
    );
}