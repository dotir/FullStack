package servicios;

import java.sql.SQLException;
import java.util.List;

import entidades.DetallePedido;
import entidades.Pedido;
import persistencia.pedidoDAO;

public class PedidoServicio {

    private pedidoDAO pedidoDAO;

    public PedidoServicio() {
        this.pedidoDAO = new pedidoDAO();
    }


    public void guardarPedido(Pedido pedido, List<DetallePedido> detalles) throws Exception {
        try {
            // Validaciones
            if (pedido == null) {
                throw new IllegalArgumentException("El pedido no puede ser nulo");
            }
            if (detalles == null || detalles.isEmpty()) {
                throw new IllegalArgumentException("El pedido debe tener al menos un detalle");
            }
            if (pedido.getCodigoPedido() == 0) {
                throw new IllegalArgumentException("El código del pedido es obligatorio");
            }
            if (pedido.getFechaPedido() == null) {
                throw new IllegalArgumentException("La fecha del pedido es obligatoria");
            }
            if (pedido.getFechaEsperada() == null) {
                throw new IllegalArgumentException("La fecha esperada es obligatoria");
            }
            if (pedido.getFechaEsperada().before(pedido.getFechaPedido())) {
                throw new IllegalArgumentException("La fecha esperada no puede ser anterior a la fecha del pedido");
            }
            if (pedido.getEstado() == null || pedido.getEstado().trim().isEmpty()) {
                throw new IllegalArgumentException("El estado del pedido es obligatorio");
            }
            if (pedido.getIdCliente() <= 0) {
                throw new IllegalArgumentException("El ID del cliente debe ser un número positivo");
            }

            // Validar detalles del pedido
            for (DetallePedido detalle : detalles) {
                if (detalle.getIdProducto() <= 0) {
                    throw new IllegalArgumentException("El ID del producto debe ser un número positivo");
                }
                if (detalle.getCantidad() <= 0) {
                    throw new IllegalArgumentException("La cantidad debe ser un número positivo");
                }
                if (detalle.getPrecioUnidad() <= 0) {
                    throw new IllegalArgumentException("El precio unitario debe ser un número positivo");
                }
            }

            // Si todas las validaciones pasan, guardar el pedido
            pedidoDAO.guardarPedido(pedido, detalles);
        } catch (SQLException | ClassNotFoundException e) {
            throw new Exception("Error al crear el pedido: " + e.getMessage());
        }
    }
    
}
