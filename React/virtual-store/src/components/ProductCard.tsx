import { Link } from "react-router-dom";
import Product from "../interfaces/ProductCard";

export default function ProductCard({ id, title, price, color, image }: Product) {
  return (
    <Link className="bg-gray-200 text-gray-800 rounded-xl w-64 m-4 no-underline" to={"/details/" + id}>
      <img className="w-full h-64 object-cover object-center rounded-t-xl" src={image} alt={title} />
      <div className="p-5 box-border">
        <span className="text-xl font-bold leading-6 break-words block">{title}</span>
        <span className="text-xs font-normal text-gray-800 mb-1.5">{color}</span>
        <div className="flex my-1 justify-between items-center">
          <span className="text-xl font-bold">{price}</span>
          <span className="text-xs font-bold text-green-700">50% Off</span>
        </div>
        <div className="text-[10px] font-light">
          Includes Country tax and AFIP collection
        </div>
      </div>
    </Link>
  );
}