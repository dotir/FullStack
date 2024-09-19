package GestionProductos;

import java.util.Scanner;

public class MenuInteractivo {
    private Cliente cliente;
    private Scanner scanner;

    public MenuInteractivo(Cliente cliente) {
        this.cliente = cliente;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("Menú Interactivo:");
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Ver el carrito");
            System.out.println("3. Realizar la compra");
            System.out.println("4. Salir del sistema");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarProductoAlCarrito();
                    break;
                case 2:
                    verCarrito();
                    break;
                case 3:
                    realizarCompra();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    private void agregarProductoAlCarrito() {
        // Simulación de productos disponibles
        ProductoElectronico laptop = new ProductoElectronico("Laptop", 1500, 5, "Laptop de última generación", "Dell", "XPS 13","plata");
        ProductoRopa camisa = new ProductoRopa("Camisa", 50, 10, "Camisa de algodón", "M", "Azul","algodón");

        System.out.println("Productos disponibles:");
        System.out.println("1. " + laptop.getNombre() + " - $" + laptop.getPrecio());
        System.out.println("2. " + camisa.getNombre() + " - $" + camisa.getPrecio());
        System.out.print("Seleccione un producto (1-2): ");
        int seleccion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Producto productoSeleccionado = null;
        if (seleccion == 1) {
            productoSeleccionado = laptop;
        } else if (seleccion == 2) {
            productoSeleccionado = camisa;
        } else {
            System.out.println("Selección no válida.");
            return;
        }

        System.out.print("Ingrese la cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        try {
            for (int i = 0; i < cantidad; i++) {
                cliente.agregarAlCarrito(productoSeleccionado);
            }
            System.out.println(cantidad + " unidades de " + productoSeleccionado.getNombre() + " agregadas al carrito.");
        } catch (ProductoAgotadoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void verCarrito() {
        System.out.println("Carrito de " + cliente.getNombre() + ":");
        double total = 0;
        for (Producto producto : cliente.getCarritoDeCompras()) {
            System.out.println(producto.getNombre() + " - $" + producto.calcularPrecio());
            total += producto.calcularPrecio();
        }
        System.out.println("Total: $" + total);
    }

    private void realizarCompra() {
        double total = 0;
        for (Producto producto : cliente.getCarritoDeCompras()) {
            total += producto.calcularPrecio();
        }
        System.out.println("Total de la compra: $" + total);
        System.out.println("Compra realizada con éxito.");
        cliente.getCarritoDeCompras().clear(); // Vaciar el carrito después de la compra
    }
}
