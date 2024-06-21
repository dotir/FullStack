import { createReducer } from "@reduxjs/toolkit";
import productsActions from "../actions/products";

const { captureText,calculateTotal,captureQuantity,clearProducts } = productsActions;

const initialState = {
    text: "",
    cantidad:0,
    total: 0,
};
const productsReducer = createReducer(
    initialState,
    (builder) => builder
        .addCase(
            captureText,
            (state, action) => {
                const newState = {
                    ...state,
                    text: action.payload.text
                };
                return newState;

            }
        )
        .addCase(
            calculateTotal,
            (state, action) => {
                const products = action.payload.products
                const subtotals = products.map((each) => each.price * each.units);
                const total = subtotals.reduce((acc: number, val: number) => acc + val, 0);
                const newState = {
                    ...state,
                    total,
                };
                return newState;
            }
        )
        .addCase(
            captureQuantity,
            (state, action) => {
                const products = action.payload.products;
                let quantity = 0;
                products.forEach((each) => {
                    quantity += each.units;
                });
                const newState = {
                    ...state,
                    quantity,
                };
                return newState;
            }
        )
        //clear products
        .addCase(
            clearProducts,
            (state) => {
                const newState = {
                    ...state,
                    total: 0,
                    quantity: 0,
                };
                return newState;
            }
        )
);

export default productsReducer;