import Details from "./views/Details";
import Cart from "./views/Cart";
import Home from "./views/Home";
import OnSale from "./views/OnSale";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { Provider } from "react-redux";
import store from "./store/index";

function App() {
  const browserRouter = createBrowserRouter([
    { path: "/", element: <Home /> },
    { path: "/cart", element: <Cart /> },
    { path: "/details/:id", element: <Details /> },
    { path: "/onsale", element: <OnSale /> },
    { path: "*", element: <div>404</div>},
  ]);
  return (
    <Provider store={store}>
      <RouterProvider router={browserRouter} />
    </Provider>
  );
}
export default App;
