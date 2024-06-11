import Footer from "../components/Footer/Fotter";
import Hero from "../components/Hero/Hero";
import NavBar from "../components/NavBar/NavBar";

function NotFound() {
  return (
    <>
      <NavBar />
      <Hero first="404" second="not found" />
      <Footer />
    </>
  );
}

export default NotFound;
