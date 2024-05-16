//navegador
const navSelector = document.getElementById("navbar");
const optionsnav = [
    { title: "Ofertas de la semana", linkTo: "./outlet.html" },
    { title: "Como comprar", linkTo: "./how.html" },
    { title: "Costos y tarifas", linkTo: "./taxs.html" },
    { title: "Mis pedidos", linkTo: "./orders.html" },
    { title: "Garantia", linkTo: "./warranty.html" },
];

for (let option of optionsnav) {
    const anchor = document.createElement("a");
    anchor.className = "nav-a"
    anchor.textContent = option.title
    anchor.href = option.linkTo
    navSelector.appendChild(anchor)
}
//footer
const footerSelector = document.querySelector("#footer");
const optionsfooter = [
    { title:"Ofertas", opts: ["Laptops", "Audio", "Auticulares"],linkTo:"./index.html" },
    { title:"Como comprar", opts: ["Formas de pago", "Envios", "Devoluciones"],linkTo:"./index.html" },
    { title:"Costos y tarifas", opts: ["Impuestos", "Facturacion"],linkTo:"./index.html" },
    { title:"Mis pedidos", opts: ["Pedir nuevamente", "Lista de deseos"],linkTo:"./index.html" },
    { title:"Garantia",opts: ["Politicas de garantia", "Politicas de devolucion"],linkTo:"./index.html" },
];

for (let option of optionsfooter) {
    const ul = document.createElement("ul");
    ul.classList.add("footer-ul");
  
    const mainItem = document.createElement("li");
    mainItem.classList.add("footer-main-item");
    const mainLink = document.createElement("a");
    mainLink.classList.add("footer-a");
    mainLink.href = option.linkTo;
    mainLink.textContent = option.title;
    mainItem.appendChild(mainLink);
    ul.appendChild(mainItem);
  
    for (let opt of option.opts) {
      const li = document.createElement("li");
      li.classList.add("footer-li");
      const link = document.createElement("a");
      link.classList.add("footer-a");
      link.href = option.linkTo;
      link.textContent = opt;
      li.appendChild(link);
      ul.appendChild(li);
    }
  
    footerSelector.appendChild(ul);
  }

