// import entidades.Cliente;
// import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.DetallePedido;
import entidades.Pedido;
// import persistencia.clienteDAO;
// import persistencia.productoDAO;
import servicios.PedidoServicio;


public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // instancia clienteDAO
        // clienteDAO clienteDAO = new clienteDAO();

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

        // try {
        //     // Buscar un cliente con id_cliente 1
        //     clienteDAO.buscarClientePorCodigo(1);
        // } catch (SQLException | ClassNotFoundException e) {
        //     System.out.println("Error: " + e.getMessage());
        // }

        //agregar pedido
        //testCrearPedido();

    }

    //metodo crear pedido
    public static void testCrearPedido() {
        PedidoServicio pedidoServicio = new PedidoServicio();

        try {
            // Crear un nuevo pedido
            Pedido pedido = new Pedido();
            pedido.setCodigoPedido(41);
            pedido.setFechaPedido(new Date());
            pedido.setFechaEsperada(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)); // 7 días después
            pedido.setEstado("En proceso");
            pedido.setComentarios("Pedido de prueba");
            pedido.setIdCliente(1); // Asegúrate de que este cliente exista en tu base de datos

            // Crear detalles del pedido
            List<DetallePedido> detalles = new ArrayList<>();
            
            DetallePedido detalle1 = new DetallePedido();
            detalle1.setIdProducto(1); // Asegúrate de que este producto exista en tu base de datos
            detalle1.setCantidad(2);
            detalle1.setPrecioUnidad(10.5);
            detalle1.setNumeroLinea(1);
            detalles.add(detalle1);

            DetallePedido detalle2 = new DetallePedido();
            detalle2.setIdProducto(2); // Asegúrate de que este producto exista en tu base de datos
            detalle2.setCantidad(1);
            detalle2.setPrecioUnidad(15.75);
            detalle2.setNumeroLinea(2);
            detalles.add(detalle2);

            pedidoServicio.guardarPedido(pedido, detalles);
            System.out.println("Pedido creado exitosamente");
        } catch (Exception e) {
            System.out.println("Error al crear el pedido: " + e.getMessage());
        }
    }

   


}
