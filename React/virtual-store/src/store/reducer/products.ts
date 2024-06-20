import { createReducer } from "@reduxjs/toolkit";
import productsActions from "../actions/products";


const { captureText,calculateTotal } = productsActions;

const initialState = {
    text: "",
    total: 0
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
                const total = subtotals.reduce((acc: number, val: number) => acc + val);
                const newState = {
                    ...state,
                    total,
                };
                return newState;
            }
        )
);

export default productsReducer;