import { configureStore } from "@reduxjs/toolkit";
import productsReducer from "./reducer/products";

const store = configureStore({
    reducer: {

        products: productsReducer

    },
});


export default store;