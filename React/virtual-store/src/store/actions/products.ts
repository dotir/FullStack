import { createAction } from "@reduxjs/toolkit";

//action busqueda
const captureText = createAction(
    "captureText",
    (obj) => {
        return {
            payload: { text: obj.text }
        }
    }
);
//action total
const calculateTotal = createAction(
    "calculateTotal",
    (obj) => {
        return {
            payload: { products: obj.products }
        }
    }
);
//action cantidad
const captureQuantity = createAction(
    "captureQuantity",
    (obj) => {
        return {
            payload: { products: obj.products }
        }
    }
);
//action clear products
const clearProducts = createAction("clearProducts");
//action show products
const showProducts = createAction(
    "showProducts",
    (obj) => {
        return {
            payload: { products: obj.products }
        }
    }
);


const productsActions = { captureText, calculateTotal, captureQuantity, clearProducts, showProducts };

export default productsActions;