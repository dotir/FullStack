package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entidades.DetallePedido;
import entidades.Pedido;

public class pedidoDAO extends DAO {

    // guardar pedido
    public void guardarPedido(Pedido pedido, List<DetallePedido> detalles) throws SQLException, ClassNotFoundException {

        try {
            // Insertar el pedido
            String sqlPedido = "INSERT INTO pedido (codigo_pedido, fecha_pedido, fecha_esperada, fecha_entrega, estado, comentarios, id_cliente) "
                    +
                    "VALUES ('" + pedido.getCodigoPedido() + "', '"
                    + new java.sql.Date(pedido.getFechaPedido().getTime()) + "', '" +
                    new java.sql.Date(pedido.getFechaEsperada().getTime()) + "', " +
                    (pedido.getFechaEntrega() != null
                            ? "'" + new java.sql.Date(pedido.getFechaEntrega().getTime()) + "'"
                            : "NULL")
                    + ", '" +
                    pedido.getEstado() + "', '" + pedido.getComentarios() + "', " + pedido.getIdCliente() + ")";

            insertarModificarEliminarDataBase(sqlPedido);

            // Obtener el ID del pedido recién insertado
            String sqlLastId = "SELECT LAST_INSERT_ID()";
            ResultSet rs = consultarDataBase(sqlLastId);
            int idPedido = 0;
            if (rs.next()) {
                idPedido = rs.getInt(1);
            }

            // Insertar los detalles del pedido
            for (DetallePedido detalle : detalles) {
                String sqlDetalle = "INSERT INTO detalle_pedido (id_pedido, id_producto, cantidad, precio_unidad, numero_linea) "
                        +
                        "VALUES (" + idPedido + ", " + detalle.getIdProducto() + ", " + detalle.getCantidad() + ", " +
                        detalle.getPrecioUnidad() + ", " + detalle.getNumeroLinea() + ")";
                insertarModificarEliminarDataBase(sqlDetalle);
            }

            conexion.commit();
            System.out.println("Pedido guardado exitosamente con ID: " + idPedido);
        } catch (SQLException | ClassNotFoundException e) {
            if (conexion != null) {
                try {
                    conexion.rollback();
                } catch (SQLException ex) {
                    System.out.println("Error en rollback: " + ex.getMessage());
                }
            }
            System.out.println("Error al guardar el pedido: " + e.getMessage());
            throw e;
        } finally {
            desconectarDataBase();
        }
    }
}
