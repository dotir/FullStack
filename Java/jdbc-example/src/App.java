import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        TestDao dao = new TestDao();
        dao.probarConexion();
        buscarClientes(dao.getConexion());
        buscarClientePorCodigo(dao.getConexion(), 1);
        buscarClientesPorEmpleado(dao.getConexion(), 7);
        getProductosParaReponer(dao.getConexion(), 16);
        getProductosGama(dao.getConexion(), "Herramientas");
        //con preparedStatement
        System.out.println("Con preparedStatement");
        getPedidosPorCliente(dao.getConexion(), 1);
        getPedidosPorEstado(dao.getConexion(), "Entregado");
        dao.cerrarConexion();
    }

    public static void buscarClientes(Connection conexion) {
        String sql = "SELECT nombre_contacto, apellido_contacto, telefono FROM cliente ";
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            System.out.println("Clientes");
            while (rs.next()) {
                String nombre = rs.getString("nombre_contacto");
                String apellido = rs.getString("apellido_contacto");
                String telefono = rs.getString("telefono");
                count++;
                System.out.println(count + " - " + nombre + " " + apellido + " -  " + telefono);
            }
            // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    public static void buscarClientePorCodigo(Connection conexion, int codigo) {
        String sql = "SELECT nombre_contacto, apellido_contacto, telefono FROM cliente WHERE codigo_cliente = " + codigo;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Cliente con código " + codigo);
            if (rs.next()) {
                String nombre = rs.getString("nombre_contacto");
                String apellido = rs.getString("apellido_contacto");
                String telefono = rs.getString("telefono");
                System.out.println(nombre + " " + apellido + " -  " + telefono);
            } else {
                System.out.println("No se encontró el cliente con código " + codigo);
            }
            // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    public static void buscarClientesPorEmpleado(Connection conexion, int codigoEmpleado) {
        String sql = "SELECT nombre_contacto, apellido_contacto, telefono FROM cliente WHERE id_empleado = " + codigoEmpleado;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            System.out.println("Clientes del empleado con código " + codigoEmpleado);
            while (rs.next()) {
                String nombre = rs.getString("nombre_contacto");
                String apellido = rs.getString("apellido_contacto");
                String telefono = rs.getString("telefono");
                count++;
                System.out.println(count + " - " + nombre + " " + apellido + " -  " + telefono);
            }
            // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    public static void getProductosParaReponer(Connection conexion, int puntoReposicion) {
        String sql = "SELECT nombre, cantidad_en_stock FROM producto WHERE cantidad_en_stock < " + puntoReposicion;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            System.out.println("Productos por debajo del punto de reposición: " + puntoReposicion);
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int stock = rs.getInt("cantidad_en_stock");
                count++;
                System.out.println(count + " - " + nombre + " - Stock: " + stock);
            }
            // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    //Realiza un método llamado getProductosGama() que dado como parámetro el nombre de la gama, retorne una lista con la siguiente información:  códigos del producto, nombre del producto,  código y nombre de la gama.
    public static void getProductosGama(Connection conexion, String gama) {
        String sql = "SELECT p.codigo_producto, p.nombre, g.id_gama, g.gama FROM producto p JOIN gama_producto g ON p.id_gama = g.id_gama WHERE g.gama = '" + gama + "'";
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            System.out.println("Productos de la gama " + gama);
            while (rs.next()) {
                int codigoProducto = rs.getInt("codigo_producto");
                String nombreProducto = rs.getString("nombre");
                int idGama = rs.getInt("id_gama");
                String nombreGama = rs.getString("nombre");
                count++;
                System.out.println(count + " - " + codigoProducto + " - " + nombreProducto + " - " + idGama + " - " + nombreGama);
            }
            // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    // Realizar el método getPedidosPorCliente(idCliente);  en el cual se listen todos los pedidos de un cliente específico pasado por parámetro. No es necesario mostrar todos los campos de cada pedido. usar preparedStatement.
    public static void getPedidosPorCliente(Connection conexion, int idCliente) {
        String sql = "SELECT id_pedido, fecha_pedido, estado FROM pedido WHERE id_cliente = ?";
        try {
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, idCliente);
            ResultSet rs = pstmt.executeQuery();
            int count = 0;
            System.out.println("Pedidos del cliente con id " + idCliente);
            while (rs.next()) {
                int idPedido = rs.getInt("id_pedido");
                String fechaPedido = rs.getString("fecha_pedido");
                String estado = rs.getString("estado");
                count++;
                System.out.println(count + " - " + idPedido + " - " + fechaPedido + " - " + estado);
            }
            // Cerrar ResultSet y PreparedStatement dentro del bloque try-catch-finally
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    // Realizar un método getPedidosPorEstado(estado); que liste todos los pedidos que han quedado en un estado que se recibe por parámetro.
    public static void getPedidosPorEstado(Connection conexion, String estado) {
        String sql = "SELECT id_pedido, fecha_pedido, estado FROM pedido WHERE estado = ?";
        try {
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, estado);
            ResultSet rs = pstmt.executeQuery();
            int count = 0;
            System.out.println("Pedidos en estado " + estado);
            while (rs.next()) {
                int idPedido = rs.getInt("id_pedido");
                String fechaPedido = rs.getString("fecha_pedido");
                count++;
                System.out.println(count + " - " + idPedido + " - " + fechaPedido + " - " + estado);
            }
            // Cerrar ResultSet y PreparedStatement dentro del bloque try-catch-finally
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }


}
