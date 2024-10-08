// import entidades.Cliente;
import java.sql.SQLException;

import persistencia.clienteDAO;
import persistencia.productoDAO;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // instancia clienteDAO
        clienteDAO clienteDAO = new clienteDAO();

        // Cliente cliente1 = new Cliente("20", "Cliente 1", "Contacto 1", 
        //                             "Apellido 1", "123456789", "123456789",
        //         "Ciudad 1", "Region 1", "Pais 1", "12345", 
        //         1, 1000);
        // Cliente cliente2 = new Cliente("21", "Cliente 2", "Contacto 2", 
        //                             "Apellido 2", "123456789", "123456789",
        //         "Ciudad 2", "Region 2", "Pais 2", "12345", 
        //         2, 2000);
                
        // clienteDAO.guardarCliente(cliente1);
        // clienteDAO.guardarCliente(cliente2);
        // listar todos los clientes
        // clienteDAO.listarTodosLosClientes();

        // productoDAO productoDAO = new productoDAO();
        // try {
        //     // Eliminar un producto con id 5
        //     productoDAO.eliminarProductoPorCodigo(5);
        // } catch (SQLException | ClassNotFoundException e) {
        //     System.out.println("Error: " + e.getMessage());
        // }

        try {
            // Buscar un cliente con id_cliente 1
            clienteDAO.buscarClientePorCodigo(1);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
