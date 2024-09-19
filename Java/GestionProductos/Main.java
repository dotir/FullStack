package GestionProductos;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Irving");
        MenuInteractivo menu = new MenuInteractivo(cliente);
        menu.mostrarMenu();
    }
}
