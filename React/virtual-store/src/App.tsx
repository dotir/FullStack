import Details from "./views/Details/Details";
import Cart from "./views/Cart/Cart";
import Home from "./views/Home/Home";
import OnSale from "./views/OnSale/OnSale";
import { createBrowserRouter, RouterProvider } from "react-router-dom";

function App() {
  const browserRouter = createBrowserRouter([
    { path: "/", element: <Home /> },
    { path: "/cart", element: <Cart /> },
    { path: "/details/:id", element: <Details /> },
    { path: "/onsale", element: <OnSale /> },
    { path: "*", element: <div>404</div>},
  ]);
  return (
    <>
      <RouterProvider router={browserRouter} />
    </>
  );
}
export default App;
