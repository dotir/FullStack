package persistencia;

import java.sql.SQLException;

public class productoDAO extends DAO {
    
    // Método para eliminar un producto por id_producto
    public void eliminarProductoPorCodigo(int idProducto) throws SQLException, ClassNotFoundException {
        try {
            // Definir la consulta SQL para eliminar el producto por su id
            String sql = "DELETE FROM producto WHERE id_producto = " + idProducto;
            
            // Llamar al método de la clase padre para ejecutar la consulta
            insertarModificarEliminarDataBase(sql);
            
            System.out.println("Producto con id_producto " + idProducto + " eliminado exitosamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
            throw e;  // Re-lanza la excepción para manejarla en otros niveles si es necesario
        } finally {
            // Asegurarse de cerrar la conexión correctamente
            desconectarDataBase();
        }
    }
}
