package persistencia;

import entidades.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class clienteDAO extends DAO {

    // crear metodo guardar cliente
    public void guardarCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO cliente (codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, ciudad, region, pais, codigo_postal, id_empleado, limite_credito) VALUES ('"
                + cliente.getCodigoCliente() + "', '" + cliente.getNombreCliente() + "', '"
                + cliente.getNombreContacto() + "', '" + cliente.getApellidoContacto() + "', '" + cliente.getTelefono()
                + "', '" + cliente.getFax() + "', '" + cliente.getCiudad() + "', '" + cliente.getRegion() + "', '"
                + cliente.getPais() + "', '" + cliente.getCodigoPostal() + "', '" + cliente.getIdEmpleado() + "', '"
                + cliente.getLimiteCredito() + "')";
        DAO dao = new DAO();
        dao.insertarModificarEliminarDataBase(sql);
    }

    // metodo listar clientes
    public void listarTodosLosClientes() throws SQLException, ClassNotFoundException {
        String sql = "SELECT id_cliente, nombre_contacto, apellido_contacto FROM cliente";
        DAO dao = new DAO();
        ResultSet resultSet = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            resultSet = dao.consultarDataBase(sql);
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("id_cliente"));
                cliente.setNombreContacto(resultSet.getString("nombre_contacto"));
                cliente.setApellidoContacto(resultSet.getString("apellido_contacto"));
                clientes.add(cliente);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.getStatement().close(); // Cierra el statement
                    resultSet.close(); // Cierra el ResultSet
                    dao.desconectarDataBase(); // Cierra la conexión
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        for (Cliente cliente : clientes) {
            // cliente.toString();
            System.out.println(cliente.toString());
        }
    }

    // Método para buscar un cliente por id_cliente
    public Cliente buscarClientePorCodigo(int codigo) throws SQLException, ClassNotFoundException {
        Cliente cliente = null;  // Inicializar el objeto cliente
        String sql = "SELECT * FROM cliente WHERE id_cliente = " + codigo;  // Consulta SQL

        try {
            ResultSet resultSet = consultarDataBase(sql);  // Ejecutar la consulta SQL

            if (resultSet.next()) {  // Si se encuentra el cliente con el id especificado
                cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("id_cliente"));
                cliente.setCodigoCliente(resultSet.getInt("codigo_cliente"));
                cliente.setNombreCliente(resultSet.getString("nombre_cliente"));
                cliente.setNombreContacto(resultSet.getString("nombre_contacto"));
                cliente.setApellidoContacto(resultSet.getString("apellido_contacto"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setFax(resultSet.getString("fax"));
                cliente.setCiudad(resultSet.getString("ciudad"));
                cliente.setRegion(resultSet.getString("region"));
                cliente.setPais(resultSet.getString("pais"));
                cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
                cliente.setIdEmpleado(resultSet.getInt("id_empleado"));
                cliente.setLimiteCredito(resultSet.getDouble("limite_credito"));

                // Imprimir la información completa del cliente utilizando el método toString
                System.out.println(cliente.toString());
            } else {
                System.out.println("Cliente con id_cliente " + codigo + " no encontrado.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al buscar el cliente: " + e.getMessage());
            throw e;
        } finally {
            desconectarDataBase();  // Asegurarse de cerrar la conexión
        }

        return cliente;  // Devolver el objeto cliente
    }
}
