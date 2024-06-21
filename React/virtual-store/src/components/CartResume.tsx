import { useEffect } from 'react';
import Swal from 'sweetalert2';
import { useSelector,useDispatch } from "react-redux";
import productsActions from "../store/actions/products";
const { clearProducts } = productsActions;

export default function CartResume() {
  // const { total } = props;
  const total = useSelector((store: any) => store.products.total);
  const cantidad = useSelector((store: any) => store.products.quantity);
  const dispatch = useDispatch();
  useEffect(() => {
    const buyButton = document.getElementById('buy')!;
    buyButton.addEventListener('click', handleBuy);

    return () => {
      buyButton.removeEventListener('click', handleBuy);
    };
  }, []);
  const handleBuy = () => {
    Swal.fire({
      title: '¿Quieres finalizar la compra?',
      showCancelButton: true,
      confirmButtonText: 'Sí',
      cancelButtonText: 'No',
      icon: 'question'
    }).then((result) => {
      if (result.isConfirmed) {
        // El usuario confirmó la compra
        localStorage.removeItem('cart');
        dispatch(clearProducts());
        Swal.fire('¡Compra realizada!', '', 'success');
      } else {
        // El usuario canceló la compra
        Swal.fire('Los productos siguen en el carrito', '', 'info');
      }
    });
  };
  return (
    <div className="w-[340px] h-[220px] flex flex-col justify-between rounded-md p-[30px] m-[10px] bg-[#f2f2f2]">
      <div className="flex-grow flex flex-col justify-between">
        <h2 className="flex justify-between text-[20px] font-bold">
          <span>Resumen</span>
          <span>del</span>
          <span>pedido</span>
        </h2>
        <div className="flex justify-between items-center">
          <h4>Cantidad</h4>
          <strong>{cantidad}</strong>
        </div>
        <div className="flex justify-between items-center">
          <h3>Total</h3>
          <strong>${total}</strong>
        </div>

        <small className="pb-[10px]">
          Incluye impuesto PAIS y percepción AFIP.
        </small>
      </div>
      <button
        className="w-full h-[40px] bg-[#ff3b3c] text-white font-bold border-0 rounded-md"
        id="buy"
        type="button"
      >
        COMPRAR
      </button>
    </div>
  );
}
