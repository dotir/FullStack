import java.sql.SQLException;

public class TestDao extends DAO{
    public void probarConexion() {
        try {
            connectarDataBase();
            System.out.println("Conexión realizada correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error en la conexión: " + e.getMessage());
        } 
    }

    public void cerrarConexion() {
        try {
            desconectarDataBase();
            System.out.println("Conexión cerrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
